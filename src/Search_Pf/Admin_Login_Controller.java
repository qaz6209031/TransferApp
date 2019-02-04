package Search_Pf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dbUtil.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Admin_Login_Controller {
	
	@FXML
    private JFXTextField Admin_key;
	@FXML
	private Label lbl_warning;

	@FXML
	private JFXButton bt_back;
	
	 @FXML
	    private void back(ActionEvent event) {
	    	Stage stage = (Stage)this.bt_back.getScene().getWindow();
	    	stage.close();
	    	try {
	    		 Stage userstage = new Stage();
	             Parent root = FXMLLoader.load(getClass().getResource("Search_Pf.fxml"));
	             Scene scene = new Scene(root);
	             userstage.setScene(scene);
	             userstage.setTitle("Professor's Contacts");
	             userstage.setResizable(false);
	             userstage.show();
	    	 }
	    	 catch(IOException ex) {
	    		   ex.printStackTrace();
	    	}
	   }
	 
	 @FXML
	 private void login(ActionEvent event) {
		 if(Admin_key.getText().equals(""))
			 lbl_warning.setText("**Please enter key**");
		 else if(Admin_key.getText().equals("LISA")) {
			 Stage stage = (Stage)this.bt_back.getScene().getWindow();
		     stage.close();
			 try {
	    		 Stage userstage = new Stage();
	             Parent root = FXMLLoader.load(getClass().getResource("/Contacts/Contacts.fxml"));
	             Scene scene = new Scene(root);
	             userstage.setScene(scene);
	             userstage.setTitle("Professor's Contacts");
	             userstage.setResizable(false);
	             userstage.show();
	    	 }
	    	 catch(IOException ex) {
	    		   ex.printStackTrace();
	    	}
		 }
		 //login
		 else
			 lbl_warning.setText("**Invalid key**");
			 
		 
		 
		 Admin_key.clear();
	 }
	       
}
