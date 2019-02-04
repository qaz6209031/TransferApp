/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentPlan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 13354
 */
public class CourseData {
    
    private StringProperty courseName;
    private IntegerProperty unit;
    private String semester;
    
    public CourseData(String _coursename, int _unit, String _semester){
        this.courseName = new SimpleStringProperty(_coursename);
        this.unit = new SimpleIntegerProperty(_unit);
        this.semester = _semester;
    }
    ////////////////////////
    //setter and getters////
    ////////////////////////
    
    public StringProperty courseNameProperty(){
        return this.courseName;
    }
    public void setCourseName(String _s){
        this.courseName.set(_s);
    }
    
    public IntegerProperty unitProperty(){
        return this.unit;
    }
    public void setUnit(int _u){
        this.unit.set(_u);
    }
    public String getSemester(){return this.semester;}
    public void setSemester(String _s){this.semester = _s;}
    
    
}
