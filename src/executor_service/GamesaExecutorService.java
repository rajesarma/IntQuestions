package executor_service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GamesaExecutorService {
	
	public static void main(String[] args) {
		File file = new File("D:\\Burgula LTT Jan 2018 - empty cells.xlsx");
		
		//System.gc();
		
		try {
			
			String result = readFile(file, file.getName(), "Gamesa");
			
			System.out.println(result);
			
		} catch (FileUploadException e) {
			
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
	}
	

	public static String readFile(File file, String fileName, String machineType) 
			throws InterruptedException, ExecutionException, FileUploadException {
		
		XSSFWorkbook workbook;
		List<MachineData1> dataList = new ArrayList<>();

		long startTs = System.currentTimeMillis();

		try {

			workbook = new XSSFWorkbook(file);
			dataList = getGamesaData(workbook, machineType);
				
		} catch (InvalidFormatException e) {
				
			e.printStackTrace();
		} catch (IOException  e) {	//| InterruptedException | ExecutionException
			e.printStackTrace();
		}

		return "Total Rows : " + dataList.size() + ", Duration : " + (System.currentTimeMillis() - startTs);
	}


	private static List<MachineData1> getGamesaData(XSSFWorkbook workbook, String machineType) 
			throws InterruptedException, ExecutionException, FileUploadException {
	
		ExecutorService pool = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() + 1);

		List<MachineData1> dataList = new ArrayList<>();
		List<Future<List<MachineData1>>> futuresList = new ArrayList<>();
		//Sheet sheet;
//		final AtomicBoolean running = new AtomicBoolean(false);
		final AtomicBoolean running = new AtomicBoolean(false);
		DataFormatter formatter = new DataFormatter();
		
		for(Sheet sheet : workbook) {
			
			Callable<List<MachineData1>> machineDataCallable = () -> {
				
				String machine = sheet.getSheetName();
				Date timestamp = null;
				
					for (Row r : sheet) {
						
						if(running.get()) {
							//System.out.println(sheet.getSheetName()+ " Done!");
			                break;
						}
						
						if (r.getRowNum() <= 5) {
							continue;
						}
						
	
						for (int col = 0; col < r.getLastCellNum() - 1; col++) {
	
							Cell cell = r.getCell(col, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	
//							System.out.println(sheet.getSheetName()+ ", "+cell.getAddress());
	
							String columnIndex = CellReference.convertNumToColString(cell.getColumnIndex());
							
							
							String dateCol = "B";
							String timestampColumn="";
							
							if (r.getRowNum() == 5 && columnIndex.equalsIgnoreCase(dateCol)) {
								timestampColumn = dateCol;
							}
							
							
							if (columnIndex.equalsIgnoreCase(dateCol)) {
	
								if (cell.getCellType() == CellType.NUMERIC) {
									timestamp = cell.getDateCellValue();
								} else {
									running.set(true);
									String value = formatter.formatCellValue(cell);
									String message = "Cannot read Date value in "
											+ " Sheet: '" + sheet.getSheetName() + "', "
											+ " Row: " + (r.getRowNum() + 1) + ", Value cannot "
											+ " be " + (value.length() > 0 ? value : "empty");
									throw new FileUploadException(message);
								}
							}
							
							if ((timestamp == null) || columnIndex.equals(timestampColumn)) {
								continue;
							}
							
							machineDataOptional(formatter, cell, machine, timestamp).ifPresent(dataList::add);
						}
				}
					
				System.out.println("Completed : "+ sheet.getSheetName()+ ", Size : "+dataList.size());
				
				return dataList;
			};
			
			Future<List<MachineData1>> future = pool.submit(machineDataCallable);
			futuresList.add(future);
		}
		
		/*for (int sheetNo = 0; sheetNo < workbook.getNumberOfSheets(); sheetNo++) {
			sheet = workbook.getSheetAt(sheetNo);
	
			Future<List<MachineData1>> future = pool.submit(new ReadSheets(sheet));
			futuresList.add(future);
		}
	
		for (Future<List<MachineData1>> future : futuresList) {
			dataList.addAll(future.get());
		}*/
		
		return dataList;
	}

	private static class ReadSheets implements Callable<List<MachineData1>> {
		private Sheet sheet;

		ReadSheets(final Sheet s) {
			this.sheet = s;
		}

		@Override
		public List<MachineData1> call() throws FileUploadException {

			List<MachineData1> dataList = new ArrayList<>();
			String machine = sheet.getSheetName();
			DataFormatter formatter = new DataFormatter();
			Date timestamp = null;

			for (Row r : sheet) {
				
				if (r.getRowNum() <= 5) {
					continue;
				}

				for (int col = 0; col < r.getLastCellNum() - 1; col++) {

					Cell cell = r.getCell(col, MissingCellPolicy.CREATE_NULL_AS_BLANK);

					System.out.println(sheet.getSheetName()+ ", "+cell.getAddress());

					String columnIndex = CellReference.convertNumToColString(cell.getColumnIndex());
					
					
					String dateCol = "B";
					String timestampColumn="";
					
					if (r.getRowNum() == 5 && columnIndex.equalsIgnoreCase(dateCol)) {
						timestampColumn = dateCol;
					}
					
					
					if (columnIndex.equalsIgnoreCase(dateCol)) {
						
						if (cell.getCellType() == CellType.NUMERIC) {
							timestamp = cell.getDateCellValue();
						} else {

							String value = formatter.formatCellValue(cell);
							String message = "Cannot read Date value in "
									+ " Sheet: '" + sheet.getSheetName() + "', "
									+ " Row: " + (r.getRowNum() + 1) + ", Value cannot "
									+ " be " + (value.length() > 0 ? value : "empty");

							throw new FileUploadException(message);
						}
					}
					
					if ((timestamp == null) || columnIndex.equals(timestampColumn)) {
						continue;
					}
					

					machineDataOptional(formatter, cell, machine, timestamp).ifPresent(dataList::add);
				}
			}
			System.out.println("Completed : "+ sheet.getSheetName());
			return dataList;
		}
	}
	
	private static Optional<MachineData1> machineDataOptional(
			final DataFormatter formatter,
			final Cell cell, final String machine, final Date timestamp) {

		//String columnIndex = CellReference.convertNumToColString(cell.getColumnIndex());

		if (cell.getCellType() == CellType.NUMERIC && formatter.formatCellValue(cell).length() > 0) {

			double value = cell.getNumericCellValue();
			MachineData1 machineData1 = MachineData1.of(machine, value);

			return Optional.of(machineData1);
		}

		return Optional.empty();
	}
	
	
	static final class FileUploadException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		FileUploadException(String message) {
			super(message);
		}

		FileUploadException(String message, Throwable cause) {
			super(message, cause);
		}
	}
	
}


class MachineData1 {

	private String machineId;
	
	private double value;

	public MachineData1() {}
	public MachineData1(String machineId, double value) {
		super();
		this.machineId = machineId;
		this.value = value;
	}
	
	public static MachineData1 of(String machineId, double value){
		return new MachineData1(machineId, value);
	}
	
	@Override
	public String toString() {
		return "MachineData [machineId=" + machineId + ", value=" + value + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
