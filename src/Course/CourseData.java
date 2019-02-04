/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

/**
 *
 * @author josej
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class CourseData {
   private SimpleStringProperty courseTitle;
   private SimpleStringProperty courseID; 
   private SimpleIntegerProperty courseUnit;
   private SimpleStringProperty courseType;
   
    public CourseData(String courseTitle, String courseID, int courseUnit, String courseType){
        this.courseTitle = new SimpleStringProperty(courseTitle);
        this.courseID = new SimpleStringProperty(courseID);
        this.courseUnit = new SimpleIntegerProperty(courseUnit);
        this.courseType = new SimpleStringProperty(courseType);
    }
    
     public CourseData(String courseTitle, String courseID, int courseUnit){
        this.courseTitle = new SimpleStringProperty(courseTitle);
        this.courseID = new SimpleStringProperty(courseID);
        this.courseUnit = new SimpleIntegerProperty(courseUnit);
     
    }
    
    public String getCourseTitle() {
        return courseTitle.get();
    }

    public String getCourseID() {
        return courseID.get();
    }

    public int getCourseUnit() {
        return courseUnit.get();
    }
    
    public String getCourseType(){
        return courseType.get();
    }
    
    public void setCourseTitle(String courseTitle){
        this.courseTitle.set(courseTitle);
    }
   
    public void setCourseID(String courseID){
        this.courseID.set(courseID);
    }
    
    public void setCourseUnit(int courseUnit){
        this.courseUnit.set(courseUnit);
    }
    
    public void setCourseType(String courseType){
        this.courseType.set(courseType);
    }
}
