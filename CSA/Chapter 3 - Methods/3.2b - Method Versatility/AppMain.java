public class AppMain {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            System.out.println(returnValue(100));
        }
        for(int b = 0; b < 5; b++){
            System.out.println(returnValue(100,500));
        }
    }
    
    // Put your functions here...
    public static int returnValue(int maxValue){
        double value = Math.random();
        return (int)(value*100);
    }
    public static int returnValue(int minValue, int maxValue){
        double value = Math.random();
        return (int)(value * (maxValue-minValue) + minValue);
    }
}
