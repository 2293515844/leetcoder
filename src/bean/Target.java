package bean;

public class Target {
	long targetID;
	String boardNo;
	String targetType;
	String targetCountry;
	String sonarType;
	long lastEmergingTime;
	double lastEmergingLongitude;
	double lastEmergingLatitude;
	public long getTargetID() {
		return targetID;
	}
	public void setTargetID(long targetID) {
		this.targetID = targetID;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getTargetCountry() {
		return targetCountry;
	}
	public void setTargetCountry(String targetCountry) {
		this.targetCountry = targetCountry;
	}
	public String getSonarType() {
		return sonarType;
	}
	public void setSonarType(String sonarType) {
		this.sonarType = sonarType;
	}
	public long getLastEmergingTime() {
		return lastEmergingTime;
	}
	public void setLastEmergingTime(long lastEmergingTime) {
		this.lastEmergingTime = lastEmergingTime;
	}
	public double getLastEmergingLongitude() {
		return lastEmergingLongitude;
	}
	public void setLastEmergingLongitude(double lastEmergingLongitude) {
		this.lastEmergingLongitude = lastEmergingLongitude;
	}
	public double getLastEmergingLatitude() {
		return lastEmergingLatitude;
	}
	public void setLastEmergingLatitude(double lastEmergingLatitude) {
		this.lastEmergingLatitude = lastEmergingLatitude;
	}
	
}
