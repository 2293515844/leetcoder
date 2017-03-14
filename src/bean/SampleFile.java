package bean;

public class SampleFile {
	String sampleFileName;
	long smpleFileRecordTime;
	String arrayDataFilename;
	long targetID;
	
	public String getSampleFileName() {
		return sampleFileName;
	}
	public void setSampleFileName(String sampleFileName) {
		this.sampleFileName = sampleFileName;
	}
	public long getSmpleFileRecordTime() {
		return smpleFileRecordTime;
	}
	public void setSmpleFileRecordTime(long smpleFileRecordTime) {
		this.smpleFileRecordTime = smpleFileRecordTime;
	}
	
	public String getArrayDataFilename() {
		return arrayDataFilename;
	}
	public void setArrayDataFilename(String arrayDataFilename) {
		this.arrayDataFilename = arrayDataFilename;
	}
	public long getTargetID() {
		return targetID;
	}
	public void setTargetID(long targetID) {
		this.targetID = targetID;
	}
	
}
