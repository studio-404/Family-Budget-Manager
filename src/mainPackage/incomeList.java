package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import database.income;
import java.sql.*;

public class incomeList {
	private ResourceBundle rb;
	private TableView<incomeItems> table;
	private VBox layout;
	private TableColumn<incomeItems, String> dateColumn;
	private TableColumn<incomeItems, String> investorColumn;
	private TableColumn<incomeItems, String> amountColumn;
	private TableColumn<incomeItems, String> descColumn;
	private ObservableList<incomeItems> allIncomes;
	
	public VBox theLayot(int f, int l){
		//resource
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		layout = new VBox();
		
		layout.getChildren().addAll(theTable(f, l));
		return layout;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<incomeItems> theTable(int f, int l){
		
		dateColumn = new TableColumn<>(rb.getString("date"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("datex"));
		dateColumn.setMinWidth(245);
		
		descColumn = new TableColumn<>(rb.getString("productName"));
		descColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
		descColumn.setMinWidth(245);
		
		investorColumn = new TableColumn<>(rb.getString("investor"));
		investorColumn.setCellValueFactory(new PropertyValueFactory<>("investor"));
		investorColumn.setMinWidth(245);	
		
		amountColumn = new TableColumn<>(rb.getString("amount"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		amountColumn.setMinWidth(245);
		
		table = new TableView<>();
		table.setItems(getIncomes(f, l));
		table.getColumns().addAll(dateColumn, descColumn, investorColumn, amountColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		return table;
	}
	
	public ObservableList<incomeItems> getIncomes(int f, int l){
		income in = new income();
		ResultSet result = in.selectIncomeFromTo(f, l);
		allIncomes = FXCollections.observableArrayList();
		
		//long unixTime = System.currentTimeMillis() / 1000L;
		//Date time=new Date((long)unixTime*1000);
		
		try{
			while(result.next()){
				Date date=new Date((long)Integer.parseInt(result.getString(2))*1000);
				SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
				allIncomes.add(new incomeItems(						
						formatDate.format(date),
						result.getString(3) + " " +result.getString(4), 
						result.getString(5) + " " +result.getString(6),
						result.getString(7)
				));
			}
		}catch(Exception e){
			System.out.println("error: " + e);
		}
		
		return allIncomes;
		
	}
	
}
