/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import StudentPlan.StudentPlanController;
import com.jfoenix.controls.JFXButton;
import dbUtil.dbConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * color documentation :#2D75EB
 */
public class LoginController implements Initializable{
    
    @FXML
    private TextField txtuserid;
    
    @FXML
    private PasswordField txtpassword;
    
    
    @FXML
    private Label loginlabel;
    
    @FXML
    private Button loginbtn;

    @FXML
    private Button signupbtn;
    
    @FXML
    private JFXButton backbtn;
//    
//    @FXML
//    private ImageView smcImage;
//    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    ///////////////////////////////////////////
    /////login button//////////////////////////
    ///////////////////////////////////////////
    public boolean isLogin(String _username,String _password) throws Exception{
        PreparedStatement prepared_statement = null;
        ResultSet result_set = null;
        Connection connection = null;
        String sql = "select * from login where userid = ? and password = ?";
        
        try{
            connection = dbConnection.getConnection();
            prepared_statement = connection.prepareStatement(sql);
            prepared_statement.setString(1, _username);
            prepared_statement.setString(2, _password);
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
            if(isLogin(txtuserid.getText(), txtpassword.getText())){
                //loginlabel.setText("Valid username and password");
                Stage stage = (Stage)this.txtpassword.getScene().getWindow();
                //stage.close();
                StudentLogin(txtuserid.getText());
                
            }
            else{
            loginlabel.setText("*Invalid username or password!!!");
            loginlabel.setTextFill(Color.RED);
            }
        }
        catch(SQLException | IOException ex){
            ex.printStackTrace();
            loginlabel.setText("System error!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void StudentLogin(String _userid){
        try{
            Stage userstage = new Stage();
            StudentPlanController.setUserId(_userid);
            Parent root = FXMLLoader.load(getClass().getResource("/StudentPlan/StudentPlan.fxml"));
            Stage stage = (Stage)this.backbtn.getScene().getWindow();
            stage.close();
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle(_userid + " 's Dashboard");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////////////
    /////////////////signup button///////////////////////////////
    /////////////////////////////////////////////////////////////
    
    //Action handler for signupbtn
    @FXML
    public void SignUp(ActionEvent event){
        try{
                Stage stage = (Stage)this.txtpassword.getScene().getWindow();
                stage.close();
                StudentSignUp();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //StudentSignUp opens the sign up page
    public void StudentSignUp(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/SignUp/SignUp.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Sign Up Page");
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
    public void BackToMain(ActionEvent event){
        try{
                Stage stage = (Stage)this.backbtn.getScene().getWindow();
                stage.close();
                MainPage();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void MainPage(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/MainPage/Main.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Main Page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    
    
    
    
    
}
