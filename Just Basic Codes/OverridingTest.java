package class7;

public class OverridingTest {
    public static void main(String[] args) {
        SpicyFood sc =new SpicyFood("Red",1.5,3);
        sc.cook();
    }
}

class Food{
    String color;
    double weight;

    public Food(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public void cook(){
        System.out.println("Cooking Food with color"+color+" and weight "+weight);
    }
}

class SpicyFood extends Food{
    int spiceLevel;

    public SpicyFood(String color, double weight, int spiceLevel) {
        super(color, weight);
        this.spiceLevel = spiceLevel;
    }

    //method overriding
    @Override
    public void cook() {
        System.out.println("SpiceLevel: " + spiceLevel);
        System.out.println("Cooking Food with color "+color);
    }

}
