
import java.util.*;

interface employee{
    void sal_disp();
    
}

abstract class teaching implements employee{
    public String name;
    static int id_ctr=0;
    public int id;
    public int att;
    public float basepay;
    public float hra;
    public float da;
    public float additionals;
    public float lop_calc;
    Scanner inp_str = new Scanner(System.in);
    Scanner inp_int = new Scanner(System.in);
    Scanner inp_float = new Scanner(System.in);
    teaching(){
        System.out.println("Enter Details of Teaching Employee: ");
        System.out.println("Name: ");
        name =  inp_str.nextLine();
//        System.out.println("Att: ");
//        att =  inp_int.nextInt();
        System.out.println("Base Pay: ");
        basepay =  inp_float.nextFloat();
        System.out.println("HRA: ");
        hra =  inp_float.nextFloat();
        System.out.println("DA: ");
        da =  inp_float.nextFloat();
        id_ctr++;
        id = id_ctr;
    }
    
    
    float lop_calc(){
        return ((25-att)*basepay/25);
    }
    abstract public float add_calc();
    
    public void sal_disp(){
        System.out.println("Salary Disp:");
        System.out.println("Name: "+ name);
        System.out.println("Id: "+ id);
        System.out.println("Enter No of days Present: ");   
        att = inp_int.nextInt();
        System.out.println("Calculated Salary: "+add_calc());
        
    }    
    
    public float temp_add_calc(){
        return (hra + (basepay)*(da/100));        
    }
}

class teaching_fellow extends teaching{
    float Rsrch_incentive;
    teaching_fellow(){
        System.out.println("Enter Research Incentives Obtained: ");
        Rsrch_incentive = inp_float.nextFloat();
    }
    public float add_calc(){
        float lop = lop_calc();
        return (basepay + Rsrch_incentive + temp_add_calc() - lop);
    }
}

class AP extends teaching{
    float med;
    AP(){
        System.out.println("Enter Medical Allowance : ");
        med = inp_float.nextFloat();
    }
    public float add_calc(){
        return (basepay + med + temp_add_calc());
    }
}

class P extends teaching{
    float guide_ship;
    P(){
        System.out.println("Enter Guideship Allowance : ");
        guide_ship = inp_float.nextFloat();
    }
    public float add_calc(){
        return (basepay + guide_ship + temp_add_calc());
    }
}

class nonteaching implements employee{
    public String name;
    static int id_ctr=0;
    public int id;
    public int att;
    public float pay;
    Scanner inp_str = new Scanner(System.in);
    Scanner inp_int = new Scanner(System.in);
    Scanner inp_float = new Scanner(System.in);
    nonteaching(){
        System.out.println("Enter Details of NonTeaching Employee: ");
        System.out.println("Name: ");
        name =  inp_str.nextLine();
        System.out.println("Pay: ");
        pay =  inp_float.nextFloat();
        id_ctr++;
        id = id_ctr;
    }
    
    float lop_calc(){
        return ((25-att)*pay/25);
    }
    
    public float add_calc(){
        return (pay-lop_calc());
    }
    
    public void sal_disp(){
        System.out.println("Salary Disp:");
        System.out.println("Name: "+ name);
        System.out.println("Id: "+ id);        
        System.out.println("Enter No of days Present: ");   
        att = inp_int.nextInt();
        try{
            if(add_calc()<2000){
                throw new min_sal_exception("Very less Salary");
            }
            else{
                System.out.println("Calculated Salary: "+add_calc());
            }
            
        }
        catch(min_sal_exception e){
            System.out.println("Very Less Salary");
        }
        
    }    
    
}


class min_sal_exception extends Exception{
    min_sal_exception(String msg){
        super(msg);
    } 
}

public class PayRoll_Calc {

    public static void main(String[] args) {
       System.out.println("PayRoll Calc: ");
       
       System.out.println("Non Teaching: ");
       nonteaching e1 = new nonteaching();
       
       
       System.out.println("Teaching Fellow: ");
       teaching_fellow e2 = new teaching_fellow();
       e2.sal_disp();
       
       System.out.println("Assistant Prof: ");
       AP e3 = new AP();
       e3.sal_disp();
       
       System.out.println("Professor: ");
       P e4 = new P();
       e4.sal_disp();
       
       
    }
    
}
