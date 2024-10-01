import java.util.Scanner;
public class SeriesPrac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            int n, sum=0;
            System.out.println("Enter the n: ");
            n=input.nextInt();

            for(int i=1; i<=n; i++){
                System.out.print(i+" ");
                sum=sum+i;
                //sum=sum+i*i; (Squire)
            }
        System.out.println();
        System.out.println("Summation is : "+sum);

        }
    }



