package lab3;

public class EmployeeManager {
    public static void main(String[] args){
        Employee James = new Employee("James Wright", 42, "Manager", 20000);
        Employee Amy = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
        Employee Peter = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000,7);
        Employee John = new Employee("John Doe", 22, "Engineer", 10000, 10);

        System.out.println(James.toString());
        System.out.println(Amy.toString());
        System.out.println(Peter.toString());
        System.out.println(John.toString());

        Employee tmpemployee = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);// 같은 직원일 때
        if(tmpemployee.equals(Amy)){System.out.println("같은 직원입니다");} 
        else{System.out.println("다른 직원입니다");} 
        tmpemployee = new Employee("Seoyeon Lee", 23); // 다른 직원일 때
        if(tmpemployee.equals(Amy)){System.out.println("같은 직원입니다");} 
        else{System.out.println("다른 직원입니다");} 

        James.vacation(10);
        Peter.vacation(10);

        System.out.println(James.toString());
        System.out.println(Amy.toString());
        System.out.println(Peter.toString());
        System.out.println(John.toString());
        System.out.println(tmpemployee.toString());
    }
}
