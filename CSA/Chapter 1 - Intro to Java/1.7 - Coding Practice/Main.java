public class Main {
    public static void main(String[] args) {
        // You can add new functions to this class, but
        //  do not modify this function (main).
        System.out.println("--- Exercise 5 ---");
        exercise5();
        System.out.println("\n--- Exercise 6 ---");
        exercise6();
        System.out.println("\n--- Exercise 7 ---");
        exercise7();
        System.out.println("\n--- Exercise 8 ---");
        exercise8();
        System.out.println("\n--- Exercise 9 ---");
        exercise9();
        System.out.println("\n--- Exercise 10 ---");
        exercise10();
    }
    
    public static void exercise5() {
        System.out.println("A \"quoted\" String is");
        System.out.println("'much' better if you learn");
        System.out.println("the rules of \"escape sequences.\"");
        System.out.println("Also, \"\" represents an empty String.");
        System.out.println("Don't forget: use \\\" instead of \"!");
        System.out.println("'' is not the same as \"");
    }

    public static void exercise6() {
        System.out.println("System.out.println(\"Hello, world!\");");
    }

    public static void exercise7() {
        printCmd();
        printCmd();
    }

    public static void printCmd(){
        System.out.println("There's one thing every coder must understand:");
        System.out.println("The System.out.println command.");
    }

    public static void exercise8() {
        System.out.println("//////////////////////");
        printMsg();
        printMsg();
        printMsg();
        printMsg();
        printMsg();
    }
    
    public static void printMsg(){
        System.out.println("|| Victory is mine! ||");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    }

    public static void exercise9() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
        System.out.println("-\"-'-\"-'-\"-");
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }

    public static void exercise10() {
        printHexa();
        printMiddle();
        printHexa();
    }
    public static void printHexa(){
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
        System.out.println("\\         /");
        System.out.println(" \\_______/\n");
    }
    public static void printMiddle(){
        System.out.println("-\"-'-\"-'-\"-");
    }
}
