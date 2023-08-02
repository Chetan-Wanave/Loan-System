package LoanModel;

public class LoanModel {
	private float loanAmount;
	private long adhaar;
	private String pan;
	private long accountno;
	private String ifsc;
	
	public LoanModel(float loanAmount, long adhaar, String pan, long accountno, String ifsc) {
		super();
		this.loanAmount = loanAmount;
		this.adhaar = adhaar;
		this.pan = pan;
		this.accountno = accountno;
		this.ifsc = ifsc;
	}
	
	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public long getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(long adhaar) {
		this.adhaar = adhaar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
}
