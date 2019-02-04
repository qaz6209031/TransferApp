/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentPlan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Structure.Profile;
import Structure.Courses;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dbUtil.dbConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *@color documentation: #2D75EB
 * @author 13354
 */
public class StudentPlanController implements Initializable {
    
    
    
    private Map<String,VBox> semester_to_vbox_dictionary = new HashMap<>() ;
	//ObservableList<String> unitList = FXCollections.observableArrayList("1","2","3","4","5");


    public Profile current_profile;
    public static String USERID;
    ////////////////////////////
    //data base member variable//
    ////////////////////////////
        
    private dbConnection dbConnection;
        
        ////////////////////////////////
        /////UI controls////////////////
        ///////////////////////////////
//	@FXML
//	private ChoiceBox unit;
//	
//	@FXML
//	private Button btAdd;
//	@FXML
//	private Button btRemove;
//	
//	@FXML
//	private TextField main_Name;
//	@FXML
//	private TextField main_major;
//	@FXML
//	private TextField main_school;
//	@FXML
//	private TextField add_Semester;
//	@FXML
//	private TextField add_Course;
//	
        

    @FXML
    private JFXTextField txtsemester;
    @FXML
    private JFXTextField txtcoursename;
    @FXML 
    private JFXTextField txtcoursename2;    //this is for removebtn
    @FXML
    private JFXTextField txtunit;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton removebtn;
    //testing code
    @FXML
    private JFXButton backbtn;
    @FXML
    private Label testlbl;

    
    
    //tables
    @FXML
    private TableView<CourseData> table1;
    @FXML
    private TableView<CourseData> table2;
    @FXML
    private TableView<CourseData> table3;
    @FXML
    private TableView<CourseData> table4;
    @FXML
    private TableView<CourseData> table5;
    @FXML
    private TableView<CourseData> table6;
    @FXML
    private TableView<CourseData> table7;
    @FXML
    private TableView<CourseData> table8;
    @FXML
    private TableView<CourseData> table9;      

    //columns
    @FXML
    private TableColumn<CourseData, String> semester1Column;
    @FXML
    private TableColumn<CourseData, Integer> unit1Column;
    @FXML
    private TableColumn<CourseData, String> semester2Column;
    @FXML
    private TableColumn<CourseData, Integer> unit2Column;   
    @FXML
    private TableColumn<CourseData, String> semester3Column;
    @FXML
    private TableColumn<CourseData, Integer> unit3Column;
    @FXML
    private TableColumn<CourseData, String> semester4Column;
    @FXML
    private TableColumn<CourseData, Integer> unit4Column;
    @FXML
    private TableColumn<CourseData, String> semester5Column;
    @FXML
    private TableColumn<CourseData, Integer> unit5Column;
    @FXML
    private TableColumn<CourseData, String> semester6Column;
    @FXML
    private TableColumn<CourseData, Integer> unit6Column;
    @FXML
    private TableColumn<CourseData, String> semester7Column;
    @FXML
    private TableColumn<CourseData, Integer> unit7Column;
    @FXML
    private TableColumn<CourseData, String> semester8Column;
    @FXML
    private TableColumn<CourseData, Integer> unit8Column;
    @FXML
    private TableColumn<CourseData, String> semester9Column;
    @FXML
    private TableColumn<CourseData, Integer> unit9Column;

