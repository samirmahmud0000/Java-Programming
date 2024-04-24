package class3;

public class BankAccount {
    //instance variables
    String name;
    String id;
    double balance;

    //functions/methods
    public double deposit(double amount){
        //updating balance
        balance += amount;

        return balance;
    }

    public double withdraw(double amount){
        //checking for invalid amount
        if(amount < 0) {
            System.out.println("Amount cannot be negative");
            return balance;//return statement to exit method if invalid input is given
        }
        //checking for balance sufficiency
        if(amount <= balance){
           // updating balance
            balance = balance - amount;
        }
        return balance;
    }
}
