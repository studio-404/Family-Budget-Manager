package database;

import database.connectDb;
import java.sql.*;

public class familyMembers {
	public ResultSet selectMembers(){
		Connection db = connectDb.db();
		String query = "SELECT * FROM familymembers WHERE status!=1 ORDER BY id ASC LIMIT 10";
		try{
			PreparedStatement prepare = db.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			return result;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public ResultSet selectMembersIncome(int currency_id){
		Connection db = connectDb.db();
		String query = "SELECT familymembers.name as name, familymembers.surname as surname, (SELECT SUM(income.money) FROM income WHERE familymembers.id=income.user_id AND income.currency="+currency_id+") AS moneySum  FROM familymembers WHERE familymembers.status!=1";
		try{
			PreparedStatement prepare = db.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			return result;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public ResultSet selectMembersOutcome(int currency_id){
		Connection db = connectDb.db();
		String query = "SELECT familymembers.name as name, familymembers.surname as surname, (SELECT SUM(outcome.money) FROM outcome WHERE familymembers.id=outcome.user_id AND outcome.currency="+currency_id+") AS moneySum  FROM familymembers WHERE familymembers.status!=1";
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
