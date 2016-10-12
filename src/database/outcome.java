package database;

import database.connectDb;
import java.sql.*;

public class outcome {
	public ResultSet selectOutcome(){
		Connection db = connectDb.db();
		String query = "SELECT outcome.id as id, outcome.date as date, (SELECT name FROM familyMembers WHERE familyMembers.id=outcome.user_id) as username, (SELECT surname FROM familyMembers WHERE familyMembers.id=outcome.user_id) as usersurname, outcome.money as money, (SELECT name FROM currency WHERE currency.id=outcome.currency) as currency, outcome.desc as desc FROM outcome ORDER BY id DESC LIMIT 10";
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
