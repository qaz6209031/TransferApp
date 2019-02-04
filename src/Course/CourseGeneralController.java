/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import com.jfoenix.controls.JFXButton;
import dbUtil.dbConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 13354
 */
public class CourseGeneralController implements Initializable {


    @FXML private JFXButton backbtn;
    @FXML private JFXButton adminbtn;
    @FXML private TableView<CourseData> table;
    @FXML private TableColumn<CourseData, String> colTitle;
    @FXML private TableColumn<CourseData, String> colID;
    @FXML private TableColumn<CourseData, Integer> colUnits;
    @FXML private TableColumn<CourseData, String> colType;
    
    ObservableList<CourseData> list = FXCollections.observableArrayList();
    
    private dbConnection dbConnection;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbConnection = new dbConnection();
        try{
            load();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }    
    ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////load course function/////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    private void load() throws SQLException{
        // this.dbConnection = new dbConnection();
       // Connection conn = dbConnection.getConnection();
       Connection conn = null;
       ResultSet rs = null;
        try{
        conn = dbConnection.getConnection();
       // Connection conn = dbConnection.getConnection();
        rs = conn.createStatement().executeQuery("SELECT CourseTitle, CourseID, CourseUnit, CourseType FROM courses");
        //Connection conn = dbConnection.getConnection();
        while(rs.next()){
            list.add(new CourseData(rs.getString("CourseTitle"), rs.getString("CourseID"), rs.getInt("CourseUnit"), rs.getString("CourseType")));
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        finally{
            rs.close();
            conn.close();
        }
        colTitle.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
       // PreparedStatement ps_course = conn.prepareStatement("");
        colID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        colUnits.setCellValueFactory(new PropertyValueFactory<>("CourseUnit"));
        colType.setCellValueFactory(new PropertyValueFactory<>("CourseType"));
        
        table.setItems(list);
    }
    //////////////////////////////////////////////////////////////////
    /////////////////button for navigate back to main page////////////
    //////////////////////////////////////////////////////////////////
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
    //////////////////////////////////////////////////////////////////
    /////////////////button for navigate back to admin////////////
    //////////////////////////////////////////////////////////////////
    @FXML
    public void AdminLogin(ActionEvent event){
        try{
                Stage stage = (Stage)this.backbtn.getScene().getWindow();
                stage.close();
                AdminPage();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void AdminPage(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Course/PopLogin.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Admin Login Page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
