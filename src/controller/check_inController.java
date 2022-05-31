package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import Ma.project.Beans.guests;
import Ma.project.Beans.room;
import Ma.project.Connexion.connexion;
import Ma.project.services.checkIn_roomService;
import Ma.project.services.guests_service;
import Ma.project.services.rooms_service;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class check_inController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField city;

    @FXML
    private TextField nationnality;

    @FXML
    private TextField passport;

    @FXML
    private TextField cardNumber;

    @FXML
    private TextField cvcCode;

    @FXML
    private DatePicker check_in_date;

    @FXML
    private DatePicker check_out_date;

    @FXML
    private RadioButton economy;

    @FXML
    private RadioButton single;

    @FXML
    private RadioButton vip;

    @FXML
    private RadioButton double_r;

    @FXML
    private RadioButton triple;

    @FXML
    private RadioButton normal;

    @FXML
    
    private TextField roomID;

    @FXML
    private Button search;

    @FXML
    private Button submit;

    @FXML
    private Button clear;
    
    @FXML
    private ToggleGroup RT;
    
    @FXML
    private ToggleGroup RC;
    
    @FXML
    private Label name_error;

    @FXML
    private Label phone_error;

    @FXML
    private Label email_error;

    @FXML
    private Label address_error;

    @FXML
    private Label city_error;

    @FXML
    private Label nat_error;

    @FXML
    private Label passport_error;
    
    @FXML
    private Label cardN_error;

    @FXML
    private Label cvc_error;

    
    ObservableList<room> listG ;

    @FXML
    void clearbtn(ActionEvent event) {
    	name.setText("");
    	phone.setText("");
    	email.setText("");
    	address.setText("");
    	city.setText("");
    	nationnality.setText("");
    	passport.setText("");
    	cardNumber.setText("");
    	cvcCode.setText("");
//    	check_in_date.getValue()+"";
//    	check_out_date.getValue()+"";
    	
    	roomID.setText("");
    	
    	   name_error.setText("");;

    	    phone_error.setText("");

    	   email_error.setText("");

    	   address_error.setText("");

    	    city_error.setText("");

    	    nat_error.setText("");

    	     passport_error.setText("");
    	    
    	     cardN_error.setText("");

    	     cvc_error.setText("");
    	     

    	
    	

    }

    @FXML
    void searchbtn(ActionEvent event) {
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	LocalDate todayDate = LocalDate.now();
    	System.out.println(todayDate);
    	System.out.println();
    	
    	
    	
//    	System.out.println(getRoomCapacityValue() ==null);
    	System.out.println(check_in_date.getValue()==null);
    	if(getRoomCapacityValue()==null || getRoomTypeValue()==null || check_in_date.getValue()==null ||check_out_date.getValue() ==null) {
    		System.out.println("true");
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Champs Vide !!");
    		alert.setContentText("verifier votre donner de Room Data");
    		alert.show();
    	}else if (getDifferenceDays(Date.from(todayDate.atStartOfDay(defaultZoneId).toInstant()),Date.from(check_in_date.getValue().atStartOfDay(defaultZoneId).toInstant()))<0) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Date");
			alert.setContentText("Date of reservation should be from Min Today");
			alert.show();
		}
    	else if (getDifferenceDays(Date.from(check_in_date.getValue().atStartOfDay(defaultZoneId).toInstant()),Date.from(check_out_date.getValue().atStartOfDay(defaultZoneId).toInstant()))<0) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Date");
			alert.setContentText("verifier le date de reservation svp");
			alert.show();
		}
    	else {
    		
    	 checkIn_roomService rs=new checkIn_roomService();
    	 rooms_service room = new rooms_service();
    	 room.updateRoom();
    	 
		 listG = rs.findAvailableRoom(getRoomTypeValue().toUpperCase(), getRoomCapacityValue().toUpperCase(), check_in_date.getValue().toString());
		 System.out.println(getRoomTypeValue());
		 System.out.println(getRoomCapacityValue());
		 System.out.println(check_out_date.getValue().toString());
//		 System.out.println(listG.get(0).getRoomID());
//		 System.out.println(listG.get(0).getRoomID());
		 System.out.println(listG.size());
		 if (listG.size()==0) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("error");
			alert.setContentText(" Aucune room disponible  avec ses caractéristiques");
			alert.show();
		} else {
			
		 roomID.setText(listG.get(0).getRoomID()+"");
		}
		 
			
