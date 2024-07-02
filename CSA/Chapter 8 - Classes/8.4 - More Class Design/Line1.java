public class Line1 {
    private double x1, x2, y1, y2;
    private double m, b;

    public Line1(double x1, double x2, double y1, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        m = (y2-y1)/(x2-x1);
        b = -(m * x1) + y1;
    }

    public Line1(double m, double b){
        this.m = m;
        this.b = b;
    }

    
    public double returnSlope(){
        return m;
    }

    public double returnIntercept(){
        return b;
    }
    
    public double evaluateY(double x){
        return (m*x+b);
    }

    public double evaluateX(double y){
        return (y-b)/m;
    }

    public String toString(){
        String returnString = "";
        returnString += "y = " + m + "x + " + b; 
        return returnString;
    }

    public double findIntersection(Line1 other){
        double num = this.b-other.b;
        double denom = other.m - this.m;
        return (num/denom);
    }

    public void printIntersection(Line1 other){
        double x= findIntersection(other);
        double y = evaluateY(x);
        System.out.println("(" + x + ", " + y + ")");
    }

}
