package class7;

public class SubClassPolyMoprhismTest {

    public static void greet(A obj){
        obj.greeting();
    }
    public static void main(String[] args) {

        greet(new A());
        greet(new B());
        greet(new C());
        greet(new D());
        greet(new F());

    }
}

class A{
    //Grandparent
    public void greeting(){
        System.out.println("Yo");
    }
}

class B extends A{
    //parent
    public void greeting(){
        System.out.println("Hi");
    }
}

class C extends B{
    //Uncle
    public void greeting(){
        System.out.println("Hello");
    }
}

class D extends A{
    //child
    public void greeting(){
        System.out.println("Whats up");
    }
}

class F extends D{

}
