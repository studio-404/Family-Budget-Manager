package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class searchBox {
	private VBox vb;
	private ResourceBundle rb;
	private Label label;
	private TextField text;
	private ComboBox<String> comb;
	private Button btn;
	
	public searchBox(){
		vb = new VBox();
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		label = new Label();
		text = new TextField();
		comb = new ComboBox<>();
		btn = new Button();
	}
	
	public VBox getSerchBox(){
		label.setText(rb.getString("typeDate"));
		label.setPadding(new Insets(10,0,5,0));
		text.setText(rb.getString("dateFormat"));
				
		comb.getItems().add(rb.getString("choose"));
		comb.getItems().add(rb.getString("income"));
		comb.getItems().add(rb.getString("outcomes"));
		comb.setMaxWidth(500);
		comb.getSelectionModel().select(0);
		
		btn.setText(rb.getString("searchBtn"));
		
		vb.getChildren().addAll(label, text, comb, btn);
		VBox.setMargin(text, new Insets(0,0,5,0));
		VBox.setMargin(comb, new Insets(0,0,5,0));
		
		vb.setPadding(new Insets(0,10,10,10));
		vb.setMinWidth(500);
		return vb;
	}
}
