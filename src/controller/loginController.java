package controller;

import java.io.IOException;

import Ma.project.Beans.user;
import Ma.project.services.UserService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbtn;

    ObservableList<user> listU;
    
    @FXML
    void submit(ActionEvent event) throws IOException{
    	System.out.println(userName.getText());
    	System.out.println(password.getText());
    	
    	UserService user = new UserService();
    	if (!userName.getText().isEmpty() && !password.getText().isEmpty()) {
    		listU = user.findByUserNameAndPass(userName.getText(), password.getText());
			
    	if (listU.size()==0) {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("USER name");
    		alert.setContentText("Verif UserName or Password !");
    		alert.showAndWait();
			
		}else {
			
    	System.out.println(listU.get(0).getIs_admin());
    	System.out.println(listU.get(0).getUser_name());
    	System.out.println(listU.get(0).getUser_pass());
    	
    	FXMLLoader loader =new  FXMLLoader(getClass().getResource("/FXML/check_in.fxml"));
//		
		Parent root =loader.load();
		check_inController scene2 = loader.getController();
		
		Stage stage= new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		}
    	}else {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Champs vide !");
    		alert.setContentText("Remplire les champs SVP!");
    		alert.showAndWait();
			
		}
//    	FXMLLoader loader =new  FXMLLoader(getClass().getResource("/FXML/check_in.fxml"));
//		
//		Parent root =loader.load();
//		check_inController scene2 = loader.getController();
//		
//		Stage stage= new Stage();
//		stage.setScene(new Scene(root));
//		stage.show();
		
		
		

    }

}