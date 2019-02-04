package Structure;
import java.util.ArrayList;

/*
specs:
Major
     Member data fields:
-	ArrayList<Courses> req_courses;
-	String major_lable;		//check if it is art major, stem major, or else
-
     Member functions:
-	void addReqCourse(Courses _c);
-	void addReqCourse(ArrayList<Courses> _cList);
-	
*/
public class Major {
    
    
//data fields
    public ArrayList<Courses> req_courses;
    
    
//member functions
    
    
    //overloading member function to add courses for administrotor
    void addReqCourses(Courses _c){};
    void addReqCourses(ArrayList<Courses> _cList){};
}