//   	data = new DataClass();
//   	list.addAll(data.getImportList());
   		
   		

    }
    }
    

    @FXML
    private MenuButton Menu;

    @FXML
    void GoToCheckIn(ActionEvent event) throws IOException {
    	
     FXMLLoader loader =new  FXMLLoader(getClass().getResource("/FXML/check_in.fxml"));
		
		Parent root =loader.load();
		check_inController scene2 = loader.getController();
		
		Stage stage= new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		

    }
    @FXML
    void GoToGusts(ActionEvent event)  throws IOException {
    	
     FXMLLoader loader =new  FXMLLoader(getClass().getResource("/FXML/guests.fxml"));
		
		Parent root =loader.load();
		guestsController scene2 = loader.getController();
		
		Stage stage= new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		

    }
   
    @FXML
    void goToRooms(ActionEvent event)  throws IOException {
    	
     FXMLLoader loader =new  FXMLLoader(getClass().getResource("/FXML/Rooms.fxml"));
		
		Parent root =loader.load();
		roomsController scene2 = loader.getController();
		
		Stage stage= new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		

    }

    connexion con;
    @FXML
    void submitbtn(ActionEvent event) throws IOException {

    	
    	//Connection
    	con= new connexion();
    	Connection connection = con.getCn();
    	
    	checkIn_roomService Guest = new checkIn_roomService();
    	String nameG=name.getText();
    	String phoneG=phone.getText();
    	String emailG=email.getText();
    	String addressG=address.getText();
    	String cityG=city.getText();
    	String nationnalityG=nationnality.getText();
    	String passportG=passport.getText();
    	String cardNumberG=cardNumber.getText();
    	String cvcCodeG=cvcCode.getText();
    	String check_in_dateG=check_in_date.getValue()+"";
    	String check_out_dateG=check_out_date.getValue()+"";
    	String RoomCapacity=getRoomCapacityValue();
    	String RoomType=getRoomTypeValue();
    	String roomIDG = roomID.getText();
    	
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	
    	if (nameG.isEmpty() || phoneG.isEmpty() || emailG.isEmpty() || addressG.isEmpty()
    			|| cityG.isEmpty()|| nationnalityG.isEmpty()|| passportG.isEmpty()|| cardNumberG.isEmpty()||
    			cvcCodeG.isEmpty()|| check_in_dateG.isEmpty() || check_out_dateG.isEmpty() || RoomCapacity.isEmpty() || RoomType.isEmpty() ) {
			
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Champ Vide");
    		alert.setContentText("Remplir tous les champs !");
    		alert.showAndWait();
		} else if (getDifferenceDays(Date.from(check_in_date.getValue().atStartOfDay(defaultZoneId).toInstant()),Date.from(check_out_date.getValue().atStartOfDay(defaultZoneId).toInstant()))<0) {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("CheckIn & checkOut  ");
    		alert.setContentText("Verif CheckIn and the checkOut date  !");
    		alert.showAndWait();
			
		}else {

    		System.out.println(getDifferenceDays(Date.from(check_in_date.getValue().atStartOfDay(defaultZoneId).toInstant()),Date.from(check_out_date.getValue().atStartOfDay(defaultZoneId).toInstant())));
    	guests g =new guests( Integer.parseInt( roomIDG), nameG, emailG, addressG, cityG, nationnalityG, passportG,  getDifferenceDays(Date.from(check_in_date.getValue().atStartOfDay(defaultZoneId).toInstant()),Date.from(check_out_date.getValue().atStartOfDay(defaultZoneId).toInstant())), 0, phoneG, cardNumberG,cvcCodeG  );
//    	table.getItems().add(p);
    	System.out.println(g.toString());
    	
    	Guest.createGuest(g);
        Guest.updateEmptyRoom(check_in_date.getValue().toString(), check_out_date.getValue().toString(), Integer.parseInt( roomIDG));
//        Guest.updateEmptyRoom(Integer.parseInt( roomIDG));
        GoToGusts(event);
    	
    		

		}
    	
    	
    }
    
    
    public static int getDifferenceDays(java.util.Date date, java.util.Date date2) {
        long diff = date2.getTime() - date.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public String getRoomTypeValue() {
        String RoomType = null;
        if (economy.isSelected()) {
            RoomType = "Economy";
        } else if (normal.isSelected()) {
            RoomType = "Normal";
        } else if (vip.isSelected()) {
            RoomType = "Vip";
        }
        return RoomType;
    }

    public String getRoomCapacityValue() {
        String RoomCapacity = null;
        if (single.isSelected()) {
            RoomCapacity = "Single";
        } else if (double_r.isSelected()) {
            RoomCapacity = "Double";
        } else if (triple.isSelected()) {
            RoomCapacity = "Triple";
        }
        return RoomCapacity;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//-----------------------------Handle Error-----------------------
	static boolean handel_nameField =false;
    @FXML
    void handel_nameField(KeyEvent event) {

    	name.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!name.getText().matches("[A-Za-z\\\\s]{2,}")){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    name_error.setText("Name must contain only letters");
                    name_error.setTextFill(Color.RED);
                    handel_nameField = true;
                }else {
                	name_error.setText("valid");
                    name_error.setTextFill(Color.GREEN);
                	
                }
            }

        });
