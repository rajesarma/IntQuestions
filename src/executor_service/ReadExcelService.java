package executor_service;

import com.mytrah.exception.ExcelException;
import com.mytrah.gmc.engine.historic.data.MachineData;
import com.mytrah.gmc.engine.historic.data.MachineDataService;
import com.mytrah.util.Constants.Header;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReadExcelService {

	/*@Value("${spring.tagmachine.setup.filename}")
	String tagMachineSetupFileName;*/

	/*@Autowired
	private Environment env;*/

	private final MachineDataService machineDataService;

	@Autowired
	public ReadExcelService(MachineDataService machineDataService) {
		this.machineDataService = machineDataService;
	}

	public String readFile(byte[] file, String fileName, String machineType) {
		XSSFWorkbook workbook;
		List<MachineData> dataList = new ArrayList<>();

		long duration = 0;
		long startTs = System.currentTimeMillis();

		try {

//			workbook = new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile(tagMachineSetupFileName) ));
//			workbook = new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile(env.getProperty("spring.tagmachine.setup.filename")) ));

			workbook =
					new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile(Header.SPRING_TAGMACHINE_SETUP_FILENAME)));

			Map<String, String> headersMap = readHeaders(workbook, machineType);

			workbook = new XSSFWorkbook(new ByteArrayInputStream(file));

			if (machineType.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GE)) {
				dataList = getGeData(workbook, headersMap, machineType);
			} else if (machineType.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_SUZLON)) {
				dataList = getSuzlonData(workbook, headersMap, fileName, machineType);
			} else if (machineType.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GAMESA)) {
				//long startTs = System.currentTimeMillis();
				dataList = getGamesaData(workbook, headersMap, machineType);
			}

			/*for(MachineData md : dataList)
			{
				System.out.println(md.toString());
			}*/

			for(int l=0;l<100; l++)
			{
				MachineData md = dataList.get(l);
				System.out.println(md.toString());
			}
			System.out.println("Total Rows : "+dataList.size());

			//Future<Long> dur = machineDataService.ingestData(dataList);
			//duration = dur.get();

		} catch (IOException  e) {	//| InterruptedException | ExecutionException
			e.printStackTrace();
		}

		System.out.println( " Duration : "+ (System.currentTimeMillis() - startTs) );

		return "Total Rows : " + dataList.size() + ", Duration : " + duration;
	}

	private Map<String, String> readHeaders(XSSFWorkbook workbook, String type) {
		Map<String, String> headersMap = new HashMap<>();
		DataFormatter formatter = new DataFormatter();

		String columns[] = {};
		//String[] columns = getColumnNames(type);

		if (type.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GE)) {
//			columns = env.getProperty("spring.tagmachine.type.ge.columns").split(",");
			columns = Header.SPRING_TAGMACHINE_TYPE_GE_COLUMNS.split(",");
		} else if (type.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_SUZLON)) {
//			columns = env.getProperty("spring.tagmachine.type.suzlon.columns").split(",");
			columns = Header.SPRING_TAGMACHINE_TYPE_SUZLON_COLUMNS.split(",");
		} else if (type.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GAMESA)) {
//			columns = env.getProperty("spring.tagmachine.type.gamesa.columns").split(",");
			columns = Header.SPRING_TAGMACHINE_TYPE_GAMESA_COLUMNS.split(",");
		}

		int LttColumn = CellReference.convertColStringToIndex(columns[0]);
		int gmcColumn = CellReference.convertColStringToIndex(columns[1]);

		Sheet sheet = workbook.getSheetAt(0);    // First Sheet
		for (Row r : sheet) {
			if (r.getRowNum() > 0) {
				if (r.getCell(LttColumn) != null && r.getCell(LttColumn).getCellType() != Cell.CELL_TYPE_BLANK) {
					headersMap.put(formatter.formatCellValue(r.getCell(LttColumn)), formatter.formatCellValue(r.getCell(gmcColumn)).replace("_AVG", "").replace("_VECTOR", ""));    //.getStringCellValue()
				}
			}
		}

		return headersMap;
	}

	private static Heading getHeaders(XSSFWorkbook workbook, Map<String, String> tagMachineMap, String machineType)    //
	{
//		This method checks data workbook headers with the headers specified as Tagmachine Map.
//		If Headers not matched then it throws an exception.
//		It also checks, in how many sheets it has to check for the headers.

		Map<String, String> headersMap = new HashMap<>();
		Map<String, String> headersColumnMap = new HashMap<>();
		int[] sheetNos = {};

		DataFormatter formatter = new DataFormatter();
		boolean isHeadersRowFound = false;
		int headerRow = 0;

		if (machineType.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GE)) {    // Since Site is used as System as a
			// key in Tagmachinesetup excel file
			tagMachineMap.put("System", tagMachineMap.get("site"));
//			int[] sheets =
//					Arrays.stream(Header.SPRING_TAGMACHINE_TYPE_GE_DATA_SHEET_NOS.split(",")).mapToInt(Integer::parseInt).toArray();
			sheetNos = Header.SPRING_TAGMACHINE_TYPE_GE_DATA_SHEET_NOS;
		}
		else if (machineType.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GAMESA)) {
//			int[] sheets =
//					Arrays.stream(Header.SPRING_TAGMACHINE_TYPE_GAMESA_DATA_SHEET_NOS.split(",")).mapToInt(Integer::parseInt).toArray();
			sheetNos = Header.SPRING_TAGMACHINE_TYPE_GAMESA_DATA_SHEET_NOS;
		}
		else if (machineType.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_SUZLON)) {
//			int[] sheets =
//					Arrays.stream(Header.SPRING_TAGMACHINE_TYPE_SUZLON_DATA_SHEET_NOS.split(",")).mapToInt(Integer::parseInt).toArray();
			sheetNos = Header.SPRING_TAGMACHINE_TYPE_SUZLON_DATA_SHEET_NOS;
		}
