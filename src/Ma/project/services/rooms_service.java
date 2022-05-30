package Ma.project.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Ma.project.Beans.room;
import Ma.project.dao.IDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Ma.project.Connexion.connexion;

public class rooms_service implements IDao<room> {

	public rooms_service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(room o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(room o) {
		return true;
	}
	public boolean updateRoom() {
		try {
			String req = "Update room set isEmpty =1 where Check_Out_Date< sysdate() ";
			Statement st = connexion.getCn().createStatement();
			if(st.executeUpdate(req)==1) {
				
				return true;
			}
			
		} catch (SQLException ex) {
		System.out.println("Erreur SQL UpdateRoom");
		System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(room o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public room findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<room> findAll() {
		// TODO Auto-generated method stub
		ObservableList<room> room = FXCollections.observableArrayList();
		try {
			String req = "select * from room";
			
//			Statement st = connexion.getCn().createStatement();
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ResultSet rs= ps.executeQuery(req);
			while (rs.next()) {
				room.add(new room(rs.getInt("roomID"), rs.getString("room_type"), rs.getString("room_capacity"), rs.getString("Check_In_Date"),rs.getString("Check_Out_Date"), rs.getInt("isEmpty")));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR SQl finAll room");
		}
		
		return room;
	}

}
