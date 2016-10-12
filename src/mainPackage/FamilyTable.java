package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
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
import database.familyMembers;
import java.sql.*;

public class FamilyTable {
	private ResourceBundle rb;
	private TableView<FamilyMembers> table;
	private VBox layout;
	private Label FamilyTabletitle;
	private TableColumn<FamilyMembers, String> idColumn;
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
		FamilyTabletitle.setPadding(new Insets(10,5,5,0));
		
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
		tableTopLayout.getChildren().addAll(FamilyTabletitle, getAllList, addListItem, removeListItem);
		
		layout.getChildren().addAll(tableTopLayout, theTable());
		return layout;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<FamilyMembers> theTable(){
		idColumn = new TableColumn<>(rb.getString("id"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		nameColumn = new TableColumn<>(rb.getString("name"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				
		surnameColumn = new TableColumn<>(rb.getString("surname"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
				
		numberColumn = new TableColumn<>(rb.getString("contactNumber"));
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
		
		table = new TableView<>();
		table.setItems(getFamilyMembers());
		table.getColumns().addAll(idColumn, nameColumn, surnameColumn, numberColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		return table;
	}
	
	public ObservableList<FamilyMembers> getFamilyMembers(){
		FamilyMembers = FXCollections.observableArrayList();
		familyMembers fm = new familyMembers();
		ResultSet result = fm.selectMembers();
		try{
			while(result.next()){
				FamilyMembers.add(new FamilyMembers(
						result.getInt(1), 
						result.getString(2), 
						result.getString(3), 
						result.getString(4)
				));
			}
		}catch(Exception e){
			System.out.println("error: " + e);
		}
		return FamilyMembers;
		
	}
}
