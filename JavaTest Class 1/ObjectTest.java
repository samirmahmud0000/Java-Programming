package class3;

public class ObjectTest {
    public static void main(String[] args) {
        //object creation
        BankAccount rAccount = new BankAccount();

        //updating fields
        rAccount.name = "Rashid";
        rAccount.id = "100200500";
        rAccount.balance = 1000;

        //Accessing fields
        System.out.println(rAccount.name);
        System.out.println(rAccount.id);
        System.out.println(rAccount.balance);

        //creating another object
        BankAccount kAccount = new BankAccount();
        //updating fields
        kAccount.name = "kashem";
        kAccount.id = "200100500";
        kAccount.balance = 550.5;

        //Accessing fields
        System.out.println(kAccount.name);
        System.out.println(kAccount.id);
        System.out.println(kAccount.balance);

        //Accessing fields
        System.out.println(rAccount.name);
        System.out.println(rAccount.id);
        System.out.println(rAccount.balance);

//        //
//        rAccount = kAccount;
//        System.out.println("After assignment");
//        //Accessing fields
//        System.out.println(kAccount.name);
//        System.out.println(kAccount.id);
//        System.out.println(kAccount.balance);
//
//        //Accessing fields
//        System.out.println(rAccount.name);
//        System.out.println(rAccount.id);
//        System.out.println(rAccount.balance);

        //using deposit/withdraw
        rAccount.deposit(1200.75);
        kAccount.withdraw(150.5);

        System.out.println(rAccount.balance);
        System.out.println(kAccount.balance);



    }
}
