package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class alertBox {
	
	public static void display(String title, String message){
		//resource
		ResourceBundle rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		Stage window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);
		window.setMinHeight(200);
		
		Label label = new Label(message);
		label.setPadding(new Insets(0,0,20,0));
		Button b = new Button(rb.getString("close"));
		b.setOnAction(e -> window.close());
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label, b);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		
		scene.getStylesheets().add("Viper.css");
		window.getIcons().add(new Image("image\\favicon.png"));
		
		window.setScene(scene);
		window.showAndWait();
	}
}