    //set up 9 observable list to be observed
    private ObservableList<CourseData> semester1;
    private ObservableList<CourseData> semester2;
    private ObservableList<CourseData> semester3;
    private ObservableList<CourseData> semester4;
    private ObservableList<CourseData> semester5;
    private ObservableList<CourseData> semester6;
    private ObservableList<CourseData> semester7;
    private ObservableList<CourseData> semester8;
    private ObservableList<CourseData> semester9;

        
//	@FXML
//	private VBox Vbox1;
//	@FXML
//	private VBox Vbox2;
//	@FXML
//	private VBox Vbox3;
//	@FXML
//	private VBox Vbox4;
//	@FXML
//	private VBox Vbox5;
//	@FXML
//	private VBox Vbox6;
//	@FXML
//	private VBox Vbox7;
//	@FXML
//	private VBox Vbox8;
//	@FXML
//	private VBox Vbox9;
//	@FXML
//	private VBox Vbox10;
        
        
        //table views
        
        

	
    //How to initialize the choiceBox Value
    public void initialize(URL location, ResourceBundle resources) {

        
        //set text/////////////
        this.testlbl.setText("Welcome back,  " + USERID + " !");
        //initialize observableList///////////
        this.semester1 = FXCollections.observableArrayList();
        this.semester2 = FXCollections.observableArrayList();
        this.semester3 = FXCollections.observableArrayList();
        this.semester4 = FXCollections.observableArrayList();
        this.semester5 = FXCollections.observableArrayList();
        this.semester6 = FXCollections.observableArrayList();
        this.semester7 = FXCollections.observableArrayList();
        this.semester8 = FXCollections.observableArrayList();
        this.semester9 = FXCollections.observableArrayList();
        //connect the database
        this.dbConnection = new dbConnection();
        
        // load the profile from the database
        try{
            //load the profile corresponding to the current user
            loadProfile();
            //now current_profile has been loaded
            loadCourses();
            //load courses
        }
        catch(Exception ex){
            //
        
        }
	//unit.setItems(unitList)

        ////////////////////////
        //Codes for testing/////
        ////////////////////////
            //testlbl.setText(USERID);
        
            

        //////////////////////////////////////////////////////////////////////////////
        //set lables for each table with corresponding semesters//////////////////////
        //////////////////////////////////////////////////////////////////////////////
        this.semester1Column.setText(current_profile.getSemesterNameFromIndex(0));
        this.semester2Column.setText(current_profile.getSemesterNameFromIndex(1));
        this.semester3Column.setText(current_profile.getSemesterNameFromIndex(2));
        this.semester4Column.setText(current_profile.getSemesterNameFromIndex(3));
        this.semester5Column.setText(current_profile.getSemesterNameFromIndex(4));
        this.semester6Column.setText(current_profile.getSemesterNameFromIndex(5));
        this.semester7Column.setText(current_profile.getSemesterNameFromIndex(6));
        this.semester8Column.setText(current_profile.getSemesterNameFromIndex(7));
        this.semester9Column.setText(current_profile.getSemesterNameFromIndex(8));
        
        
	/////////////////////////////////////////////////////////////////////////////////////////
	//Map the VBOX depending on the semester and then add a label to that VBox///////////////
        /////////////////////////////////////////////////////////////////////////////////////////
        
//	semester_to_vbox_dictionary.put
//	(current_profile.getSemesterNameFromIndex(0), Vbox1);
//	Vbox1.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(0)));
//	    
//	semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(1), Vbox2);
//        Vbox2.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(1)));
//	    
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(2), Vbox3);
//        Vbox3.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(2)));
//	    
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(3), Vbox4);
//        Vbox4.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(3)));
//	    
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(4), Vbox5);
//        Vbox5.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(4)));
//	    
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(5), Vbox6);
//        Vbox6.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(5)));
//        
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(6), Vbox7);
//        Vbox7.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(6)));
//        
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(7), Vbox8);
//        Vbox8.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(7)));
//        
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(8), Vbox9);
//        Vbox9.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(8)));
//        
//        semester_to_vbox_dictionary.put
//        (current_profile.getSemesterNameFromIndex(9), Vbox10);
//        Vbox10.getChildren().add(new Label(current_profile.getSemesterNameFromIndex(9)));
        ////////////////////////////////////////end of mapping vbox////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

	}
        ////////////////////////////////
        ////setters and getters/////////
        public static void setUserId(String _s){
            USERID = _s;
        }
        public static String getUserId(){
            return USERID;
        }
        
    ////////////////////////////////////////////////////////////////////////////////
    ////////////data base connection/manipulation functions and codes///////////////
    ///////////////////////////////////////////////////////////////////////////////

    //LoadProfile will return a profile instance constructed from Profile constructor using the scalar values in the data base
    // for example, if current user is eddie, load the eddie's scalar value and use construtor to create a profile object
    public void loadProfile() throws SQLException{
        Statement stmt = null;
        PreparedStatement ps_loadCourse = null;
        ResultSet rs = null;
        ResultSet rs_receive_course = null;
        Connection conn = null;
        String sql = "select enroll_year,enroll_semester from students where students.userid = '" + USERID + "'";
        String sql_load_course = "select CourseName,Unit,Semester from " + USERID +"Course";
        try{
            conn = dbConnection.getConnection();

            //load from students, to get enroll semester and year
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            //load from studentCourse table to get courses and store into the current_profile m_courses
            ps_loadCourse = conn.prepareStatement(sql_load_course);
            rs_receive_course = ps_loadCourse.executeQuery();
            if(rs.next()){
                // Profile c'tor signiture Profile("FALL",2018);
                int enroll_year = Integer.valueOf(rs.getString(1));
                String enroll_semester = rs.getString(2);
                this.current_profile = new Profile(enroll_semester,enroll_year);
                //this.testlbl.setText("erolled in: "+ current_profile.enroll_semester);

            }
            while(rs_receive_course.next()){
                String course_name = rs_receive_course.getString(1);
                int unit = rs_receive_course.getInt(2);
                String semester = rs_receive_course.getString(3);
                current_profile.addCourses(semester, new Courses(course_name,unit));
            }
            System.out.println(current_profile.getCourseList("FALL2018")[0]);
            

           return;
        }
        catch(SQLException ex){
        ex.printStackTrace();
        }
        finally{
        //close connection
        stmt.close();
        ps_loadCourse.close();
        rs.close();
        rs_receive_course.close();
        conn.close();
        }
        return;
    }


    /////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// load course to the screen, when user enter the page/add a course/remove a course////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    private void loadCourses() throws SQLException{
        ResultSet rs = null;
        Connection conn =null;
        try{
            //clear the columns first before loading the table
            clearBoard();
            String sql = "select * from " + USERID + "Course"; 
            conn = dbConnection.getConnection();
            rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                // 9 cases, which corresponds to 9 differen observableList
                String course_name = rs.getString(1);
                int unit = rs.getInt(2);
                String semester = rs.getString(3);
                int semester_index = current_profile.getSemesterIndex(semester);
                //System.out.println(semester_index);
                switch(semester_index){
                    case 0:
                        this.semester1.add(new CourseData(course_name,unit,semester));
                        break;
                    case 1:
                        this.semester2.add(new CourseData(course_name,unit,semester));
                        break;
                    case 2:
                        this.semester3.add(new CourseData(course_name,unit,semester));
                        break;
                    case 3:
                        this.semester4.add(new CourseData(course_name,unit,semester));
                        break;
                    case 4:
                        this.semester5.add(new CourseData(course_name,unit,semester));
                        break;
                    case 5:
                        this.semester6.add(new CourseData(course_name,unit,semester));
                        break;
                    case 6:
                        this.semester7.add(new CourseData(course_name,unit,semester));
                        break;
                    case 7:
                        this.semester8.add(new CourseData(course_name,unit,semester));
                        break;
                    case 8:
                        this.semester9.add(new CourseData(course_name,unit,semester));
                        break;
                    default:
                        this.testlbl.setText("error occurred!");
                        break;
                }
            }
            //bind each coursename column to corresponding property
            this.semester1Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester2Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester3Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester4Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester5Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester6Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester7Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester8Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            this.semester9Column.setCellValueFactory(new PropertyValueFactory<CourseData, String>("courseName"));
            //bind each unit column to corresponding property in CourseData
            this.unit1Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit2Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit3Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit4Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit5Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit6Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit7Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit8Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));
            this.unit9Column.setCellValueFactory(new PropertyValueFactory<CourseData, Integer>("unit"));

            this.table1.setItems(null);
            this.table1.setItems(this.semester1);
            this.table2.setItems(null);
            this.table2.setItems(this.semester2);
            this.table3.setItems(null);
            this.table3.setItems(this.semester3);
            this.table4.setItems(null);
            this.table4.setItems(this.semester4);
            this.table5.setItems(null);
            this.table5.setItems(this.semester5);
            this.table6.setItems(null);
            this.table6.setItems(this.semester6);
            this.table7.setItems(null);
            this.table7.setItems(this.semester7); 
            this.table8.setItems(null);
            this.table8.setItems(this.semester8);
            this.table9.setItems(null);
            this.table9.setItems(this.semester9);
            

        }
        catch(SQLException ex){
            ex.printStackTrace();

        }
        finally{
            //close connection
            rs.close();
            conn.close();
        }
    }
    private void clearBoard(){
        this.table1.getItems().clear();
        this.table2.getItems().clear();
        this.table3.getItems().clear();
        this.table4.getItems().clear();
        this.table5.getItems().clear();
        this.table6.getItems().clear();
        this.table7.getItems().clear();
        this.table8.getItems().clear();
        this.table9.getItems().clear();
        this.txtcoursename.setText("");
        this.txtsemester.setText("");
        this.txtunit.setText("");
        this.txtcoursename2.setText("");
    }

    /////////////////////////////////////////////////////////////////////////
    ///////add/remove course implementations/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @FXML
    public void addCourse(ActionEvent event) throws SQLException {
        //check if textfields are empty
        if(!validateField1()) return;
        //check if the course to add is already added, or if once the course added,
        //the student will be overunit
        String semester = this.txtsemester.getText();
        String course = this.txtcoursename.getText();
        int unit = Integer.valueOf(this.txtunit.getText());
        int output = this.current_profile.addCourses(semester, new Courses(course,unit));
        //System.out.println(output);
        switch(output){
            case -1:
                this.testlbl.setText("*Cannot add the course! Semester is not valid!");
                loadCourses();
                return;
            case -2:
                this.testlbl.setText("*Cannot add the course! Course already taken!!");
                loadCourses();
                return;
            case -3:
                this.testlbl.setText("*Cannot add the course! You will be overunit!");
                loadCourses();
                return;
            default:
                this.testlbl.setText("*Course added!");
                loadCourses();
                break;
        }
        PreparedStatement ps = null;
        Connection conn = null;
        try{
            //create connection to the database
            //sql will be corresponding to the current user
            conn = dbConnection.getConnection();
            String sql = "INSERT INTO " + USERID + "Course(CourseName,Unit,Semester) VALUES (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, course);
            ps.setInt(2, unit);
            ps.setString(3, semester);
            ps.executeUpdate();
            loadCourses();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        finally{
            //close connection
            ps.close();
            conn.close();
        }

    }
    
    @FXML
    public void removeCourse(ActionEvent event) throws SQLException{
        if(!validateField2())return;
        String course = this.txtcoursename2.getText();
        if(this.current_profile.removeCourse(course)==-1){
            this.testlbl.setText("*this course is not in your shedule!!");
            loadCourses();
            return;
        }
        this.testlbl.setText("*course removed!!!");
        PreparedStatement ps = null;
        Connection conn = null;
        try{
            //create connection to the database
            //sql will be corresponding to the current user
            conn = dbConnection.getConnection();
            String sql = "delete from " + USERID +"Course where CourseName = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, course);
            ps.executeUpdate();
            

            loadCourses();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            ps.close();
            conn.close();
        }
   
    }

    ////////////////////////////////////////////////////////////////////////
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
//function to check if the textfileds are empty/////////////////////////////
////////////////////////////////////////////////////////////////////////////
    private boolean validateField1(){
        if(this.txtsemester.getText().isEmpty() |this.txtcoursename.getText().isEmpty()|
           this.txtunit.getText().isEmpty())
        {
            this.testlbl.setText("not enough course info to add!!");
            return false;
        }
        return true;
    }
    private boolean validateField2(){
        if(this.txtcoursename2.getText().isEmpty())
        {
            this.testlbl.setText("not enough course info to remove!!");
            return false;
        }
        return true;
    }
}
