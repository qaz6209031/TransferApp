/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 13354
 */
package Structure;

public class Courses {

    
//data field
    public String name;
    public int unit;
    
    
    
    //pre_req will be a Courses object
    public Courses pre_req;
    
    
    // to check pre_req: two cases: 1- if no pre_req, which pre_req == nullptr; 2- there is pre_req
//member functions
    public Courses(String _n,int _u){
        name=_n;
        unit = _u;
    }
    public Courses(String _n, int _u, Courses _c){
        this(_n,_u);
        pre_req = _c;       //shallow copy is sufficient
    }
    public String getCourseName(){return name;}
    public int getUnit(){return unit;}
    public String getPreReq(){return pre_req.getCourseName();}
    public String toString(){
        return "Course Name:" + name +" " + "unit: " + unit;
    }
    
}