//		System.out.println("sheetNos : "+sheetNos.length);
		//for (int sheetNo = 0; sheetNo < workbook.getNumberOfSheets(); sheetNo++)    // Sheets

		for (int sheetNo = 0; sheetNo < sheetNos.length; sheetNo++)    // Sheets
		{
			//Sheet sheet = workbook.getSheetAt(sheetNo);

			Sheet sheet = workbook.getSheetAt(sheetNos[sheetNo]);
			for (Row r : sheet)    // Rows
			{
				for (Cell cell : r)    // Cells
				{
					if (tagMachineMap.containsKey(formatter.formatCellValue(cell))) {
						headersMap.put(formatter.formatCellValue(cell), CellReference.convertNumToColString(cell.getColumnIndex()));
						headersColumnMap.put(CellReference.convertNumToColString(cell.getColumnIndex()), formatter.formatCellValue(cell));
						headerRow = r.getRowNum();
						isHeadersRowFound = true;
					}
				}
				if (isHeadersRowFound) {
					break;
				}
			}
		}

		if(!isHeadersRowFound)
			throw new ExcelException("Incompatible File selected");

		return Heading.of(headerRow, headersMap, headersColumnMap);
	}

	// GE Data
	private static List<MachineData> getGeData(XSSFWorkbook workbook, Map<String, String> tagMachineMap,
			String machineType) {

		DataFormatter formatter = new DataFormatter();
		String site = "";
		Date timeStamp = null;
		String systemCol = "";
		String timeStampCol = "";

		Map<String, String> headersMap;
		Map<String, String> headersColumnMap;

		Heading header = getHeaders(workbook, tagMachineMap, machineType);
		headersMap = header.getHeaderMapping();    // Contains column no.s
		headersColumnMap = header.getHeaderColumnsMapping();
		int headerRow = header.getHeaderRowIndex();
		List<MachineData> dataList = new ArrayList<>();

		for (int sheetNo = 0; sheetNo < workbook.getNumberOfSheets(); sheetNo++) {
			Sheet sheet = workbook.getSheetAt(sheetNo);
			for (Row r : sheet) {
				if (r.getRowNum() > headerRow) {
					if (r.getRowNum() == (headerRow + 1)) {
						for (Cell cell : r) {

							// For getting Site (which is a merged column for all rows)
							if (CellReference.convertNumToColString(cell.getColumnIndex()).equals(headersMap.get("System"))) {
								systemCol = headersMap.get("System");
								site = formatter.formatCellValue(cell).length() > 0 ? formatter.formatCellValue(cell) : site;
							} else if (CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Timestamp"))) {
								timeStampCol = headersMap.get("Timestamp");
							}
						}
					}
					for (Cell cell : r) {
						// For getting TimeStamp
						if (CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(timeStampCol)) {
							timeStamp = cell.getDateCellValue();
						}

						/*for (String column : headersMap.values()) {
							if (CellReference.convertNumToColString(cell.getColumnIndex()).equals(column)) {//Check
								// with Cell Column

								if (!column.equals(systemCol) && !column.equals(timeStampCol)) {
									if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {
										dataList.add(MachineData.of(site, timeStamp,
												tagMachineMap.get(headersColumnMap.get(column)),
												cell.getNumericCellValue()));
									} else {
										dataList.add(MachineData.of(site, timeStamp,
												tagMachineMap.get(headersColumnMap.get(column)), 0));
									}
								}
							}
						}*/

						String column = CellReference.convertNumToColString(cell.getColumnIndex());
						if(headersColumnMap.containsKey(column)) {
							if (!column.equals(systemCol) && !column.equals(timeStampCol)) {
								if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {

									if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
										dataList.add(MachineData.of(site, timeStamp,
												tagMachineMap.get(headersColumnMap.get(column)),
												cell.getNumericCellValue()));
									}
								}
							}
						}

					}// Cells
				}
			} // Rows
		}// Sheets

		return dataList;
	}

	private static List<MachineData> getGamesaData(XSSFWorkbook workbook, Map<String, String> tagMachineMap,
			String machineType) {
		DataFormatter formatter = new DataFormatter();
		String site;
		String timeStampCol = "";
		Date timeStamp = null;

		Heading header = getHeaders(workbook, tagMachineMap, machineType);
		Map<String, String> headersMap = header.getHeaderMapping();
		Map<String, String> headersColumnMap = header.getHeaderColumnsMapping();
		int headerRow = header.getHeaderRowIndex();

		List<MachineData> dataList = new ArrayList<>();

		// Iteration for Data
		for (int sheetNo = 0; sheetNo < workbook.getNumberOfSheets(); sheetNo++) {
			Sheet sheet = workbook.getSheetAt(sheetNo);
			site = sheet.getSheetName();

			for (Row r : sheet) {
				if (r.getRowNum() > headerRow) {
					if (r.getRowNum() == (headerRow + 1)) {
						for (Cell cell : r) {
							if (CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Date"))) {
								timeStampCol = headersMap.get("Date");
							}
						}
					}
					for (Cell cell : r) {
						if (CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Date"))) {
							if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {
								timeStamp = cell.getDateCellValue();
							}
						}
						/*for (String column : headersMap.values()) {
							if (CellReference.convertNumToColString(cell.getColumnIndex()).equals(column))//Check //// with Cell Column
							{
								if (!column.equals(timeStampCol)) {
									if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {
										dataList.add(MachineData.of(site, timeStamp,
												tagMachineMap.get(headersColumnMap.get(column)),
												cell.getNumericCellValue()));
									} else {
										dataList.add(MachineData.of(site, timeStamp,
												tagMachineMap.get(headersColumnMap.get(column)), 0));
									}

								}
							}
						}*/

						addToDataList(dataList, headersColumnMap,tagMachineMap, timeStampCol, formatter, cell, site,
								timeStamp);
					}// Cells
				}
			} // Rows
		}// Sheets
		// Iteration for Data

		return dataList;
	}

	private static List<MachineData> getSuzlonData(XSSFWorkbook workbook, Map<String, String> tagMachineMap,
			String fileName, String machineType) {
		DataFormatter formatter = new DataFormatter();
		Date timeStamp = null;
		List<MachineData> dataList = new ArrayList<>();

		String timeStampCol = "";

		// Ex. Site Name MK014 for LTT-EVT-MK014-01-2018.xlsx

		if(fileName.split("-").length>2 && fileName.startsWith("LTT-EVT")) {

			String site = fileName.split("-")[2];

			Heading header = getHeaders(workbook, tagMachineMap, machineType);
			Map<String, String> headersMap = header.getHeaderMapping();
			Map<String, String> headersColumnMap = header.getHeaderColumnsMapping();
			int headerRow = header.getHeaderRowIndex();

			// Iteration for Data
			Sheet sheet = workbook.getSheet("LTT");
			for (Row r : sheet) {

				if (r.getRowNum() > headerRow) {
					if (r.getRowNum() == (headerRow + 1)) {
						for (Cell cell : r) {
							if (CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Time"))) {
								timeStampCol = headersMap.get("Time");
							}
						}
						//System.out.println("timeStampCol : "+timeStampCol);
					}
					for (Cell cell : r) {
						if (CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Time"))) {
							if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {
								//timeStamp = ZonedDateTime.parse(formatter.formatCellValue(cell)).toInstant().getEpochSecond();
								timeStamp = Date.from(ZonedDateTime.parse(formatter.formatCellValue(cell)).toInstant());
							}
						}

						addToDataList(dataList, headersColumnMap, tagMachineMap, timeStampCol, formatter, cell, site,
								timeStamp);

//					for (String column : headersMap.values()) {
//						if (CellReference.convertNumToColString(cell.getColumnIndex()).equals(column))//Check with Cell Column
//						{
//							/*if(CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Time")) ) {
//								dataMap.put(tagMachineMap.get(headersColumnMap.get(column)), timeStamp+"" );
//							}
//							else {
//								dataMap.put(tagMachineMap.get(headersColumnMap.get(column)), formatter.formatCellValue(cell) );
//							}*/
//							if (!column.equals(timeStampCol)) {
//								if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {
//									dataList.add(MachineData.of(site, timeStamp,
//											tagMachineMap.get(headersColumnMap.get(column)),
//											cell.getNumericCellValue()));
//								} else {
//									dataList.add(MachineData.of(site, timeStamp,
//											tagMachineMap.get(headersColumnMap.get(column)), 0));
//								}
//							}
//						}
//					}

					}// Cells
					//dataMap.put("site", site );
				}

			} // Rows
		}
		else{
			throw new ExcelException("Incorrect File Selected. Please check the file");
		}


		return dataList;
	}

	private static void addToDataList(List<MachineData> dataList, Map<String, String> headersColumnMap,
			Map<String, String> tagMachineMap, String timeStampCol,
			DataFormatter formatter, Cell cell, String site, Date timeStamp)
	{
		String column = CellReference.convertNumToColString(cell.getColumnIndex());
		if(headersColumnMap.containsKey(column)) {
			if (!column.equals(timeStampCol)) {
				if (cell.getCellType() != Cell.CELL_TYPE_BLANK && formatter.formatCellValue(cell).length() > 0) {

					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						dataList.add(MachineData.of(site, timeStamp,
								tagMachineMap.get(headersColumnMap.get(column)),
								cell.getNumericCellValue()));
					}
				}
			}
		}
	}

	private static final class Heading {

		private final int headerRowIndex;
		private final Map<String, String> headerMapping;
		private final Map<String, String> headerColumnsMapping;

		private Heading(Integer headerRow, Map<String, String> headersMap, Map<String, String> headerColumnsMap) {
			this.headerRowIndex = headerRow;
			this.headerMapping = headersMap;
			this.headerColumnsMapping = headerColumnsMap;
		}

		private static Heading of(Integer headerRow, Map<String, String> headersMap,
				Map<String, String> headerColumnsMap) {
			return new Heading(headerRow, headersMap, headerColumnsMap);
		}

		private int getHeaderRowIndex() {
			return headerRowIndex;
		}

		private Map<String, String> getHeaderMapping() {
			return headerMapping;
		}

		private Map<String, String> getHeaderColumnsMapping() {
			return headerColumnsMapping;
		}
	}

}
	/*private static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}*/

	/*private String[] getColumnNames(String type){
		String columns[] = {};

		// Get these values from properties file later

		if( type.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GE)){
//			columns = env.getProperty("spring.tagmachine.type.ge.columns").split(",");
			columns = Header.SPRING_TAGMACHINE_TYPE_GE_COLUMNS.split(",");
		}

		else if( type.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_SUZLON)){
//			columns = env.getProperty("spring.tagmachine.type.suzlon.columns").split(",");
			columns = Header.SPRING_TAGMACHINE_TYPE_SUZLON_COLUMNS.split(",");
		}

		else if( type.equalsIgnoreCase(Header.SPRING_TAGMACHINE_TYPE_GAMESA)){
//			columns = env.getProperty("spring.tagmachine.type.gamesa.columns").split(",");
			columns = Header.SPRING_TAGMACHINE_TYPE_GAMESA_COLUMNS.split(",");
		}

//		System.out.println(columns);

		return columns;
	}*/
	
//GE Code Removed
//System.out.println(CellReference.convertNumToColString(cell.getColumnIndex()));

/*if(!CellReference.convertNumToColString(cell.getColumnIndex()).equals(headersMap.get(
		"System")) )
{

}
else if(!CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Timestamp")) )
{

}
else{*/

/*if(CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("System")) ) {
	dataMap.put(tagMachineMap.get(headersColumnMap.get(column)), site );

}
else if(CellReference.convertNumToColString(cell.getColumnIndex()).equalsIgnoreCase(headersMap.get("Timestamp")) ) {
	dataMap.put(tagMachineMap.get(headersColumnMap.get(column)), timeStamp.getTime()+"" );
}
else {
	dataMap.put(tagMachineMap.get(headersColumnMap.get(column)), formatter.formatCellValue(cell) );
}*/
//GE Code Removed