//        if (Handle_PhoneField) {
//            if ((PhoneField.getText()).matches("[\\d\\s]+")) {
//                phone_error.setText("valid");
//                phone_error.setTextFill(Color.GREEN);
//            } else {
//                phone_error.setText("Phone number must be digits only");
//                phone_error.setTextFill(Color.RED);
//            }
//        }
    }
    static boolean handle_addressField =false;
    @FXML
    void handle_addressField(KeyEvent event) {
    	
    	address.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!address.getText().matches("^[a-zA-Z0-9 _.-]*$")){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    address_error.setText("Address must contain only\n letters and Number");
                    address_error.setTextFill(Color.RED);
                    handle_addressField = true;
                }else {
                	address_error.setText("valid");
                    address_error.setTextFill(Color.GREEN);
                	
                }
            }

        });
    	

    }
    static boolean handle_cardField =false;
    @FXML
    void handle_cardField(KeyEvent event) {
    	cardNumber.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(cardNumber.getText().matches("[A-Za-z\\\\s]{2,}") || cardNumber.getText().length()!=16 ){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    cardN_error.setText("card number must contain only Chiffre and 13 chiffre");
                    cardN_error.setTextFill(Color.RED);
                    handle_cardField = true;
                }else {
                	cardN_error.setText("valid");
                    cardN_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }
    static boolean handle_cityField =false;

    @FXML
    void handle_cityField(KeyEvent event) {
    	city.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!city.getText().matches("[A-Za-z\\\\s]{2,}")){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    city_error.setText("City must contain only letters and Min 2 lettres");
                    city_error.setTextFill(Color.RED);
                    handle_cityField = true;
                }else {
                	city_error.setText("valid");
                    city_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }
    static boolean handle_cvcField =false;
    @FXML
    void handle_cvcField(KeyEvent event) {
    	
    	cvcCode.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(cvcCode.getText().matches("[A-Za-z\\\\s]{2,}") || cvcCode.getText().length()!=3 ){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    cvc_error.setText("CVC must contain only Chiffre and 3 chiffre");
                    cvc_error.setTextFill(Color.RED);
                    handle_cityField = true;
                }else {
                	cvc_error.setText("valid");
                    cvc_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }

    static boolean handel_emailField =false;
    @FXML
    void handle_emailField(KeyEvent event) {
    	
    	email.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
            	 String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                if(!email.getText().matches(EMAIL_REGEX)){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    email_error.setText("Must be at this form : user@domain.com");
                    email_error.setTextFill(Color.RED);
                    handel_emailField = true;
                }else {
                	email_error.setText("valid");
                	email_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }
    static boolean handle_natField =false;

    @FXML
    void handle_natField(KeyEvent event) {
    	nationnality.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!nationnality.getText().matches("[A-Za-z\\\\s]{2,}")){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    nat_error.setText("Nationnality must contain only letters");
                    nat_error.setTextFill(Color.RED);
                    handle_natField = true;
                }else {
                	nat_error.setText("valid");
                	nat_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }
    static boolean handle_passField =false;
    @FXML
    void handle_passField(KeyEvent event) {
    	passport.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(passport.getText().matches("[A-Za-z\\\\s]{2,}") || passport.getText().length() !=8 ){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    passport_error.setText("passport must contain only Chiffre and 3 chiffre");
                    passport_error.setTextFill(Color.RED);
                    handle_passField = true;
                }else {
                	passport_error.setText("valid");
                    passport_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }
    
    static boolean handle_phoneField =false;
    @FXML
    void handle_phoneField(KeyEvent event) {
    	phone.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!phone.getText().matches("[\\d\\s]+") || phone.getText().length() !=8 ){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    phone_error.setText("phone must be Number and 8 chiffre ");
                    phone_error.setTextFill(Color.RED);
                    handle_phoneField = true;
                }else {
                	phone_error.setText("valid");
                    phone_error.setTextFill(Color.GREEN);
                	
                }
            }

        });

    }

}
