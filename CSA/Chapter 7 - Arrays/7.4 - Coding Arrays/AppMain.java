public class AppMain {
    // You are writing a Waddle of Ducks simulation & renderer. 
    //  Your simulator should run for UPDATE_LOOPS number of loops.
    // Each loop should consist of a single update and a single render.
    // Your program should render the initial state beginning its looping.
    //  
    // Your program must have the following elements...
    //  - A Duck base class.
    //  - A derived MotherDuck class.
    //  - The Duck class must be responsible for its visualization. 
    //  - Use an array of Ducks to represent the world (null for an empty spot).
    //  - Two complete functions (updateDucks & renderDucksToString) using the provided signatures.
    //
    // Example test cases are provided. 
    //  Examples:
    //   Duck[] ducks = { null, null, null, null, null, new MotherDuck(), new Duck(), new Duck(), new Duck(), null, null };
    //          Dddd  
    //         Dddd   
    //        Dddd
    //       Dddd
    //      Dddd
    //     Dddd
    //     ddd       D
    //     dd       Dd
    //     d       Ddd
    //            Dddd
    //           Dddd
    // 
    //   Duck[] ducks = { new MotherDuck(), new Duck(), new Duck(), new Duck(), new Duck(), new Duck(), new Duck(), null, null, null, null, null };
    //     Ddddddd     
    //     dddddd     D
    //     ddddd     Dd
    //     dddd     Ddd
    //     ddd     Dddd
    //     dd     Ddddd
    //     d     Dddddd
    //          Ddddddd
    //         Ddddddd
    //        Ddddddd
    //       Ddddddd

    private static final int UPDATE_LOOPS = 10;

    public static void main(String[] args) {
        // Test cases (remove comments to swap test cases)...
        Duck[] ducks = { null, null, null, null, null, new MotherDuck(), new Duck(), new Duck(), new Duck(), null, null };
        //Duck[] ducks = { new MotherDuck(), new Duck(), new Duck(), new Duck(), new Duck(), new Duck(), new Duck(), null, null, null, null, null };
        //Duck[] ducks = { new Duck(), new Duck(), null, null, null, null, null, null, null, null, new MotherDuck(), new Duck() };
        for(int i = 0; i < UPDATE_LOOPS; i++){
            System.out.println(renderDucksToString(ducks));
            updateDucks(ducks);
        }
    }

    // Shifts all ducks to the left by one.
    //  It wraps around to right side when leaving left side.
    public static void updateDucks(Duck[] ducks) {
        Duck temp = ducks[0];
        for (int i = 0; i < ducks.length - 1; i++) {
            ducks[i] = ducks[i + 1];
        }
        ducks[ducks.length - 1] = temp;
    }

    // Draw the ducks from left to right (BTW - Render is just another way of saying draw).
    //  Note that the Duck (and its derived classes) are responsible for providing
    // their visualization, not this function. 
    //
    //  *** Requirement: This function must use a for each loop ***
    //
    public static String renderDucksToString(Duck[] ducks) {
        String temp = "";
        for(int i = 0; i < ducks.length; i++){
            if(ducks[i] != null){
                temp += ducks[i].toString();
            }
            else{
                temp += " ";
            }
        }
        return temp;   
    }
}
