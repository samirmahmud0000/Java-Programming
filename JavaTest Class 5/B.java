package class5;

public class B extends A {
    int b = 10;
    int x = 3;

    public void bar(){
        System.out.println("This is the bar method");
        System.out.println(super.x);
        display();
    }
    public void display(){
        super.display();
        System.out.println("The value of var b is :"+b);
    }
}
