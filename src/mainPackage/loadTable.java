package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import database.*;

public class loadTable {
	public static void display(String title, String typex){
		//resource
		ResourceBundle rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		ObservableList<String> pageOptions = FXCollections.observableArrayList();
		ObservableList<String> quentityOptions = FXCollections.observableArrayList();
		ComboBox<String> pageCombo;
		Stage window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(1000);
		window.setMinHeight(550);
		
		//root layout
		VBox root = new VBox();
		// top layout
		HBox topLayout = new HBox();
		topLayout.setSpacing(10);
		topLayout.setPadding(new Insets(10,10,10,10));
		// center layout
		HBox centerLayout = new HBox();
		centerLayout.setSpacing(10);
		centerLayout.setPadding(new Insets(10,10,10,10));
		
		// top elements
		Label page = new Label(rb.getString("page")+":");		
		Label quentity = new Label(rb.getString("quentity")+":");
		page.setMinHeight(20);
		quentity.setMinHeight(20);
		
		Button add = new Button(rb.getString("add"));
		add.setMinHeight(20);
		Button edit = new Button(rb.getString("edit"));
		edit.setMinHeight(20);
		Button delete = new Button(rb.getString("delete"));
		delete.setMinHeight(20);
		
		quentityOptions.add("10");
		quentityOptions.add("20");
		quentityOptions.add("50");
		quentityOptions.add("100");
		ComboBox<String> quentityCombo = new ComboBox<String>(quentityOptions);
		quentityCombo.setValue("10");
		
		// center elements
		switch(typex){
			case "familyMembers":
				// databse 
				familyMembers familyMembers = new familyMembers();
				int all = familyMembers.countMembers();
				int quentityVal = Integer.parseInt(quentityCombo.getValue());
				int forEchVal = ((int) Math.ceil(((double) all / quentityVal)));
				if(forEchVal<=0){ forEchVal=1;}

				for(int i = 1; i<=forEchVal; i++){
					pageOptions.add(i+"");
				}
				FamilyMemberList centerTable = new FamilyMemberList();
				VBox centerTabelLayout = centerTable.theLayot(0,10);
				centerLayout.getChildren().add(centerTabelLayout);
			break;
			case "incomes":
				// databse 
				income income = new income();
				int all2 = income.countMembers();
				int quentityVal2 = Integer.parseInt(quentityCombo.getValue());
				int forEchVal2 = ((int) Math.ceil(((double) all2 / quentityVal2)));
				if(forEchVal2<=0){ forEchVal2=1;}
				
				for(int i = 1; i<=forEchVal2; i++){
					pageOptions.add(i+"");
				}
				
				incomeList centerTable2 = new incomeList();
				VBox centerTabelLayout2 = centerTable2.theLayot(0, 10);
				centerLayout.getChildren().add(centerTabelLayout2);
			break;
			case "outcomes":
				// databse 
				outcome outcome = new outcome();
				int all3 = outcome.countMembers();
				int quentityVal3 = Integer.parseInt(quentityCombo.getValue());
				int forEchVal3 = ((int) Math.ceil(((double) all3 / quentityVal3)));
				if(forEchVal3<=0){ forEchVal3=1;}
				
				for(int i = 1; i<=forEchVal3; i++){
					pageOptions.add(i+"");
				}
				
				outcomeList centerTable3 = new outcomeList();
				VBox centerTabelLayout3 = centerTable3.theLayot(0, 10);
				centerLayout.getChildren().add(centerTabelLayout3);
			break;
		}
		
		pageCombo = new ComboBox<String>(pageOptions);
		pageCombo.setValue("1");
		
		/*
		 * combo listeners
		 * */
		pageCombo.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			try{
				root.getChildren().remove(1);
				int quentity_ = Integer.parseInt(quentityCombo.getValue());
				int page_ = pageCombo.getSelectionModel().getSelectedIndex() * quentity_; 
				
				HBox centerLayout_ = new HBox();
				if(typex=="familyMembers"){
					FamilyMemberList centerTable_ = new FamilyMemberList();
					VBox centerTabelLayout_ = centerTable_.theLayot(page_,quentity_);
					centerLayout_.getChildren().add(centerTabelLayout_);
				}else if(typex=="incomes"){
					incomeList centerTable2_ = new incomeList();
					VBox centerTabelLayout2_ = centerTable2_.theLayot(page_,quentity_);
					centerLayout_.getChildren().add(centerTabelLayout2_);
				}else if(typex=="outcomes"){
					outcomeList centerTable3_ = new outcomeList();
					VBox centerTabelLayout3_ = centerTable3_.theLayot(page_,quentity_);
					centerLayout_.getChildren().add(centerTabelLayout3_);
				}
				System.out.println("f: "+page_+" l:"+quentity_);
				root.getChildren().add(centerLayout_);
			}catch(Exception ex){
				System.out.println(ex);
			}
		});
		
		topLayout.getChildren().addAll(page, pageCombo, quentity, quentityCombo, add, edit, delete);
		
		
		root.getChildren().addAll(topLayout, centerLayout);
		Scene scene = new Scene(root);
		
		scene.getStylesheets().add("Viper.css");
		window.getIcons().add(new Image("image\\favicon.png"));
		
		window.setScene(scene);
		window.showAndWait();
	}
	
}
