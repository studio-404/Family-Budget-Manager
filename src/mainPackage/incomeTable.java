package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import database.income;
import java.sql.*;

public class incomeTable {
	private ResourceBundle rb;
	private TableView<incomeItems> table;
	private VBox layout;
	private Label incomeTabletitle;
	private TableColumn<incomeItems, String> dateColumn;
	private TableColumn<incomeItems, String> investorColumn;
	private TableColumn<incomeItems, String> amountColumn;
	private TableColumn<incomeItems, String> descColumn;
	private ObservableList<incomeItems> allIncomes;
	
	public VBox theLayot(){
		//resource
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		layout = new VBox();
		incomeTabletitle = new Label(rb.getString("incomes"));
		incomeTabletitle.setStyle("-fx-font-size: 16px;");
		incomeTabletitle.setPadding(new Insets(10,5,5,0));
		
		Button getAllList = new Button();
		getAllList.getStyleClass().add("getAllList");
		getAllList.setMinWidth(30);
		getAllList.setMinHeight(30);
		getAllList.setPadding(new Insets(15,0,15,0));
		
		Button addListItem = new Button();
		addListItem.getStyleClass().add("addListItem");
		addListItem.setMinWidth(30);
		addListItem.setMinHeight(30);
		addListItem.setPadding(new Insets(15,0,15,0));
		
		Button removeListItem = new Button();
		removeListItem.getStyleClass().add("removeListItem");
		removeListItem.setMinWidth(30);
		removeListItem.setMinHeight(30);
		removeListItem.setPadding(new Insets(15,0,15,0));
		
		HBox tableTopLayout = new HBox();	
		tableTopLayout.setSpacing(5);
		tableTopLayout.getChildren().addAll(incomeTabletitle, getAllList, addListItem, removeListItem);
		
		
		layout.getChildren().addAll(tableTopLayout, theTable());
		return layout;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<incomeItems> theTable(){
		
		dateColumn = new TableColumn<>(rb.getString("date"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("datex"));
		
		descColumn = new TableColumn<>(rb.getString("productName"));
		descColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
				
		investorColumn = new TableColumn<>(rb.getString("investor"));
		investorColumn.setCellValueFactory(new PropertyValueFactory<>("investor"));
				
		amountColumn = new TableColumn<>(rb.getString("amount"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		table = new TableView<>();
		table.setItems(getIncomes());
		table.getColumns().addAll(dateColumn, descColumn, investorColumn, amountColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		return table;
	}
	
	public ObservableList<incomeItems> getIncomes(){
		income in = new income();
		ResultSet result = in.selectIncome();
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
