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
	private TextField text2;
	private Button btn;
	
	public searchBox(){
		vb = new VBox();
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		label = new Label();
		text = new TextField();
		text2 = new TextField();
		btn = new Button();
	}
	
	public VBox getSerchBox(){
		label.setText(rb.getString("typeDate"));
		label.setPadding(new Insets(10,0,5,0));
		text.setPromptText(rb.getString("dateFormat"));
		text2.setPromptText(rb.getString("dateFormat2"));	
		
		btn.setText(rb.getString("searchBtn"));
		
		vb.getChildren().addAll(label, text, text2, btn);
		VBox.setMargin(text, new Insets(0,0,5,0));
		VBox.setMargin(text2, new Insets(0,0,5,0));
		
		vb.setPadding(new Insets(0,10,10,10));
		vb.setMinWidth(500);
		return vb;
	}
}
