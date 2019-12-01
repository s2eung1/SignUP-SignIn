
public class SignUpDTO {
	private String SchoolID;
	private String PW;
	private String name;
	
	public SignUpDTO() {
		super();
		this.SchoolID = "";
		this.PW = "";
		this.name = "";
	}
	
	public SignUpDTO(String schoolID, String pW, String name) {
		super();
		this.SchoolID = schoolID;
		this.PW = pW;
		this.name = name;
	}
	public String getSchoolID() {
		return SchoolID;
	}
	public void setSchoolID(String schoolID) {
		SchoolID = schoolID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
