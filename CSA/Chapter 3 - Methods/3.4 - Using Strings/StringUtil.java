import javax.swing.InputMap;

public class StringUtil {
    public static String firstHalf(String input) {
        // Returns a string containing the first half of 'input'
        // In the case of an odd number of characters, the extra goes in the second half (excluded here)
        //  Example: "0123456789" -> "01234"
        // 
        // Requirements...
        //  - Use a loop to build the return string.
        String halfString = "";
       for(int i = 0; i < input.length()/2; i++){
        halfString += input.charAt(i);
       }



        return halfString;
    }

    public static String beforeSpace(String input) {
        // Returns a string containing the portion of the string BEFORE the space
        // In the case of no space, the full string should be returned
        //  Example: "abcd ef" -> "abcd"
        // 
        // Requirements...
        //  - Use the string function substring.
        String behindSpace = "";
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                break;
            }
            else{
                behindSpace += input.charAt(i);
            }
        }
        return behindSpace;
    }

    public static String afterSpace(String input) {
        // Returns a string containing the portion of the string AFTER the space
        // In the case of no space, an empty string should be returned
        //  Example: "abcd ef" -> "ef"
        // 
        // Requirements...
        //  - Use the string function substring.
        String afterSpace = "";
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                return input.substring(i,input.length());
            }
        }
        return afterSpace;
    }

    public static String swapAtSpace(String input) {
        // Returns a string that swaps the section before and after the space
        //  Example: "abcd ef" -> "ef abcd"
        // 
        // Requirements...
        //  - The other functions you created for this.
        String swapSpace = "";
        swapSpace += afterSpace(input);
        swapSpace += " ";
        swapSpace += beforeSpace(input);
        return swapSpace;
    }

    public static char firstNonRepeatedChar(String input) {
        // Returns the first character that is not repeated later in the string (looking left to right)
        //  Example: "abcabcdef" -> 'd'
        int a = 0;
        int j = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(a) == input.charAt(i) && input.charAt(a) != input.charAt(j)){
                    a++;
                    j = i;
                    i = 0;
                    
                }
            }        
        return input.charAt(a);
    }
}
