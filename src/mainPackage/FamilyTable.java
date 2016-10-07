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

public class FamilyTable {
	private ResourceBundle rb;
	private TableView<FamilyMembers> table;
	private VBox layout;
	private Label FamilyTabletitle;
	private TableColumn<FamilyMembers, String> nameColumn;
	private TableColumn<FamilyMembers, String> surnameColumn;
	private TableColumn<FamilyMembers, String> numberColumn;
	private ObservableList<FamilyMembers> FamilyMembers;
	
	public VBox theLayot(){
		//resource
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		layout = new VBox();
		FamilyTabletitle = new Label(rb.getString("familyMembers"));
		FamilyTabletitle.setStyle("-fx-font-size: 16px;");
		FamilyTabletitle.setPadding(new Insets(10,0,5,0));
		layout.getChildren().addAll(FamilyTabletitle, theTable());
		return layout;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<FamilyMembers> theTable(){
		nameColumn = new TableColumn<>(rb.getString("name"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				
		surnameColumn = new TableColumn<>(rb.getString("surname"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
				
		numberColumn = new TableColumn<>(rb.getString("contactNumber"));
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
		
		table = new TableView<>();
		table.setItems(getFamilyMembers());
		table.getColumns().addAll(nameColumn, surnameColumn, numberColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		return table;
	}
	
	public ObservableList<FamilyMembers> getFamilyMembers(){
		FamilyMembers = FXCollections.observableArrayList();
		FamilyMembers.add(new FamilyMembers("გიო", "გვაზავა", "599623555"));
		FamilyMembers.add(new FamilyMembers("ქეთი", "გვაზავა", "558530144"));
		FamilyMembers.add(new FamilyMembers("დარე", "გვაზავა", "558530144"));
		FamilyMembers.add(new FamilyMembers("გურო", "გვაზავა", "558530144"));
		return FamilyMembers;
		
	}
}
