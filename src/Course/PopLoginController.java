/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import StudentPlan.StudentPlanController;
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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 13354
 */
public class PopLoginController implements Initializable {
    @FXML
    private JFXPasswordField txtkey;
    @FXML
    private JFXButton backbtn;
    @FXML
    private JFXButton loginbtn;
    @FXML
    private Label infolbl;
    //member variable for connecting the database
    private dbConnection dbConnection;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbConnection = new dbConnection();
    }    
    ///////////////////////////////////////////
    /////login button//////////////////////////
    ///////////////////////////////////////////
    public boolean isLogin(String _key) throws Exception{
        PreparedStatement prepared_statement = null;
        ResultSet result_set = null;
        Connection connection = null;
        String sql = "SELECT password from login where userid = 'admin' and password = ?";
        
        try{
            connection = this.dbConnection.getConnection();
            prepared_statement = connection.prepareStatement(sql);
            prepared_statement.setString(1, _key);
            result_set = prepared_statement.executeQuery();
            if(result_set.next()) return true;
            return false;
        }
        catch(SQLException ex) {return false;}
        finally{
            prepared_statement.close();
            result_set.close();
            connection.close();
        }
    }
    //Action handler for Login button
    @FXML
    public void LoginCheck(ActionEvent event){
        try{
            if(isLogin(txtkey.getText())){
                //loginlabel.setText("Valid username and password");
                Stage stage = (Stage)this.txtkey.getScene().getWindow();
                stage.close();
                AdminLogin();
                
            }
            else{
            infolbl.setText("*Invalid Key!!!");
            infolbl.setTextFill(Color.WHITE);
            }
        }
        catch(SQLException | IOException ex){
            ex.printStackTrace();
            infolbl.setText("System error!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AdminLogin(){
        try{
            Stage userstage = new Stage();
            
            Parent root = FXMLLoader.load(getClass().getResource("/Course/CourseAdmin.fxml"));
            Stage stage = (Stage)this.backbtn.getScene().getWindow();
            stage.close();
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Admin Course Page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////
    /////////////////button for navigate back to main page////////////
    //////////////////////////////////////////////////////////////////
    @FXML
    public void BackToCourseGeneral(ActionEvent event){
        try{
                Stage stage = (Stage)this.backbtn.getScene().getWindow();
                stage.close();
                CoursePage();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void CoursePage(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Course/CourseGeneral.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Admin login Page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
