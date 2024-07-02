// Lesson 7.2 - Using Arrays

public class AppMain {
    public static void main(String[] args) {
        // Do not modify the code in this method (edit the methods below main)
        System.out.println("--------- arrayToString ---------");
        System.out.println(arrayToString(new int[] { 1, 2, 3, 4 }));
        System.out.println(arrayToString(new int[] { -1, 5, 0 }));

        System.out.println("--------- createIntArray ---------");
        System.out.println(arrayToString(createIntArray(5, 2)));
        System.out.println(arrayToString(createIntArray(10, 7)));

        System.out.println("--------- countAdjacentMatches ---------");
        System.out.println(countAdjacentMatches(new int[] { 1, 2, 2, 3, 2, 4, 4 }));
        System.out.println(countAdjacentMatches(new int[] { 5, 5, 5, 2, 3, 3, 5, 7 }));
        System.out.println(countAdjacentMatches(new int[] { 5, 5, 5 }));
    }

    // Convert an array of integers into a string.
    //  *** Your implementation MUST USE THE FOR-EACH SYNTAX FOR ITS LOOPS. ***
    // Example: { 1, 2, 3, 4 } -> 1, 2, 3, 4
    // Example: { -1, 5, 0 } -> -1, 5, 0
    public static String arrayToString(int[] array) {
        // ...
        String strtemp = "";
        for(int i = 0; i < array.length-1; i++){
            strtemp += array[i];
            strtemp += ", ";
        }
        strtemp += array[array.length-1];
        return strtemp;
    }

    // Create an int array of size elementCount. 
    //  Every element should be initialized with the value of defaultValue.
    // Example: createIntArray(5, 2) -> { 2, 2, 2, 2, 2 }
    public static int[] createIntArray(int elementCount, int defaultValue) {
        // ...
        int[] elements = new int[elementCount];
        for(int i = 0; i < elements.length; i++){
            elements[i] = defaultValue;
        }
        return elements;
    }

    // Count the number of matching adjacent pairs there are in list.
    // Example: { 1, 2, 2, 3, 2, 4, 4 } -> 2
    // Example: { 5, 5, 5, 2, 3, 3, 5, 7 } -> 3
    // Example: { 5, 5, 5 } -> 2
    public static int countAdjacentMatches(int[] list) {
        // ...
        int count = 0;
        for(int i = 0; i < list.length; i++){
            if(i != list.length-1){
                if(list[i] == list[i+1]){
                    count++;
                }
        }
    }
    return count;
    }
}
