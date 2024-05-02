package class7;

public class Overriding2 {
    public static void main(String[] args) {
        Child c = new Child();

//        System.out.println(c.childVar);
//        System.out.println(c.parentVar);
        c.childMethod();
//        c.parentMethod();
    }
}

class Parent{
    int parentVar = 5;
    public void parentMethod(){
        System.out.println(" Inside Parent class");
    }
}

class Child extends Parent{
    int childVar = 10;
    int parentVar = 7;
    public void childMethod(){
        super.parentMethod();
        System.out.println(" Inside child class "+super.parentVar);
    }

    @Override
    public void parentMethod(){
        System.out.println("Overriden inside child class");
    }
}
