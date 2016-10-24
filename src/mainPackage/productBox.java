package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
import database.products;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class productBox {
	public static void display(String title){
		//resource
		ResourceBundle rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		VBox layout = new VBox();
		Stage window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(1000);	
		productIncomeList productIncomeList = new productIncomeList();
		VBox tableLayer = productIncomeList.theLayot(1);
		
		Button add = new Button(rb.getString("add"));
		add.setOnAction(e -> {
			productAddBox.display(1, rb.getString("incomeListAdd"));
		});
		
		Button reload = new Button(rb.getString("reload"));
		reload.setOnAction(e -> {
			layout.getChildren().remove(1);
			VBox prList = productIncomeList.theLayot(1);
			layout.getChildren().add(1, prList);
			VBox.setMargin(prList, new Insets(0,10,0,10));
		});
		
		Button delete = new Button(rb.getString("delete"));
		delete.setOnAction(e -> {
			TableView<productsSettterGetter> table = productIncomeList.table;
			productsSettterGetter prSetGet = table.getSelectionModel().getSelectedItem();
			int selectedIndex = table.getSelectionModel().getSelectedIndex();
			int selectedItemId = prSetGet.getId();
			
			Button actionButton = new Button(rb.getString("delete"));
			actionButton.setOnAction(ev -> {
				products proDB = new products();
				int rm = proDB.removeMember(selectedItemId);
				if(rm == 1){
					alertBox.display(rb.getString("message"), rb.getString("successDone"));
					table.getItems().remove(selectedIndex);
				}else{
					alertBox.display(rb.getString("message"), rb.getString("errorHappend"));
				}
				Stage stage = (Stage) actionButton.getScene().getWindow();
			    stage.close();			    
			});
			comfirmBox.display(rb.getString("message"), rb.getString("WULTdelete"), actionButton);
		});
		
		HBox buttonLayouts = new HBox();
		buttonLayouts.getChildren().addAll(add, reload, delete);
		buttonLayouts.setPadding(new Insets(10,10,10,10));
		buttonLayouts.setSpacing(10);
		
		
		layout.getChildren().addAll(buttonLayouts, tableLayer);
		VBox.setMargin(tableLayer, new Insets(0,10,10,10));
		
		Scene scene = new Scene(layout);
		
		scene.getStylesheets().add("Viper.css");
		window.getIcons().add(new Image("image\\favicon.png"));
		
		window.setScene(scene);
		window.showAndWait();
	}
}
