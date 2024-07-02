public class Rectangle extends Shape{
    private String color;
    private int length;
    private int width;

    public Rectangle(String color, int length, int width) {
        super("Rectangle", color);
        this.color = color;
        this.length = length;
        this.width = width;
    }

    public double calcArea(){
        return (length*width);
    }
    public double calcPerimeter() {
        return 2*(length+width);
    }
}
