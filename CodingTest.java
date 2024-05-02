package class7;

public class CodingTest {
    public static void main(String[] args) {
        showArea(new Circle(5));
        showArea(new Rectangle(3,2.5));
    }

    static void showArea(Shape s){
        System.out.println("The Area of the shape is " + s. getArea());
    }
}
class Shape{
    public double getArea(){
        return -1;
    }
}
class Rectangle extends Shape{

}class Circle extends Shape{

}
