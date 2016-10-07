package mainPackage;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;

public class navigation {
	
	private ResourceBundle rb;
	private MenuBar mainMenu;
	private Menu[] menuElements;
	
	public MenuBar myNavigation(){
		//resource
		rb = ResourceBundle.getBundle("lang", Locale.getDefault());
		
		mainMenu = new MenuBar();
		menuElements = new Menu[]{
			new Menu(rb.getString("menuMain")),
			new Menu(rb.getString("menuFamilyMembers")),
			new Menu(rb.getString("income")),
			new Menu(rb.getString("outcomes")),
			new Menu(rb.getString("credits")),
			new Menu(rb.getString("options"))
		};
		
		// family members sub menu
		MenuItem addMember = new MenuItem(rb.getString("addMember"));
		MenuItem editMembers = new MenuItem(rb.getString("edit"));
		menuElements[1].getItems().addAll(addMember, editMembers);
		
		//incomes sub menu
		MenuItem addIncome = new MenuItem(rb.getString("addIncome"));
		MenuItem editIncome = new MenuItem(rb.getString("edit"));
		MenuItem incomeStats = new MenuItem(rb.getString("stats"));
		menuElements[2].getItems().addAll(addIncome, editIncome, incomeStats);
		
		//outcomes sub menu
		MenuItem addOutcome = new MenuItem(rb.getString("addOutcome"));
		MenuItem editOutcome = new MenuItem(rb.getString("edit"));
		MenuItem outcomeStats = new MenuItem(rb.getString("stats"));
		menuElements[3].getItems().addAll(addOutcome, editOutcome, outcomeStats);
		
		// loans sub menu
		MenuItem addLoan = new MenuItem(rb.getString("addLoan"));
		MenuItem editLoan = new MenuItem(rb.getString("edit"));
		MenuItem loanStats = new MenuItem(rb.getString("stats"));
		menuElements[4].getItems().addAll(addLoan, editLoan, loanStats);
		
		// options
		MenuItem exitx = new MenuItem(rb.getString("exits"));
		menuElements[5].getItems().addAll(exitx);
		
		exitx.setOnAction(e -> System.exit(0));
		
		for(int i = 0; i < menuElements.length; i++){
			mainMenu.getMenus().add(menuElements[i]);
		}
		return mainMenu;
	}
}
