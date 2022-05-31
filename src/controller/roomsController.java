package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Ma.project.Beans.room;
import Ma.project.services.rooms_service;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class roomsController implements Initializable {

    @FXML
    private TableColumn<room, Integer> id;

    @FXML
    private TableColumn<room, String> roomType;

    @FXML
    private TableColumn<room, String> roomCapacity;

    @FXML
    private TableColumn<room, String> inDate;

    @FXML
    private TableColumn<room, String> out_date;

    @FXML
    private TableColumn<room, Integer> available;
    
    @FXML
    private TableView<room> table;
    
    @FXML
    private MenuButton Menu;
    
    
    @FXML
    public void remove(ActionEvent event) {
    	System.out.println((table.getSelectionModel().getSelectedItems()).isEmpty());
    	if ((table.getSelectionModel().getSelectedItems()).isEmpty()) {
    		Alert alert= new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Error !!");
    		alert.setContentText("Choisir une ligne SVP!!");
    		alert.showAndWait();
			
		}else {
			
    	Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("CheckIn & checkOut  ");
		alert.setContentText("Verif CheckIn and the checkOut date  !");
		alert.showAndWait();
		System.out.println(alert.getResult().getText());
//		System.out.println((alert.getResult().getText()) =="OK");
		if(alert.getResult().getText().equals("OK")) {
			
    	rooms_service ps=new rooms_service();
    	ps.delete(table.getSelectionModel().getSelectedItems().get(0));
    	
//    	for test :)
    	System.out.println(table.getSelectionModel().getSelectedItems().get(0).getRoomID());
		}
		}

    }

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
    
    ObservableList<room> listR ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		private SimpleIntegerProperty roomID;
//		private SimpleStringProperty room_Type;
//		private SimpleStringProperty room_capacity;
//		private SimpleStringProperty Check_In_Date;
//		private SimpleStringProperty Check_Out_Date;
//		private SimpleIntegerProperty isEmpty;
		  
		id.setCellValueFactory(new PropertyValueFactory<>("roomID"));
		roomType.setCellValueFactory(new PropertyValueFactory<>("room_Type"));
		
		roomCapacity.setCellValueFactory(new PropertyValueFactory<>("room_capacity"));
		inDate.setCellValueFactory(new PropertyValueFactory<>("Check_In_Date"));
		out_date.setCellValueFactory(new PropertyValueFactory<>("Check_Out_Date"));	
		available.setCellValueFactory(new PropertyValueFactory<>("isEmpty"));
		
		 rooms_service rs=new rooms_service();
   	  listR = rs.findAll();
   	  System.out.println(listR);
			
//   	data = new DataClass();
//   	list.addAll(data.getImportList());
   		
   		table.setItems(listR);
		
	}

}
