public class AppMain {
    // Your code here...
    public static void main(String[] args){
        int n = 2;
        int count = 0;
        while(count < 20){
            if(isPrime(n) == true){
                count++;
                System.out.print(" " + n);
            }
            n++;
        }
    }


    public static boolean isPrime(int num){
        int i = 2;
        while(i < num){
            if(num % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
