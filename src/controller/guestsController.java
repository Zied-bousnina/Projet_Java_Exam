package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Ma.project.Beans.guests;
import Ma.project.Beans.room;
import Ma.project.services.guests_service;
import Ma.project.services.rooms_service;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class guestsController implements Initializable{
	
	   @FXML
	    private TableView<guests> table;

    @FXML
    private TableColumn<guests, String> roomID;

    @FXML
    private TableColumn<guests, String> name;

    @FXML
    private TableColumn<guests, String> email;

    @FXML
    private TableColumn<guests, String> address;

    @FXML
    private TableColumn<guests, String> city;

    @FXML
    private TableColumn<guests, String> nationnality;

    @FXML
    private TableColumn<guests, String> passport;

    @FXML
    private TableColumn<guests, String> phone;

    @FXML
    private TableColumn<guests, String> days;

    @FXML
    private TableColumn<guests, Double> fees;

    @FXML
    private MenuButton Menu;
    
    ObservableList<guests> listG ;

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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		private SimpleIntegerProperty roomID;
//		private SimpleStringProperty name;
//		private SimpleStringProperty email;
//		private SimpleStringProperty adress;
//		private SimpleStringProperty city;
//		private SimpleStringProperty Nationnality;
//		private SimpleStringProperty passport;
//		private SimpleStringProperty phone;
//		
//		private SimpleIntegerProperty days;
//		private SimpleDoubleProperty fees;
		  
		  roomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
		  name.setCellValueFactory(new PropertyValueFactory<>("name"));
		  email.setCellValueFactory(new PropertyValueFactory<>("email"));
		  address.setCellValueFactory(new PropertyValueFactory<>("adress"));
		  city.setCellValueFactory(new PropertyValueFactory<>("city"));
		  nationnality.setCellValueFactory(new PropertyValueFactory<>("Nationnality"));	
		  passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
		  phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		  days.setCellValueFactory(new PropertyValueFactory<>("days"));
		  fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
			
			 guests_service rs=new guests_service();
			 listG = rs.findAll();
			
				
//	   	data = new DataClass();
//	   	list.addAll(data.getImportList());
	   		
	   		table.setItems(listG);
		
	}
//	private void editableCols() {
		// TODO Auto-generated method stub
//		roomID.setCellFactory(TextFieldTableCell.forTableColumn());
//		name.setCellFactory(TextFieldTableCell.forTableColumn());
//		email.setCellFactory(TextFieldTableCell.forTableColumn());
//		firstNameCol.setOnEditCommit(e->{
//			e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom(e.getNewValue());
//		});
//		
//		lastNameCol.setOnEditCommit(e->{
//			e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrenom(e.getNewValue());
//		});
//		
//		emailCol.setOnEditCommit(e->{
//			e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue());
//		});
//		table.setEditable(true);
//		
//		
//	}
}
