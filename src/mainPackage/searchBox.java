package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import calendar.customDatePicker;

public class searchBox {
	private VBox vb;
	private ResourceBundle rb;
	private Label label;
	DatePicker cdP;
	DatePicker cdP2;
	private Button btn;
	
	public searchBox(){
		vb = new VBox();
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		label = new Label();
		cdP = customDatePicker.make(500, "dd/MM/YYYY", "serachBoxDatepicker", "", null); 
		cdP2 = customDatePicker.make(500, "dd/MM/YYYY", "serachBoxDatepicker", "", null); 
		btn = new Button();
	}
	
	public VBox getSerchBox(){
		label.setText(rb.getString("typeDate"));
		label.setPadding(new Insets(10,0,5,0));
		
		btn.setText(rb.getString("searchBtn"));
		
		vb.getChildren().addAll(label, cdP, cdP2, btn);
		VBox.setMargin(cdP, new Insets(0,0,5,0));
		VBox.setMargin(cdP2, new Insets(0,0,5,0));
		
		vb.setPadding(new Insets(0,10,10,10));
		vb.setMinWidth(500);
		return vb;
	}
}
