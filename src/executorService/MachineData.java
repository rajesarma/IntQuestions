package executorService;

import java.util.Date;

public class MachineData {

	private MachineDataKey pk;
	
	private double value;

	public String getMachineId(){
		return this.pk == null ? null : this.pk.getMachineId();
	}
	
	public Date getTimestamp(){
		return this.pk == null ? null : this.pk.getTimestamp();
	}

	public MachineData() {}
	public MachineData(MachineDataKey pk, double value) {
		super();
		this.pk = pk;
		this.value = value;
	}
	public static MachineData of(String machineId, Date timestamp, String tagName, double value){
		return new MachineData(new MachineDataKey(machineId, timestamp, tagName), value);
	}
	
	@Override
	public String toString() {
		return "MachineData [pk=" + pk + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MachineData other = (MachineData) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
	
	public MachineDataKey getPk() {
		return pk;
	}

	public void setPk(MachineDataKey pk) {
		this.pk = pk;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
