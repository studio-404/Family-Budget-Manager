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
	
	public ResultSet selectIncomeFromTo(int from, int limit){
		Connection db = connectDb.db();
		String query = "SELECT income.id as id, income.date as date, (SELECT name FROM familyMembers WHERE familyMembers.id=income.user_id) as username, (SELECT surname FROM familyMembers WHERE familyMembers.id=income.user_id) as usersurname, income.money as money, (SELECT name FROM currency WHERE currency.id=income.currency) as currency, income.desc as desc FROM income ORDER BY id DESC LIMIT "+from+","+limit;
		System.out.println(query);
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
		String query = "SELECT COUNT(id) FROM income";
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
		String query = "DELETE FROM income WHERE id="+i;
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
