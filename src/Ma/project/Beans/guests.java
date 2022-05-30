package Ma.project.Beans;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class guests {
	
	private SimpleIntegerProperty roomID;
	private SimpleStringProperty name;
	private SimpleStringProperty email;
	private SimpleStringProperty adress;
	private SimpleStringProperty city;
	private SimpleStringProperty Nationnality;
	private SimpleStringProperty passport;
	private SimpleStringProperty phone;
	private SimpleStringProperty Card_Number;
	private SimpleStringProperty card_Pass;
	
	
	private SimpleIntegerProperty days;
	private SimpleDoubleProperty fees;

	
	
	public guests(Integer roomID, String name, String email,
			String adress, String city, String nationnality,
			String passport, Integer days, double fees, String phone) {
		super();
		this.roomID = new SimpleIntegerProperty(roomID) ;
		this.name = new SimpleStringProperty(name);
		this.email =new SimpleStringProperty( email);
		this.adress = new SimpleStringProperty(adress);
		this.city = new SimpleStringProperty(city);
		Nationnality = new SimpleStringProperty(nationnality);
		this.passport = new SimpleStringProperty(passport);
		this.phone = new SimpleStringProperty(phone);
		this.days = new SimpleIntegerProperty(days);
		this.fees = new SimpleDoubleProperty(fees);
	}


	public guests(Integer roomID, String name, String email,String adress, String city, String nationnality,
			String passport, Integer days, double fees, String phone, String card_Number,String card_Pass) {
		super();
		this.roomID = new SimpleIntegerProperty(roomID) ;
		this.name = new SimpleStringProperty(name);
		this.email =new SimpleStringProperty( email);
		this.adress = new SimpleStringProperty(adress);
		this.city = new SimpleStringProperty(city);
		Nationnality = new SimpleStringProperty(nationnality);
		this.passport = new SimpleStringProperty(passport);
		this.phone = new SimpleStringProperty(phone);
		this.Card_Number = new SimpleStringProperty(card_Number);
		this.card_Pass = new SimpleStringProperty(card_Pass);
		this.days = new SimpleIntegerProperty(days);
		this.fees = new SimpleDoubleProperty(fees);
	}


	public guests() {
		// TODO Auto-generated constructor stub
	}


	public final SimpleIntegerProperty roomIDProperty() {
		return this.roomID;
	}
	


	public final int getRoomID() {
		return this.roomIDProperty().get();
	}
	


	public final void setRoomID(final int roomID) {
		this.roomIDProperty().set(roomID);
	}
	


	public final SimpleStringProperty nameProperty() {
		return this.name;
	}
	


	public final String getName() {
		return this.nameProperty().get();
	}
	


	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	


	public final SimpleStringProperty emailProperty() {
		return this.email;
	}
	


	public final String getEmail() {
		return this.emailProperty().get();
	}
	


	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	


	public final SimpleStringProperty adressProperty() {
		return this.adress;
	}
	


	public final String getAdress() {
		return this.adressProperty().get();
	}
	


	public final void setAdress(final String adress) {
		this.adressProperty().set(adress);
	}
	


	public final SimpleStringProperty cityProperty() {
		return this.city;
	}
	


	public final String getCity() {
		return this.cityProperty().get();
	}
	


	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}
	


	public final SimpleStringProperty NationnalityProperty() {
		return this.Nationnality;
	}
	


	public final String getNationnality() {
		return this.NationnalityProperty().get();
	}
	


	public final void setNationnality(final String Nationnality) {
		this.NationnalityProperty().set(Nationnality);
	}
	


	public final SimpleStringProperty passportProperty() {
		return this.passport;
	}
	


	public final String getPassport() {
		return this.passportProperty().get();
	}
	


	public final void setPassport(final String passport) {
		this.passportProperty().set(passport);
	}
	


	public final SimpleIntegerProperty daysProperty() {
		return this.days;
	}
	


	public final int getDays() {
		return this.daysProperty().get();
	}
	


	public final void setDays(final int days) {
		this.daysProperty().set(days);
	}
	


	public final SimpleDoubleProperty feesProperty() {
		return this.fees;
	}
	


	public final double getFees() {
		return this.feesProperty().get();
	}
	


	public final void setFees(final int fees) {
		this.feesProperty().set(fees);
	}


	public final SimpleStringProperty phoneProperty() {
		return this.phone;
	}
	


	public final String getPhone() {
		return this.phoneProperty().get();
	}
	


	public final void setPhone(final String phone) {
		this.phoneProperty().set(phone);
	}


	public final SimpleStringProperty Card_NumberProperty() {
		return this.Card_Number;
	}
	


	public final String getCard_Number() {
		return this.Card_NumberProperty().get();
	}
	


	public final void setCard_Number(final String Card_Number) {
		this.Card_NumberProperty().set(Card_Number);
	}
	


	public final SimpleStringProperty card_PassProperty() {
		return this.card_Pass;
	}
	


	public final String getCard_Pass() {
		return this.card_PassProperty().get();
	}
	


	public final void setCard_Pass(final String card_Pass) {
		this.card_PassProperty().set(card_Pass);
	}
	
	
	

}
