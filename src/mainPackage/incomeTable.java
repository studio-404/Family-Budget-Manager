package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class incomeTable {
	private ResourceBundle rb;
	private TableView<incomeItems> table;
	private VBox layout;
	private Label incomeTabletitle;
	private TableColumn<incomeItems, String> dateColumn;
	private TableColumn<incomeItems, String> investorColumn;
	private TableColumn<incomeItems, String> amountColumn;
	private ObservableList<incomeItems> allIncomes;
	
	public VBox theLayot(){
		//resource
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		layout = new VBox();
		incomeTabletitle = new Label(rb.getString("incomes"));
		incomeTabletitle.setStyle("-fx-font-size: 16px;");
		incomeTabletitle.setPadding(new Insets(10,0,5,0));
		layout.getChildren().addAll(incomeTabletitle, theTable());
		return layout;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<incomeItems> theTable(){
		dateColumn = new TableColumn<>(rb.getString("date"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("datex"));
				
		investorColumn = new TableColumn<>(rb.getString("investor"));
		investorColumn.setCellValueFactory(new PropertyValueFactory<>("investor"));
				
		amountColumn = new TableColumn<>(rb.getString("amount"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		table = new TableView<>();
		table.setItems(getIncomes());
		table.getColumns().addAll(dateColumn, investorColumn, amountColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		return table;
	}
	
	public ObservableList<incomeItems> getIncomes(){
		allIncomes = FXCollections.observableArrayList();
		allIncomes.add(new incomeItems("25-05-206", "გიო გვაზავა", "500 ლარი"));
		allIncomes.add(new incomeItems("23-05-206", "ქეთი გვაზავა", "250 ლარი"));
		allIncomes.add(new incomeItems("11-05-206", "გურამ გვაზავა", "1120 ლარი"));
		allIncomes.add(new incomeItems("09-05-206", "დარე გვაზავა", "130 ლარი"));
		return allIncomes;
		
	}
}
