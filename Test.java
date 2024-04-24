package class5;

public class Test {
    public static void main(String[] args) {
        A object1 = new A();
        B object2 = new B();

        System.out.println(object1.a);
        object1.foo();

        System.out.println(object2.b);
        object2.bar();
        object2.foo();
        System.out.println(object2.a);
    }
}
