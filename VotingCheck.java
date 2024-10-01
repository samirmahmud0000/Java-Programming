import java.util.Scanner;
public class VotingCheck {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int age;
        System.out.println("Enter your age: ");
        age=input.nextInt();

        if(age<18){
            System.out.println("You are not Eligable");
        }else{
            System.out.println("Welcome to your Voting.\nThank you.");
        }

    }
}
