package Search_Pf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dbUtil.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Search_Pf_Controller {


    @FXML
	private ImageView imageview;
	
    @FXML
	private JFXTextField txf_FName;
    
    @FXML
  	private JFXTextField txf_LName;

    @FXML
	private TextField txf_email;
   
    @FXML
   	private TextField txf_office;
    
    @FXML
    private TextArea txa_office_hour;
    
    @FXML
    private TextField txf_name;
    
    @FXML
    private Label lbl_error;


	public void search(ActionEvent event) throws SQLException {
		Connection connection = null;
		PreparedStatement pr = null;
		ResultSet rset = null;
		
		try {
			connection = dbConnection.getConnection();
			String Fname =((String)(txf_FName.getText())).toLowerCase();
			String Lname =((String)(txf_LName.getText())).toLowerCase();
			
			
			String sql = "select * from Contacts where Fname = ? or Lname = ?";
			
			pr = connection.prepareStatement(sql);
			pr.setString(1, Fname); 
			pr.setString(2, Lname); 
			rset =pr.executeQuery();
			
			if(txf_FName.getText().equals("")&&txf_LName.getText().equals(""))
				lbl_error.setText("***Please enter either first name or last name***");
			else if(rset.next()) {
			  String fname = rset.getString(1);
			  String lname = rset.getString(2);
		      String email = rset.getString(3);
		      String office = rset.getString(4);
		      String office_hour = rset.getString(5);
		     
		      //Read the Photo through the binary Stream
		      InputStream input = rset.getBinaryStream("Photo");
		      //Construct the image with InputStream
		      Image image = new Image(input);
		      //Show image 
		      imageview.setImage(image);
		      
		      txf_name.setText(fname + " " + lname);
		      txf_email.setText(email);
		      txf_office.setText(office);
		      txa_office_hour.setText(office_hour);
			}
			else {
				txf_name.setText("Not in DataBase");
				txf_email.setText("Not in DataBase");
				txf_office.setText("Not in DataBase");
				txa_office_hour.setText("Not in DataBase");
				imageview.setImage(null);
				lbl_error.setText(null);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			txf_FName.clear();
			txf_LName.clear();
			pr.close(); 
			rset.close();
			connection.close();

		}
	}
	
    @FXML
    void _backHome(ActionEvent event) {
    	close_Stage();
    	 try {
			  Stage userstage = new Stage();
	          Parent root = FXMLLoader.load(getClass().getResource("/MainPage/Main.fxml"));
	          Scene scene = new Scene(root);
	          userstage.setScene(scene);
	          userstage.setTitle("Main Page");
	          userstage.setResizable(false);
	          userstage.show();
		 }
		 catch(IOException ex) {
			   ex.printStackTrace();
		 }
    	

    }
    
    @FXML
    private void Admin_Login(ActionEvent event) {
    	close_Stage();
    	 try {
   		  Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Administrator Login");
            userstage.setResizable(false);
            userstage.show();
   	 }
   	 catch(IOException ex) {
   		   ex.printStackTrace();
   	 }

    }
    
    private void close_Stage() {
    	Stage stage = (Stage)this.txf_FName.getScene().getWindow();
    	stage.close();
    }
   
}