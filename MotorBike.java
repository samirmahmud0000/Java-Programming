package class5;

public class MotorBike extends Vehicle {
    String brand;

    public MotorBike(){
        super();
        System.out.println("Bike created");
    }

    public void start(){
        System.out.println("Bike started");
    }

    public static void main(String[] args) {
        MotorBike b = new MotorBike();
        b.start();
    }
}
