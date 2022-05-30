package Ma.project.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ma.project.Beans.guests;
import Ma.project.Beans.room;
import Ma.project.Connexion.connexion;
import Ma.project.dao.IDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class guests_service implements IDao<guests> {

	public guests_service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(guests o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(guests o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(guests o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public guests findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<guests> findAll() {
		// TODO Auto-generated method stub
		ObservableList<guests> guest = FXCollections.observableArrayList();
		try {
			String req = "select * from guest";
			
//			Statement st = connexion.getCn().createStatement();
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ResultSet rs= ps.executeQuery(req);
			while (rs.next()) {
				guest.add(new guests(rs.getInt("room_ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Address"),rs.getString("city"),rs.getString("Nationality"), rs.getString("passport_Number"), rs.getInt("number_Of_Days"),rs.getDouble("fees"), rs.getString("phoneNo")));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR SQl");
		}
		
		return guest;
	}

}
