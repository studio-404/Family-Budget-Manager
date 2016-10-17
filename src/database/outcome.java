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
	
	public ResultSet selectOutcomeFromTo(int from, int limit){
		Connection db = connectDb.db();
		String query = "SELECT outcome.id as id, outcome.date as date, (SELECT name FROM familyMembers WHERE familyMembers.id=outcome.user_id) as username, (SELECT surname FROM familyMembers WHERE familyMembers.id=outcome.user_id) as usersurname, outcome.money as money, (SELECT name FROM currency WHERE currency.id=outcome.currency) as currency, outcome.desc as desc FROM outcome ORDER BY id ASC LIMIT "+from+","+limit;
		try{
			PreparedStatement prepare = db.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			return result;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public int countMembers(){
		int number;
		Connection db = connectDb.db();
		String query = "SELECT COUNT(id) FROM outcome";
		try{
			PreparedStatement prepare = db.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			number = result.getInt(1);
		}catch(Exception e){
			System.out.println(e);
			number = 0;
		}
		return number;
	}
	
	public int removeMember(int i){
		Connection db = connectDb.db();
		String query = "DELETE FROM outcome WHERE id="+i;
		try{
			PreparedStatement prepare = db.prepareStatement(query);
			prepare.executeUpdate();
			return 1;
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
		
	}
}
