package Ma.project.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ma.project.Beans.room;
import Ma.project.Beans.user;
import Ma.project.Connexion.connexion;
import Ma.project.dao.IDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserService implements IDao<user> {

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(user o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(user o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(user o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public user findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<user> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ObservableList<user> findByUserNameAndPass(String userName, String Pass) {
		// TODO Auto-generated method stub
		ObservableList<user> user = FXCollections.observableArrayList();
		try {
//			String req = "select * FROM room where Check_Out_Date < \"+check_out+\" and upper(room_capacity)='\"+ capacity+\"'and upper(room_Type) ='\"+type+\"'  and isEmpty=1 ";
			String req = "select * from user where user_name = '"+userName+"' and user_pass ='"+Pass+"' ";
//			Statement st = connexion.getCn().createStatement();
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ResultSet rs= ps.executeQuery(req);
			while (rs.next()) {
				user.add(new user(rs.getString("user_name"), rs.getString("user_pass"),  rs.getInt("is_admin")));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR SQl");
		System.out.println(e.getMessage());
		}
		return user;
		
	}

}
