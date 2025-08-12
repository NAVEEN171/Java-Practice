
class Employee{
     int employeeId;
     boolean activeStatus;
     int hike;
     String employeeName;
     Employee(int employeeId,boolean activeStatus,int hike,String employeeName){
        this.employeeId=employeeId;
        this.activeStatus=activeStatus;
        this.hike=hike;
        this.employeeName=employeeName;
     }
}

public class EmployeeList{
    public static void main(String args[]){
        // to create a custom array of type object Employee
        Employee[] employees=new Employee[4];
        employees[0]=new Employee(1,true,25,"Dileep");
        employees[1]=new Employee(2,true,15,"Mahesh");
        employees[2]=new Employee(3,true,10,"Divya");
        employees[3]=new Employee(4,true,0,"Naveen");
        for(Employee emp:employees){
            System.out.println("employeeName:"+emp.employeeName+" activeStatus:"+emp.activeStatus+" Hike this year:"+emp.hike+"%"+" his id:"+
            emp.employeeId);
        }
    }
}


