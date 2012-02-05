package net.mgorski.scjp.tests.collections2;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    
    

    



 
    
    public void  doSth() {
        
        List<?> x = new ArrayList<Employee>(); 

        List<Employee> x1 = new ArrayList(); 
//        List<Employee> x2 = new ArrayList<DeptManager>(); 
//
//        List<? extends Employee> x3 = new ArrayList<DeptManager>; 
//
//        List<? extends ProjManager> x4 = new ArrayList<DeptManager>(); 

        List<? super ProjManager> x5 = new ArrayList<Employee>();

        
    }

}


class DeptManager extends Employee { };
class ProjManager extends Employee { };
