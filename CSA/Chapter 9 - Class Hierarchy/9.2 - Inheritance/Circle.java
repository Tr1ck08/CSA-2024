public class Circle extends Shape{
    private String color;
    private int radius;

    public Circle(String color, int radius) {
        super("Circle", color);
        this.color = color;
        this.radius = radius;
    }

    public double calcArea(){
        return 3.14*radius*radius;
    }
    public double calcPerimeter() {
        return 2*radius*3.14;
    }
}
