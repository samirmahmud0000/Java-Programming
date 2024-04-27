package class6;

public class Main {
    static  Employee[] employees = new Employee[10];
    public static String alreadyExists(String ID){
        for (int i = 0; i < employees.length; i++){
            if(employees[i]!= null && ID.equals(employees[i].getID()))
                return employees[i].toString();
        }
        return "Not found";
    }

    public static void searchByGender(char gender){
        for (int i = 0; i < employees.length; i++){

            if(employees[i]!= null && gender == employees[i].getGender())
                System.out.println(employees[i].toString());
        }
    }
    public static void main(String[] args) {
        employees[0] = new Employee("111", "Rashid", 25,'M',50000);
        employees[1] = new Employee("123", "Kamal", 21,'M',45000);
        employees[2] = new Employee("134", "Moon", 32,'F',65000);
        employees[3] = new Employee("145", "Dilip", 27,'M',55000);

//        System.out.println(alreadyExists("134"));

        searchByGender('F');


    }
}
