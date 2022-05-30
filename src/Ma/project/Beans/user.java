package Ma.project.Beans;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class user {
	private SimpleStringProperty user_name;
	private SimpleStringProperty user_pass;
	private SimpleIntegerProperty is_admin;
	
	

	public user(String userName, String UserPass, Integer admin) {
		// TODO Auto-generated constructor stub
		this.user_name = new SimpleStringProperty(userName);
		this.user_pass = new SimpleStringProperty(UserPass);
		this.is_admin = new SimpleIntegerProperty(admin);
	}

	


	public final SimpleStringProperty user_nameProperty() {
		return this.user_name;
	}
	



	public final String getUser_name() {
		return this.user_nameProperty().get();
	}
	



	public final void setUser_name(final String user_name) {
		this.user_nameProperty().set(user_name);
	}
	



	public final SimpleStringProperty user_passProperty() {
		return this.user_pass;
	}
	



	public final String getUser_pass() {
		return this.user_passProperty().get();
	}
	



	public final void setUser_pass(final String user_pass) {
		this.user_passProperty().set(user_pass);
	}
	



	public final SimpleIntegerProperty is_adminProperty() {
		return this.is_admin;
	}
	



	public final int getIs_admin() {
		return this.is_adminProperty().get();
	}
	



	public final void setIs_admin(final int is_admin) {
		this.is_adminProperty().set(is_admin);
	}
	

}
