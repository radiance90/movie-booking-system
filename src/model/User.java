package model;

public class User extends BaseMode {
	// ACCOUNTNAME VARCHAR(20) NOT NULL CONSTRAINT ACCOUNTNAME_PK PRIMARY KEY,
	// PASSWORD VARCHAR(20),
	// EMAIL VARCHAR(100),
	// NICKNAME VARCHAR(20),
	// FIRSTNAME VARCHAR(20),
	// LASTNAME VARCHAR(20),
	// BIRTHDAY VARCHAR(30), --
	// FAVOURITEGENRE VARCHAR(30),
	// FAVOURITECAST VARCHAR(30),
	// status varchar(20),
	// ROLE varchar(2)

	private String ACCOUNTNAME;
	private String PASSWORD;
	private String EMAIL;
	private String NICKNAME;
	private String FIRSTNAME;
	private String LASTNAME;
	private String status;
	private String ROLE;
	private String BIRTHDAY;
	private String FAVOURITEGENRE;
	private String FAVOURITECAST;

	public User(String aCCOUNTNAME, String pASSWORD, String eMAIL,
			String nICKNAME, String fIRSTNAME, String lASTNAME, String status,
			String rOLE) {
		super();
		ACCOUNTNAME = aCCOUNTNAME;
		PASSWORD = pASSWORD;
		EMAIL = eMAIL;
		NICKNAME = nICKNAME;
		FIRSTNAME = fIRSTNAME;
		LASTNAME = lASTNAME;
		this.status = status;
		ROLE = rOLE;
	}

	public User(String aCCOUNTNAME, String pASSWORD, String eMAIL) {
		super();
		ACCOUNTNAME = aCCOUNTNAME;
		PASSWORD = pASSWORD;
		EMAIL = eMAIL;
	}

	public User(String aCCOUNTNAME, String pASSWORD, String eMAIL, String rOLE,
			String status) {
		super();
		ACCOUNTNAME = aCCOUNTNAME;
		PASSWORD = pASSWORD;
		EMAIL = eMAIL;
		ROLE = rOLE; // here can be make constant
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String aCCOUNTNAME2, String pASSWORD2, String eMAIL2,
			String nICKNAME2, String fIRSTNAME2, String lASTNAME2,
			String status2, String rOLE2, String birthString,
			String fAVOURITEGENRE2, String fAVOURITECAST2) {
		// TODO Auto-generated constructor stub
		super();
		this.ACCOUNTNAME = aCCOUNTNAME2;
		this.PASSWORD = pASSWORD2;
		this.EMAIL = eMAIL2;
		this.NICKNAME = nICKNAME2;
		this.FIRSTNAME = fIRSTNAME2;
		this.LASTNAME = lASTNAME2;
		this.status = status2;
		this.ROLE = rOLE2;
		this.BIRTHDAY = birthString;
		this.FAVOURITEGENRE = fAVOURITEGENRE2;
		this.FAVOURITECAST = fAVOURITECAST2;
	}

	public String getBIRTHDAY() {
		return BIRTHDAY;
	}

	public void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}

	public String getFAVOURITEGENRE() {
		return FAVOURITEGENRE;
	}

	public void setFAVOURITEGENRE(String fAVOURITEGENRE) {
		FAVOURITEGENRE = fAVOURITEGENRE;
	}

	public String getFAVOURITECAST() {
		return FAVOURITECAST;
	}

	public void setFAVOURITECAST(String fAVOURITECAST) {
		FAVOURITECAST = fAVOURITECAST;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getACCOUNTNAME() {
		return ACCOUNTNAME;
	}

	public void setACCOUNTNAME(String aCCOUNTNAME) {
		ACCOUNTNAME = aCCOUNTNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getNICKNAME() {
		return NICKNAME;
	}

	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}

}
