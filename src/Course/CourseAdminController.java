/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

/*import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
*/
/**
 * FXML Controller class
 *
 * @author josej
 */


//public class CourseaddController implements Initializable {

    /**
     * Initializes the controller class.
     */
  /*  @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}*/

import dbUtil.dbConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.print.PrintColor.COLOR;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CourseAdminController implements Initializable {
    
    @FXML private Button addCourse;
    @FXML private Button removeCourse;
    @FXML private Button returnBack;
    
    @FXML private TextField tfTitle;
    @FXML private TextField tfID;
    @FXML private TextField tfUnits;
    @FXML private TextField tfRemove;
    @FXML private TextField tfCourseType;
    @FXML private Label lblCheck;
    
    @FXML private TableView<CourseData> table;
    @FXML private TableColumn<CourseData, String> colTitle;
    @FXML private TableColumn<CourseData, String> colID;
    @FXML private TableColumn<CourseData, Integer> colUnits;
    @FXML private TableColumn<CourseData, String> colType;
    ObservableList<CourseData> list = FXCollections.observableArrayList();
    
    private dbConnection dbConnection;
    
    
    
    @FXML
    private void AddAction(ActionEvent event) throws SQLException {
        if(!isValidDataField()){
            this.lblCheck.setText("you should fill out all the blanks!!");
            return;
        }
       
        lblCheck.setText("");
        CourseData st = new CourseData(tfTitle.getText(), tfID.getText(), Integer.parseInt(tfUnits.getText()), tfCourseType.getText());
        table.getItems().add(st);
        addCourseData();
        tfTitle.clear();
        tfID.clear();
        tfUnits.clear();
        tfCourseType.clear();
    }
  
    
    @FXML
    private void removeButtonAction(ActionEvent event) throws SQLException {
        if(!isValidDataField()){
            this.lblCheck.setText("cannot remove course!");
            return;
        }
        removeCourseData();
        table.getItems().clear();
        load();
        tfRemove.clear();

    }
    
    public void returnBack(ActionEvent event){
        Stage stage = (Stage)this.returnBack.getScene().getWindow();
        stage.close();
        changeScene();
    }
    
    public void changeScene(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Course/CourseGeneral.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Course");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
   

    
    //cmbType.setItems(options);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.dbConnection = new dbConnection();
        try{
            load();
        } catch(SQLException ex){
            ex.printStackTrace();
        }     
    }    
    
    private void load() throws SQLException{
       
       Connection conn = null;
       ResultSet rs = null;
        try{
        conn = dbConnection.getConnection();
      
        rs = conn.createStatement().executeQuery("SELECT CourseTitle, CourseID, CourseUnit, CourseType FROM courses");
    
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
        colID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        colUnits.setCellValueFactory(new PropertyValueFactory<>("CourseUnit"));
        colType.setCellValueFactory(new PropertyValueFactory<>("CourseType"));
        
        table.setItems(list);
        
    }
        
    private void addCourseData() throws SQLException{
        String sql_insert_to_courses = "INSERT INTO courses(CourseID,CourseTitle,CourseUnit,CourseType) VALUES (?, ?, ?, ?)";
        try{
            Connection conn = dbConnection.getConnection();
            PreparedStatement ps_course = conn.prepareStatement(sql_insert_to_courses);
          
            ps_course.setString(1, this.tfID.getText());
            ps_course.setString(2, this.tfTitle.getText());
            ps_course.setString(3, this.tfUnits.getText());
            ps_course.setString(4, this.tfCourseType.getText());
          
            ps_course.execute();
            
            conn.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void removeCourseData() throws SQLException{
        String sql_remove_courses = "DELETE FROM courses WHERE CourseID = ?";
        try{
           
            String id = tfRemove.getText();
            System.out.println(id);
            Connection conn = dbConnection.getConnection();
            PreparedStatement ps_course = conn.prepareStatement(sql_remove_courses);
            
            ps_course.setString(1,id);
            
            ps_course.executeUpdate();
            
            conn.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
}
    private boolean isValidDataField(){
        if(this.tfID.getText().isEmpty() |this.tfTitle.getText().isEmpty()|
           this.tfUnits.getText().isEmpty()| this.tfCourseType.getText().isEmpty())
        {
            return false;
        }
        return true;
    }
        private boolean isValidDataField2(){
        if(this.tfRemove.getText().isEmpty())
        {
            return false;
        }
        return true;
    }

}