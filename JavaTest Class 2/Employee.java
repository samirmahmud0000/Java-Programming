package class6;

public class Employee {
    private String ID;
    private String name;
    private  int age;
    private char gender;
    private float salary;

    public Employee(){
        System.out.println("Default constructor");
    }

    public Employee(String ID, String name, int age, char gender, float salary) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

//    public String toString(){
//        String output = "------------------------"
//                +"\nID: "+ this.ID+
//                "\nname: "+ this.name+
//                "\nage: "+ this.age+
//                "\ngender: "+ this.gender+
//                "\nsalary: "+ this.salary+
//                "\n------------------------";
//        return output;
//    }

    @Override
    public String toString() {
        return "-----------------" +
                "\nID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", salary=" + salary +
                "\n-----------------";
    }
}
