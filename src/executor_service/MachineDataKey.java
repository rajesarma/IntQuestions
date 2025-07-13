package executor_service;

import java.io.Serializable;
import java.util.Date;

public class MachineDataKey implements Serializable{

	private static final long serialVersionUID = -8906357755235019506L;
	
	private String machineId;
	
	private String tagName;
	
	private Date timestamp;
	
	public MachineDataKey(String machineId, Date timestamp, String tagName) {
		super();
		this.machineId = machineId;
		this.timestamp = timestamp;
		this.tagName = tagName;
	}
	
	@Override
	public String toString() {
		return "MachineDataKey [machineId=" + machineId + ", tagName=" + tagName + ", timestamp=" + timestamp + "]";
	}

	public MachineDataKey() {}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((machineId == null) ? 0 : machineId.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		MachineDataKey other = (MachineDataKey) obj;
		if (machineId == null) {
			if (other.machineId != null)
				return false;
		} else if (!machineId.equals(other.machineId))
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
}
