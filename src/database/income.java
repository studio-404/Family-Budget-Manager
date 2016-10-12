package database;

import database.connectDb;
import java.sql.*;

public class income {
	public ResultSet selectIncome(){
		Connection db = connectDb.db();
		String query = "SELECT income.id as id, income.date as date, (SELECT name FROM familyMembers WHERE familyMembers.id=income.user_id) as username, (SELECT surname FROM familyMembers WHERE familyMembers.id=income.user_id) as usersurname, income.money as money, (SELECT name FROM currency WHERE currency.id=income.currency) as currency, income.desc as desc FROM income ORDER BY id DESC LIMIT 10";
		try{
			PreparedStatement prepare = db.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			return result;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}
