package class6;

public class OverLoadingTest {
    public int myFunc(int a) {
        System.out.println(a);
        return a;
    }

    public double myFunc(double a) {
        return a + 1.5;
    }

    public double myFunc(int a, double x) {
        return a+x;
    }

    public static void main(String[] args) {
        OverLoadingTest test = new OverLoadingTest();
        test.myFunc(2,5.6);
    }
}
