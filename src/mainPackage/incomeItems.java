package mainPackage;

public class incomeItems {
	private String datex;
	private String investor;
	private String amount;
	private String desc;
	
	
	public incomeItems(){
		this.datex = "";
		this.investor = "";
		this.amount = "";
		this.desc = "";
		
	}
	
	public incomeItems(String d, String in, String a, String desc){
		this.datex = d;
		this.investor = in;
		this.amount = a;
		this.desc = desc;
	}
	
	
	public String getDesc(){
		return desc;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
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
