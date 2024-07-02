public class AppMain {
    // Background: Arithmetic sequences...
    //  Example A: 3, 4, 5, 6, 7, 8, ...
    // These are numbers with a constant difference between then (one in the example above).
    //  Example B: 12, 10, 8, 6, 4, ...
    // Each of the numbers in the sequence are called terms. A sequence can be defined by...
    //  a1 : the first term in the sequence (3 & 12 in the examples above).
    //  d : the difference between each term (1 and -2 in the examples above).

    // Background: Arithmetic series...
    // When you add up the first 'n' terms of a sequence, that's a series.
    //  Using example A: The series sum of the first 5 terms is 25. That's 3 + 4 + 5 + 6 + 7 
    //  Using example B: The series sum of the first 3 terms is 30. That's 12 + 10 + 8

    // The program should...
    //  Design multiple classes. Use the guiding principles taught in lesson 8.3 for this. 
    // Your main function should use the classes to test out the examples above, plus a few
    //  more test cases of your own choosing. 
    // 
    // Example output…
    //  Sequence: 3, 4, 5, 6, 7, 8, ...
    //  Series Sum (5 terms): 25

    // Your code goes here...
    public static void main(String[] args){
        Sequence sequence = new Sequence(1, 2, 5);
        Series series = new Series(5, sequence);
        System.out.println(sequence.returnSequence());
        System.out.println("Series Sum (" + sequence.returnN() + " terms): " + series.returnSeries());

        Sequence sequence2 = new Sequence(4, 3,5);
        Series series2 = new Series(5, sequence2);
        System.out.println(sequence2.returnSequence());
        System.out.println("Series Sum (" + sequence2.returnN() + " terms): " + series2.returnSeries());

        Sequence sequence3 = new Sequence(12, 5,5);
        Series series3 = new Series(5, sequence3);
        System.out.println(sequence3.returnSequence());
        System.out.println("Series Sum (" + sequence3.returnN() + " terms): " + series3.returnSeries());
    }
}
