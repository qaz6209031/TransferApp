package Structure;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 13354
 */
public class utils {
    public static final String[] semesterCycle ={"FALL","WINTER","SPRING","SUMMER"};
    public static String updateSemester(String _s){
        for(int i = 0 ; i<semesterCycle.length; i++){
            if(_s.equals(semesterCycle[i])){
                if(i==semesterCycle.length-1){
                    _s = semesterCycle[0];
                    return _s;   
                }
            _s = semesterCycle[i+1];
            return _s;
            }
        }
        return "Unreconized semester";
    }
    
    public static int updateYear(String _semester,int _y){
        if(_semester.equals("FALL")) return _y +=1;
        return _y;
    }
}
