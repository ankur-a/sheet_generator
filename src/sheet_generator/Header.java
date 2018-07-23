package sheet_generator;

public class Header {
	
	String state;
	String assessmentYear;
	String assessmentUnitType;
	String fileType;
	String view;
	String parentLocName;
	int verific_status;
	
	@Override
	public String toString() {
		return "GecHeaderData [state=" + state + ", assessmentYear="
				+ assessmentYear + ", assessmentUnitType=" + assessmentUnitType
				+ ", fileType=" + fileType + ", view=" + view
				+ ", parentLocName=" + parentLocName + "]";
	}

	public int getVerific_status() {
		return verific_status;
	}

	public void setVerific_status(int verific_status) {
		this.verific_status = verific_status;
	}

	public void setParentLocName(String parentLocName){
		this.parentLocName = parentLocName;
	}
	
	public String getParentLocName(){
		return this.parentLocName;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAssessmentYear() {
		return assessmentYear;
	}

	public void setAssessmentYear(String assessmentYear) {
		this.assessmentYear = assessmentYear;
	}

	public String getAssessmentUnitType() {
		return assessmentUnitType;
	}

	public void setAssessmentUnitType(String assessmentUnitType) {
		this.assessmentUnitType = assessmentUnitType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Header() {
		super();
	}

	public Header(String state, String assessmentYear,
			String assessmentUnitType, String fileType, String view , String parentLocName) {
		super();
		this.state = state;
		this.assessmentYear = assessmentYear;
		this.assessmentUnitType = assessmentUnitType;
		this.fileType = fileType;
		this.view = view;
		this.parentLocName = parentLocName;
	}
	
	

}