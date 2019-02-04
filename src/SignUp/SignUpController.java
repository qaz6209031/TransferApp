/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @color documentation: #2D75EB
 */
public class SignUpController implements Initializable {
    
    /////////////////////////////////////////////////
    //load necessary textfilds for sign up///////////
    ////////////////////////////////////////////////
    @FXML
    private JFXTextField txtsmcid;
    
    @FXML
    private JFXTextField txtusername;
    
    @FXML
    private JFXPasswordField txtpassword;
    
    @FXML
    private JFXTextField txt_enroll_semester;
    
    @FXML
    private JFXTextField txt_enroll_year;
    
    @FXML
    private JFXTextField txtemail;
    
    @FXML
    private JFXButton signupbtn;
    
    @FXML
    private JFXButton backbtn;
    
    @FXML
    private Label infolbl;
    
    
    //member variable for connecting the database
    private dbConnection dbConnection;
    /////////////////////////////////////////////////
    //member functions for manipulating databse//////
    /////////////////////////////////////////////////
    
    //add student data to the login table/ students table, also creates a table named userid+Course used for store students courses
    @FXML
    private void addStudentData(ActionEvent event) throws SQLException{
        //first check if the textfileds are empty
        if(!validateField()) return;
        String _inputuser = this.txtusername.getText();
        if(isUserExist(_inputuser)){ 
            this.infolbl.setText("This userid has been used!");
            return;
        }
        String enroll_semester = ((String)this.txt_enroll_semester.getText()).toUpperCase();
        System.out.println(enroll_semester);
        if(!enroll_semester.equals("SPRING")&&!enroll_semester.equals("SUMMER")&&
                !enroll_semester.equals("FALL")&&!enroll_semester.equals("WINTER")){
            this.infolbl.setText("Ops,invalid semester input,try again!!");
            return;
        }
        String sql_insert_to_login = "INSERT INTO login(userid,password) VALUES (?,?)";
        String sql_insert_to_students = "INSERT INTO students(smcID,userid,password,enroll_semester,enroll_year,email) VALUES (?,?,?,?,?,?)";
        String sql_add_course_schedule = "create table " +txtusername.getText() + "Course(CourseName TEXT, Unit INTEGER, Semester TEXT)";
        PreparedStatement ps_login = null;
        PreparedStatement ps_students = null;
        PreparedStatement ps_add_course_schedule = null;
        Connection conn = null;
        try{
            conn =dbConnection.getConnection();
            ps_login = conn.prepareStatement(sql_insert_to_login);
             ps_students = conn.prepareStatement(sql_insert_to_students);
             ps_add_course_schedule = conn.prepareStatement(sql_add_course_schedule);
            //add student data to login.db
            ps_login.setString(1, this.txtusername.getText());
            ps_login.setString(2, this.txtpassword.getText());
            ps_login.executeUpdate();
            
            //add student data to students.db
            ps_students.setString(1, this.txtsmcid.getText());
            ps_students.setString(2, _inputuser);
            ps_students.setString(3, this.txtpassword.getText());
            ps_students.setString(4, enroll_semester);
            ps_students.setString(5, this.txt_enroll_year.getText());
            ps_students.setString(6, this.txtemail.getText());
            ps_students.executeUpdate();
            
            ps_add_course_schedule.executeUpdate();
            

            
            
            //finishing sign up, display successful and then go back to login page
            Stage stage = (Stage)this.txtpassword.getScene().getWindow();
            stage.close();
            popWindow();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
        //disconnect from the database
        ps_login.close();
        ps_students.close();
        ps_add_course_schedule.close();
        conn.close();
        }
        
    }
    public void popWindow(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("PopWindow.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    //backbtn action function, direct the user back to the main page////////////
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void BackToLogin(ActionEvent event){
        try{
                Stage stage = (Stage)this.backbtn.getScene().getWindow();
                stage.close();
                LoginPage();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void LoginPage(){
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
    ////////////////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbConnection = new dbConnection();
    }    
////////////////////////////////////////////////////////////////////////////
//function to check if the textfileds are empty/////////////////////////////
////////////////////////////////////////////////////////////////////////////
    private boolean validateField(){
        if(this.txtsmcid.getText().isEmpty() |this.txtusername.getText().isEmpty()|
           this.txt_enroll_semester.getText().isEmpty()| this.txtpassword.getText().isEmpty()|
           this.txt_enroll_year.getText().isEmpty()|this.txtemail.getText().isEmpty())
        {
            this.infolbl.setText("you should fill out all the blanks!!");
            return false;
        }
        return true;
    }

    //////////////////////function to check if userid has been registered/////////////////
    //////////////////////////////////////////////////////////////////////////////////////
    private boolean isUserExist(String _inputId) throws SQLException{
        String check_user_exist ="select * from login where userid ='" + _inputId +"'";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = this.dbConnection.getConnection();
            ps = conn.prepareStatement(check_user_exist);
            rs = ps.executeQuery();
            if(rs.next()) return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            ps.close();
            rs.close();
            conn.close();
        }
        return false;
    }
}
