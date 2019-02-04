/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPage;

import com.jfoenix.controls.JFXButton;

import Start.Start;
import dbUtil.dbConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * color documentation :#2D75EB
 */
public class MainController implements Initializable {

    private dbConnection dbConnection;
    private String check_students_table = "create table if not exists students(smcID TEXT,userid TEXT,password TEXT,enroll_semester TEXT,enroll_year TEXT,email TEXT)";
    private String check_login_table = "create table if not exists login(userid TEXT,password TEXT)";
    private String check_Contacts_table = "create table if not exists Contacts(Fname TEXT, Lname TEXT, Email TEXT, Office TEXT, Office_hour TEXT, Photo BLOB)";
    private String check_course_table = "create table if not exists courses(CourseID VARCHAR(50)," +"CourseTitle VARCHAR(50)," +
                    "CourseUnit INTEGER ," +"CourseType VARCHAR(50))";
    private String insert_admin_key = "INSERT INTO login(userid,password) " +"VALUES('admin','LISA')";
    private String check_admin_exist ="select * from login where userid = 'admin'";

    @FXML
    private JFXButton studentbtn;
    
    @FXML
    private JFXButton bt_UC;
    
    @FXML
    private JFXButton calenderbtn;
    @FXML
    private JFXButton coursebtn;
    
    @FXML
    private Button bt_music;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 dbConnection = new dbConnection();
         try{
         checkDb();
         }
         catch(SQLException ex){
             ex.printStackTrace();
         }
    }    
    
    public void checkDb() throws SQLException{
        PreparedStatement ps_check_students = null;
        PreparedStatement ps_check_login = null;
        PreparedStatement ps_check_course = null;
        PreparedStatement ps_check_contact = null;
        PreparedStatement ps_check_admin_exsit;
        PreparedStatement ps_insert_admin = null;
        ResultSet rs = null;
        Connection conn = null;
        try{
            conn = this.dbConnection.getConnection();
            ps_check_students = conn.prepareStatement(check_students_table);
            ps_check_login = conn.prepareStatement(check_login_table);
            ps_check_contact = conn.prepareStatement(check_Contacts_table);
            ps_check_course = conn.prepareStatement(check_course_table);
            ps_check_admin_exsit = conn.prepareStatement(check_admin_exist);
            ps_insert_admin = conn.prepareStatement(insert_admin_key);
            

            
            ps_check_students.execute();
            ps_check_login.execute();
            ps_check_course.execute();
            ps_check_contact.execute();
            
            rs = ps_check_admin_exsit.executeQuery();
            if(!rs.next()){
                ps_insert_admin.execute();
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            ps_check_students.close();
            ps_check_login.close();
            ps_check_course.close();
            ps_check_contact.close();
            rs.close();
            conn.close();
        }
    }
    
    //Action handler for signupbtn
    @FXML
    public void Login(ActionEvent event){
        try{
                Stage stage = (Stage)this.studentbtn.getScene().getWindow();
                stage.close();
                StudentLogin();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
      
 
    //StudentLogin opens the login page
    public void StudentLogin(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Login Page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML
    public void goto_UCMain() {
    	  try{
    		  Stage stage = (Stage)this.studentbtn.getScene().getWindow();
              stage.close();
              
              Stage userstage = new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("/UC_CSU/UC_CSU.fxml"));
              Scene scene = new Scene(root);
              userstage.setScene(scene);
              userstage.setTitle("School Page");
              userstage.setResizable(false);
              userstage.show();
          }
          catch(IOException ex){
              ex.printStackTrace();
          }
    	  catch(Exception ex){
              ex.printStackTrace();
          }
    	
    	
    }
    
    @FXML
    private void goto_ProgramsMain(ActionEvent event) {
    	try {
    	Stage stage = (Stage)this.studentbtn.getScene().getWindow();
        stage.close();
        
        Stage userstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Programs_Main/Programs_Main.fxml"));
        Scene scene = new Scene(root);
        userstage.setScene(scene);
        userstage.setTitle("SMC Programs");
        userstage.setResizable(false);
        userstage.show();
    	}
        catch(IOException ex){
            ex.printStackTrace();
        }
  	    catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void goto_SearchPf(ActionEvent event) {
    	try {
        	Stage stage = (Stage)this.studentbtn.getScene().getWindow();
            stage.close();
            
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Search_Pf/Search_Pf.fxml"));
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Professor's Contacts");
            userstage.setResizable(false);
            userstage.show();
        	}
            catch(IOException ex){
                ex.printStackTrace();
            }
      	    catch(Exception ex){
                ex.printStackTrace();
            }
    }
    @FXML
    public void openCalender(ActionEvent event){
        try{
                Stage stage = (Stage)this.studentbtn.getScene().getWindow();
                stage.close();
                Calender();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void Calender(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Calendar/TimeTable.fxml"));
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Calender page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML
    public void openCourse(ActionEvent event){
        try{
                Stage stage = (Stage)this.studentbtn.getScene().getWindow();
                stage.close();
                Course();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void Course(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Course/CourseGeneral.fxml"));
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Course page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    public void music(ActionEvent event) {
    	if(bt_music.getText().equals("||")) {
    		Start.mediaplayer.pause();
    		bt_music.setText(">");
    	}
    	else {
    		Start.mediaplayer.play();
    		bt_music.setText("||");
    	}
    	
    }
    
}
