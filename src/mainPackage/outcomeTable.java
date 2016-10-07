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

public class outcomeTable {
	private ResourceBundle rb;
	private TableView<outcomeItems> table;
	private VBox layout;
	private Label outcomeTabletitle;
	private TableColumn<outcomeItems, String> dateColumn;
	private TableColumn<outcomeItems, String> productNameColumn;
	private TableColumn<outcomeItems, String> whoSpentColumn;
	private TableColumn<outcomeItems, String> amountColumn;
	private ObservableList<outcomeItems> allOutcomes;
	
	public VBox theLayot(){
		//resource
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		layout = new VBox();
		outcomeTabletitle = new Label(rb.getString("outcomes"));
		outcomeTabletitle.setStyle("-fx-font-size: 16px;");
		outcomeTabletitle.setPadding(new Insets(10,0,5,0));
		layout.getChildren().addAll(outcomeTabletitle, theTable());
		return layout;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<outcomeItems> theTable(){
		dateColumn = new TableColumn<>(rb.getString("date"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("datex"));
		
		productNameColumn = new TableColumn<>(rb.getString("productName"));
		productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productname"));
		
		whoSpentColumn = new TableColumn<>(rb.getString("spenter"));
		whoSpentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				
		amountColumn = new TableColumn<>(rb.getString("amount"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
				
		
		
		table = new TableView<>();
		table.setItems(getOutComes());
		table.getColumns().addAll(dateColumn, productNameColumn, whoSpentColumn, amountColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		return table;
	}
	
	public ObservableList<outcomeItems> getOutComes(){
		allOutcomes = FXCollections.observableArrayList();
		allOutcomes.add(new outcomeItems("25-05-206", "ნესვი", "გიო გვაზავა", "500 ლარი"));
		allOutcomes.add(new outcomeItems("23-05-206", "საწვავი", "ქეთი გვაზავა", "250 ლარი"));
		allOutcomes.add(new outcomeItems("11-05-206", "ტუალეტის ქაღალდი", "გურამ გვაზავა", "1120 ლარი"));
		allOutcomes.add(new outcomeItems("09-05-206", "გადასახადები", "დარე გვაზავა", "130 ლარი"));
		return allOutcomes;
		
	}
}
