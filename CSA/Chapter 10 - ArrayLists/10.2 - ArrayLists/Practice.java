import java.lang.reflect.Array;
import java.util.ArrayList;
public class Practice {
    /* Write a method called toArrayList that takes an array of Strings and
     *  return an ArrayList populated with the same list of Strings.
     * Example...
     *  input: { "a", "b", "c" }, output: [ a, b, c ]
     */ 
    // TODO: write the method toArrayList
    public ArrayList<String> toArrayList(String[] n){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < n.length; i++){
            list.add(i,n[i]);
        }
        return list;
    }
    /* Write a method called reverseList that takes an array of Strings and
     *  return a new ArrayList with the same strings, but with their locations
     *  in the list reversed in order.
     * Example...
     *  input: { "a", "b", "c" }, output: [ c, b, a ]
     */ 
    public ArrayList<String> reverseList(String[] n){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < n.length; i++){
            list.add(i,n[n.length-i-1]);
        }
        return list;
    }

    /* Write a method called splitString that takes a String and returns an
     *  ArrayList with each word in the String as an element of the ArrayList.
     *  Words in the input are delimited by spaces and punctuation including
     *  periods, commas, exclemation, and question marks.
     * Note that I'm asking you to write your own (don't use a system method for this)
     * Examples...
     *  input: "This is a test", output: [ this, is, a, test ]
     *  input: "Hi. What, is your name?", output: [ Hi, What, is, your, name ]
     */ 
    public ArrayList<String> splitString(String n) {
        ArrayList<String> list = new ArrayList<String>();
       
        String currentString = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '.' || n.charAt(i) == ' ' || n.charAt(i) == '!' || n.charAt(i) == '?' || n.charAt(i) == ',') {
                if (!currentString.equals("")) {
                    list.add(currentString);
                }
                currentString = "";
            }
            else {
                currentString += n.charAt(i);
            }
        }
 
        if (!currentString.equals("")) {
            list.add(currentString);
        }
 
        return list;
    }
    /* Write a method called justPrimes that takes an Array of integer types
     *  and returns an ArrayList of the subset of those numbers that are prime.
     * Examples...
     *  input: { 1, 3, 4, 7, 8, 11 }, output: [ 1, 3, 7, 11 ]
     */ 
    public boolean isPrime(int n){
        int test = 2;
        while(test < Math.sqrt(n)){
            if(n % test == 0){
                return false;
            }
            test++;
        }
        return true;
    }
    public ArrayList<Integer> justPrimes(int[] m){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < m.length; i++){
            if(isPrime(m[i])){
                list.add(m[i]);
            }
        }
        return list;
    }

}