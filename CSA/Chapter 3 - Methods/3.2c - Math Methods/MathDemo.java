// Demos the creation of simple math methods (pow, sumToN, ...)
public class MathDemo {
    public static void main(String[] args) {
        System.out.println("pow(2, 3) == " + power(2,3));
        System.out.println("factorial(10) == " + factorial(10));
        System.out.println("sumToN(5) == " + sumToN(5));
        System.out.println(sumSquares(5));
        System.out.println(strRepeat("hi",5));
        System.out.println(padLeft("hi",4));
        printTableOfSquares(10);
        System.out.println();
        // Add code the exercises (run & test) all the code you wrote in this class. 
        // Pick good examples (non-trivial but also something you can hand-verify).  
        // Be sure to identify the output For example: System.out.println("pow(2, 3) == " + pow(2, 3));
        // TODO: FINISH CALLING ALL METHODS. 

        System.out.println("---- MathDemo: Done ----"); 
    }
    
    // ------------------------------------------------------
    // computes 'num' to the 'exponent'  Thus pow(2,3) == 8
    // ‘exponent’ is required to be non-negative integer.  
    // num and exponent are both integers. returns an integer.  
    // TODO: implement a power method
    public static int power(int x, int y){
        return (int) Math.pow(x,y);
    }
    
    // ------------------------------------------------------
    // computes n! that is n * (n-1) * (n-2) ... 3 * 2 * 1
    // factorial(0) == 1.  
    // takes an integer n and returns an integer; 
    // TODO implement a factorial method
    public static int factorial(int x){
        int answer = 1;
        for(int i = 0; i < x; i++){
            answer *= x-i;
        }
        return answer;
    }

    // ------------------------------------------------------
    // computes the sum of all integers from 1 to maxNum inclusive.  
    // Thus sumToN(0) == 0  sumToN(3) == 6
    // takes an integer maxNum and returns an integer; 
    // TODO implement a sumToN method
    public static int sumToN(int maxNum){
        int answer = 0;
        for(int i = 0; i < maxNum; i++){
            answer += maxNum-i;
        }
        return answer;
    }
    
    // ------------------------------------------------------
    // computes the sum of the squares to n.   
    // that is N*N + (N-1)*(N-1) ... 3*3 + 2*2 + 1*1
    // takes an integer maxNum and returns an integer     
    // TODO implement a sumSquares method
    public static int sumSquares(int maxNum){
        int answer = 0;
        for(int i = 0; i < maxNum; i++){
            answer += power(maxNum-i, 2);            
        }
        return answer;  
    }
    
    // ------------------------------------------------------
    // returns a string that is 'str' repeated 'count' times 
    // takes a str and count argument and returns a string. 
    // TODO implement a repeat method
    public static String strRepeat(String str, int x){
        String TempString = "";
        for(int i = 0; i < x; i++){
            TempString += str;
        }
        return TempString;
    }  
    
    // ------------------------------------------------------
    // returns a string that is 'str' padded with spaces 
    // so that it has a total of 'width' characters
    // Callers should insure that the length of str <= width
    // Takes a str and width argument and returns a string.
    // TODO implement a padLeft method  
    public static String padLeft(String str, int width){
        int length = 0;
        String TempString = "";
        length = width-str.length();
        for(int i = 0; i < length; i++){
            TempString += " ";
        }
        TempString += str;
        return TempString;
    }
    // ------------------------------------------------------
    // print a table of square that starts at 1 and goes up to and includes maxN
    // +-----+-------+
    // |  N  |  N*N  |
    // +-----+-------+
    // |   1 |     1 |
    // |   2 |     4 |
    //      ... omitted ...
    // |  10 |   100 |
    //      ... omitted ...
    // | 100 | 10000 | 
    // +-----+-------+
    // You can assert that maxN*maxN < 100000 and maxN < 1000
    // Thus N will be at most a 3 digit number and maxN will be
    // at most a 5 digit number.   
    public static void printTableOfSquares(int maxN) {
        System.out.println("+-----+-------+");
        System.out.println("|  N  |  N*N  |");
        System.out.println("+-----+-------+");
        for(int i = 0; i < maxN; i++){
            System.out.print("|");
            System.out.print(padLeft(Integer.toString(i+1), 4));
            System.out.print(" |");
            System.out.print(padLeft(Integer.toString(power(i+1,2)), 6));
            System.out.print(" |");
            System.out.println();
        }
        System.out.print("+-----+-------+");
        // TODO: Implement.
        // NOTE YOU MUST PAD INTEGERS so that the table looks pretty.  
        // Thus you immediately can use your padLeft method.  
        assert(false);   
        
        // HINT: To convert an integer to a strings use the method
        // Integer.toString(anInteger) (TODO remove this comment before submitting)
    }    
}  
