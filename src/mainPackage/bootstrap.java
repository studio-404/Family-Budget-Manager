package mainPackage;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class bootstrap extends Application {
	private BorderPane root;
	private navigation nav;
	private MenuBar menu;
	private VBox layout;
	private VBox rightSideLayout;
	private VBox centerSideLayout;
	private HBox centerTopLayout;
	private Scene scene;
	private currentDateTime theDateBox;
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("ბიუჯეტის მართვა");	
		
		root = new BorderPane();		
		
		/* Right layout START */
		nav = new navigation();
		menu = nav.myNavigation();
		layout = new VBox();
		layout.getChildren().addAll(menu);		
		FamilyTable Familytable = new FamilyTable();	
		incomeTable incomeTable = new incomeTable();
		outcomeTable outcomeTable = new outcomeTable();		
		rightSideLayout = new VBox();
		rightSideLayout.getChildren().addAll(
				Familytable.theLayot(), 
				incomeTable.theLayot(),
				outcomeTable.theLayot()
		);
		rightSideLayout.setMaxWidth(380);
		rightSideLayout.setPadding(new Insets(0,10,10,10));
		/* Right layout END */
		
		/* Center Layout START */
		centerSideLayout = new VBox();
		centerTopLayout = new HBox();		
		theDateBox = new currentDateTime();
		centerTopLayout.getChildren().add(theDateBox.dateBox());
		
		searchBox searchBox = new searchBox();
		centerTopLayout.getChildren().add(searchBox.getSerchBox());
		centerSideLayout.getChildren().add(centerTopLayout);
		/* Center Layout END */
		
		// add layouts to main root layout
		root.setTop(layout);
		root.setRight(rightSideLayout);
		root.setCenter(centerSideLayout);
		
		
		//create scene
		scene = new Scene(root);
		scene.getStylesheets().add("Viper.css");
		window.setMaximized(true);
		window.setResizable(true);
		// add scene to window and show
		window.setScene(scene);
		window.show();
	}
	
}
