package set_1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		
		//Optional<MachineData> opm = addToList();
		
		
		//Optional<MachineData> checkNull = addToList();
		

		/*if(!checkNull.isPresent()) {
			System.out.println("Empty");
		}*/
		
		addToList().ifPresent(md -> System.out.println(md.toString())) ;
		
	}
	
	public static Optional<MachineData> addToList() {
		
		Optional<MachineData> machineData = Optional.empty();
		//MachineData machineData ;
		
		//machineData = new MachineData("Frequency", 2.45, LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
		
		/*if(!Optional.of(machineData).isPresent()) {
			return Optional.empty();
		}*/
		
//		machineData = Optional.of(new MachineData("Frequency", 2.45, LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()))); 
		
		return machineData;
		
	}
	
	
}



/**
 * @author rajeswararao.pamarth
 *
 */
class MachineData {
	private String tag;
	private double value;
	private LocalDateTime timestamp;
	
	public MachineData() {
		super();
	}
	
	public MachineData(String tag, double value, LocalDateTime timestamp) {
		super();
		this.tag = tag;
		this.value = value;
		this.timestamp = timestamp;
	}

	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "MachineData [tag=" + tag + ", value=" + value + ", timestamp=" + timestamp + "]";
	}
	
	
	
}