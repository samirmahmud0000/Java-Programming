class Count extends Thread {
    int s, e;

    public Count(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public void run() {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += i;
        }
        System.out.println("Sum from " + s + " to " + e + ": " + sum);
    }
}

public class MyClass {
    public static void main(String[] args) {
        Count C1 = new Count("C1", 1, 5);
        Count C2 = new Count("C2", 6, 10);
        Count C3 = new Count("C3", 11, 15);

        C1.start();
        C2.start();
        C3.start();
    }
}
