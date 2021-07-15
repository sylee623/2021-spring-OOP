package lab3;

public class Employee {
    private String name;
    private int age;
    private String position;
    private int salary;
    private int vacationDays;

    public Employee(String name, int age){
        this.position = "Employee";
        this.salary = 5000;
        this.vacationDays = 20;
        this.name = name;
        this.age = age;
    }
    public Employee(String name, int age, String position, int salary){
        this.position = position;
        this.salary = salary;
        this.vacationDays = 20;
        this.name = name;
        this.age = age;
    }
    public Employee(String name, int age, String position, int salary, int vacationDays){
        this.position = position;
        this.salary = salary;
        this.vacationDays = vacationDays;
        this.name = name;
        this.age = age;
    }
    //setter
    public void setPosition(String position){this.position = position;}
    public void setSalary(int salary){this.salary = salary;}
    public void setVacationDays(int vacationDays){this.vacationDays = vacationDays;}
    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    //getter
    public String getPosition(){return position;}
    public int getSalary(){return salary;}
    public int getVacationDays(){return vacationDays;}
    public String getName(){return name;}
    public int getAge(){return age;}
    //equals
    public boolean equals(Employee anotherEmployee){
        if(this.name == anotherEmployee.name && this.age == anotherEmployee.age){return true;}
        else{return false;}
    }
    //tostring
    public String toString(){
        return "Name: " + name + ", Age: "+age+", Position: "+position+ ", Salary: "+salary+", VacationDays: "+vacationDays;
    }
    public void vacation(int wantVacation){
        if(wantVacation > this.vacationDays){
            System.out.println("남은 휴가일수가 부족합니다.");
        }
        else{
            System.out.println("휴가를 사용하였습니다. 남은 휴가일수 : " + (vacationDays - wantVacation));
        }
    }
}