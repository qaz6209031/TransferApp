package Structure;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*


 */


public class Profile {
    
//data field
    public String [] m_majors;
    
    
    //data field for m_courses, add/remove courses
    public Courses [][] m_courses;	//rows to be semester, col’ns to be courses e.g. courses[0][1] 
                                        //would be first classs in the first semester that student enrolled 
                                        //create a map <string semester, int m_courses index
    public static final int MAX_SEMESTER=9;
    public static final int MAX_COURSE_NUM = 8;
    public static final int MAX_UNIT_COUNT = 18;
    public String enroll_semester;      //in form of "FALL2018", caps
    public int enroll_year;
    public int[] course_count;        //count number of courses in m_courses, index indicates semester
    public Map<String,Integer> semester_dictionary;
    public  Map<Integer,String> semester_dictionary_intToSemester;
    public int[] unit_count;

    
    public int smcId,acctId;		//student account Id used to register, acctId used for administrator;
    public String userid;
    public String password;		//4 digits password
    public double gpa;
    //use map to map the grades <COURSE string,Grade char>
    public char[] grades;
    
        
//member functions
    public Profile(String _enrollSemester,int _enrollyear){
        this(_enrollSemester,_enrollyear, 0000, "0000");
        generateSemesterToIntMap();
    }
    public Profile(String _enrollSemester,int _enrollyear, int smc_id, String _password){
        this.smcId = smc_id;
        this.password = _password;
        this.enroll_semester = _enrollSemester;
        this.enroll_year = _enrollyear;
        this.semester_dictionary = new HashMap<>();
        this.semester_dictionary_intToSemester = new LinkedHashMap<>(16,0.75f,true);
        this.m_courses = new Courses[MAX_SEMESTER][MAX_COURSE_NUM];
        this.course_count = new int[MAX_SEMESTER];
        this.unit_count = new int[MAX_SEMESTER];
        generateSemesterToIntMap();
    }
    public Profile(String _userid,String _enrollSemester,int _enrollyear, int smc_id, String _password){
        this(_enrollSemester,_enrollyear, smc_id, _password);
        this.userid = _userid;
    }
        public String getSemesterNameFromIndex(int i){
        try{
            return semester_dictionary_intToSemester.get(i);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return "error on function getSemesterNameFromIndex";
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////pack of functions to for generating map/////////////////
    ///////////////////////////////////////////////////////////////////////////
        // generateSemesterToIntMap();  used to generate the map from semester keyword to 
        //  index of m_courses
    public void generateSemesterToIntMap(){
        String current_semester = enroll_semester;
        int current_year = enroll_year;
        for(int i = 0; i < MAX_SEMESTER;i++){
            String semester_keyword = current_semester + String.valueOf(current_year);
            this.semester_dictionary.put(semester_keyword,i);
            this.semester_dictionary_intToSemester.put(i,semester_keyword);
            //updates for next loop
            current_year = utils.updateYear(current_semester, current_year);
            current_semester = utils.updateSemester(current_semester);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////functions used for obtain items from maps////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //getSemesterIndex(); used to obtain the index of semester corresponding to the semester
        // e.g. if student first semester is WINTER2018, pass in "WINTER2018" as parameter
        // getSemesterIndex(); will return integer 1
    public int getSemesterIndex(String key){

        //need to check if the keyword is in the dictionary
        try{
        return semester_dictionary.get(key);
        }
        catch(Exception ex){
            return -1;
        }
    }
    
    public String[] getSemesterStringArr(){
        String[] semesterArr = new String[MAX_SEMESTER];
        for(int i = 0; i<MAX_SEMESTER; i++){
            semesterArr[i] = semester_dictionary_intToSemester.get(i);
        }
        return semesterArr;
    }
    
        //

    ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////functions for add/remove courses into m_courses//////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    
        //function addCourses(String _semester, Courses _course);
        //performs to add courses to m_courses array, return -1 if unsuccessful
        // return the course count if successful
    public int addCourses(String _semester, Courses _course){
        
        
        int semester_index = getSemesterIndex(_semester);
        // if -1, meaning parameyter _semester is invalid input
        if (semester_index==-1) return -1;
        // if course is already taken, return -1;
        if (isCourseTaken(_course.getCourseName())) return -2;
        // if student will be overunit, return -3
        int possible_total_units = _course.getUnit() + unit_count[semester_index];
        if(possible_total_units > MAX_UNIT_COUNT) return -3;
        
        
        
        int course_num_of_semester = getCourseCount(_semester); 
        m_courses[semester_index][course_num_of_semester] = _course;
        updateCourseCount(_semester);
        updateUnitCount(_semester,_course);
        return getCourseCount(_semester);
    }
    public int removeCourse(String _course){
        for(int i = 0; i < MAX_SEMESTER;i++){
            for(int j = 0; j< MAX_COURSE_NUM;j++){
                if(m_courses[i][j]==null) continue;
                if(_course.equals(m_courses[i][j].getCourseName())){ 
                    m_courses[i][j]=null;
                    return 0;
                }
            }
        }
        return -1;
    }

        //return number of courses in the corresponding semester
    public int getCourseCount(String _semester){
        // if the input is invalid, return -1
        if (getSemesterIndex(_semester) ==-1) return-1;
        
        int semester_index = getSemesterIndex(_semester);
        return course_count[semester_index];
    }
    public int updateCourseCount(String _semester){
        // if the input is invalid, return -1
        if (getSemesterIndex(_semester) ==-1) return-1;
        
        int semester_index = getSemesterIndex(_semester);
        course_count[semester_index] +=1;
        return course_count[semester_index];
    }
        //return current enrolled units of the corresponding semester
        //return -1 if the input is invalid, otherwise return current unit amount
    public int getUnit(String _semester){
        // if the input is invalid, return -1
        if (getSemesterIndex(_semester) ==-1) return-1; 
        return unit_count[getSemesterIndex(_semester)];
    }
        
        // given a course, update the unit count of that semester, return -1 if invalid inputs
    public int updateUnitCount(String _semester,Courses _course){
        // if the input is invalid, return -1
        if (getSemesterIndex(_semester) ==-1) return-1;
        int semester_index = getSemesterIndex(_semester);
        unit_count[semester_index] += _course.getUnit();
        return unit_count[semester_index];
    }
    
        //searchCourse(String _semester,String _course); used to search for the target course
        // from the given semester, return -1 if the semester is invalid or the course is not found
        //otherwise return the index of the course from that semester
    public int searchCourse(String _semester,String _course){
        // if the input is invalid, return -1
        if (getSemesterIndex(_semester) ==-1) return-1;
        int semester_index = getSemesterIndex(_semester);
        int total_courses_added =  getCourseCount(_semester);
        for(int i = 0; i< total_courses_added;i++){
            if(_course.equals(m_courses[semester_index][i].getCourseName())){
                return i;
            }
        }
        return -1;
    }
    public int searchCourse(String _course){
        for(int i = 0; i < MAX_SEMESTER;i++){
            for(int j = 0; j< MAX_COURSE_NUM;j++){
                if(m_courses[i][j]==null) continue;
                if(_course.equals(m_courses[i][j].getCourseName())) return 0;
            }
        }
        return -1;
    }
        //return true of student took the course already, false otherwise
    public boolean isCourseTaken(String _tgtCourse){
        for(int semester =0;semester<MAX_SEMESTER;semester++){
            for(int course_index = 0;course_index <course_count[semester];course_index++){
                if(_tgtCourse.equals(m_courses[semester][course_index].getCourseName())){
                    return true;
                }
            }
        }
        return false;
    }
    
    //public boolean isPreReqTaken(Courses _c){}
    
    //return a string array, containing course names of that semester
    public String[] getCourseList(String _semester) {
        // if the input is invalid, return empty array
        if (getSemesterIndex(_semester) ==-1) return(new String[]{"invalid _semester input"});
        
        String[] stringCourseList = new String[getCourseCount(_semester)];
        int semester_index = getSemesterIndex(_semester);        
        for(int course_index = 0;course_index<getCourseCount(_semester);course_index++){
            stringCourseList[course_index] = m_courses[semester_index][course_index].getCourseName();
        }
        return stringCourseList;
    }
    
    
    
}
