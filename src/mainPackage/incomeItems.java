package mainPackage;

public class incomeItems {
	private String datex;
	private String investor;
	private String amount;
	
	
	public incomeItems(){
		this.datex = "";
		this.investor = "";
		this.amount = "";
		
	}
	
	public incomeItems(String d, String in, String a){
		this.datex = d;
		this.investor = in;
		this.amount = a;
	}
	
	public String getDatex(){
		return datex;
	}
	
	public void setDatex(String d){
		this.datex = d;
	}
	
	public String getInvestor(){
		return investor;
	}
	
	public void setInvestor(String in){
		this.investor = in;
	}
	
	public String getAmount(){
		return amount;
	}
	
	public void setAmount(String a){
		this.investor = a;
	}
}
