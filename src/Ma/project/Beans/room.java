package Ma.project.Beans;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class room {
	
	private SimpleIntegerProperty roomID;
	private SimpleStringProperty room_Type;
	private SimpleStringProperty room_capacity;
	private SimpleStringProperty Check_In_Date;
	private SimpleStringProperty Check_Out_Date;
	private SimpleIntegerProperty isEmpty;

	

	
	public room(int roomID, String room_Type, String room_capacity,
			String check_In_Date, String check_Out_Date, int isEmpty) {
		
		this.roomID =  new SimpleIntegerProperty(roomID);
		this.room_Type = new SimpleStringProperty(room_Type) ;
		this.room_capacity =  new SimpleStringProperty(room_capacity);
		this.Check_In_Date = new SimpleStringProperty(check_In_Date);
		this.Check_Out_Date = new SimpleStringProperty (check_Out_Date);
		this.isEmpty = new SimpleIntegerProperty(isEmpty);
	}


	public  SimpleIntegerProperty roomIDProperty() {
		return this.roomID;
	}
	

	public  int getRoomID() {
		return this.roomIDProperty().get();
	}
	

	public  void setRoomID(final int roomID) {
		this.roomIDProperty().set(roomID);
	}
	

	public  SimpleStringProperty room_TypeProperty() {
		return this.room_Type;
	}
	

	public  String getRoom_Type() {
		return this.room_TypeProperty().get();
	}
	

	public  void setRoom_Type(final String room_Type) {
		this.room_TypeProperty().set(room_Type);
	}
	

	public  SimpleStringProperty room_capacityProperty() {
		return this.room_capacity;
	}
	

	public  String getRoom_capacity() {
		return this.room_capacityProperty().get();
	}
	

	public  void setRoom_capacity(final String room_capacity) {
		this.room_capacityProperty().set(room_capacity);
	}
	

	public  SimpleStringProperty Check_In_DateProperty() {
		return this.Check_In_Date;
	}
	

	public  String getCheck_In_Date() {
		return this.Check_In_DateProperty().get();
	}
	

	public  void setCheck_In_Date(final String Check_In_Date) {
		this.Check_In_DateProperty().set(Check_In_Date);
	}
	

	public  SimpleStringProperty Check_Out_DateProperty() {
		return this.Check_Out_Date;
	}
	

	public  String getCheck_Out_Date() {
		return this.Check_Out_DateProperty().get();
	}
	

	public  void setCheck_Out_Date(final String Check_Out_Date) {
		this.Check_Out_DateProperty().set(Check_Out_Date);
	}
	

	public  SimpleIntegerProperty isEmptyProperty() {
		return this.isEmpty;
	}
	

	public  int getIsEmpty() {
		return this.isEmptyProperty().get();
	}
	

	public  void setIsEmpty(final int isEmpty) {
		this.isEmptyProperty().set(isEmpty);
	}
	
	
	

}
