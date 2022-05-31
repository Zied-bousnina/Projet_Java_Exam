package Ma.project.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Ma.project.Beans.guests;
import Ma.project.Beans.room;
import Ma.project.Connexion.connexion;
import Ma.project.dao.IDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class checkIn_roomService  implements IDao<room>{

	public checkIn_roomService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(room o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean createGuest(guests o) {
		try {
			String req = "INSERT INTO `guest` (`room_ID`, `Name`, `Email`, `Address`, `city`, `Nationality`, `passport_Number`, `phoneNo`, `Card_Number`, `card_Pass`, `number_Of_Days`, `fees`) VALUES ('"+o.getRoomID()+"', '"+o.getName()+"', '"+o.getEmail()+"', '"+o.getAdress()+"', '"+o.getCity()+"', '"+o.getNationnality()+"', '"+o.getPassport()+"', '"+o.getPhone()+"', '"+o.getCard_Number()+"', '"+o.getCard_Pass()+"', '"+o.getDays()+"', '"+o.getFees()+"');";
			Statement st = connexion.getCn().createStatement();
			if(st.executeUpdate(req)==1) {
				
				return true;
			}
			
		} catch (SQLException ex) {
		System.out.println("Erreur SQL");
		System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(room o) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public boolean updateDateRoom(String check_in, String check_out, Integer id) {
//		try {
//			String req = "update room set Check_In_Date = '"+check_in+"', Check_Out_Date ='"+check_out+"' where roomID= "+id+"";
//			Statement st = connexion.getCn().createStatement();
//			if(st.executeUpdate(req)==1) {
//				
//				return true;
//			}
//			
//		} catch (SQLException ex) {
//		System.out.println("Erreur SQLDFDF");
//		System.out.println(ex.getMessage());
//		}
//		return false;
//	}
	public boolean updateEmptyRoom(String check_in,String check_out,Integer id) {
		try {
			String req = "update room set  isEmpty =0 and Check_in_date='"+check_in+"' and Check_Out_Date='"+check_out+"' where roomID= "+id+"";
			Statement st = connexion.getCn().createStatement();
			if(st.executeUpdate(req)==1) {
				
				return true;
			}
			
		} catch (SQLException ex) {
		System.out.println("Erreur SQL updateEmpty Room");
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
	public List<room> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ObservableList<room> findAvailableRoom(String type, String capacity, String check_out) {
		ObservableList<room> room = FXCollections.observableArrayList();
		try {
//			String req = "select * FROM room where Check_Out_Date < \"+check_out+\" and upper(room_capacity)='\"+ capacity+\"'and upper(room_Type) ='\"+type+\"'  and isEmpty=1 ";
			String req = "select * from room where Check_Out_Date < '"+check_out+"'and upper(room_capacity)='"+ capacity+"'and upper(room_Type) ='"+type+"'  and isEmpty=1";
//			Statement st = connexion.getCn().createStatement();
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ResultSet rs= ps.executeQuery(req);
			while (rs.next()) {
				room.add(new room(rs.getInt("roomID"), rs.getString("room_type"), rs.getString("room_capacity"), rs.getString("Check_In_Date"),rs.getString("Check_Out_Date"), rs.getInt("isEmpty")));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR SQl find");
		System.out.println(e.getMessage());
		}
		return room;
	}

}
