package mainPackage;

public class outcomeItems {
	private String datex;
	private String productName;
	private String name;
	private String amount;
	
	public outcomeItems(){
		this.datex = "";
		this.name = "";
		this.productName = "";
		this.amount = "";
	}
	
	public outcomeItems(String d, String p, String n, String s){
		this.datex = d;
		this.name = n;
		this.productName = p;
		this.amount = s;
	}
	
	public String getDatex(){
		return datex;
	}
	
	public void setDatex(String d){
		this.datex = d;
	}
	
	public String getProductname(){
		return productName;
	}
	
	public void setProductname(String p){
		this.productName = p;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getAmount(){
		return amount;
	}
	
	public void setAmount(String a){
		this.amount = a;
	}
}
