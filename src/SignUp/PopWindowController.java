/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

import java.io.IOException;
import java.net.URL;
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
 * @author 13354
 */
public class PopWindowController implements Initializable {

    @FXML
    private Button backbtn;
    
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
