public class DecompositionMain {
    public static void main(String[] args) {
        printTop();
        printBottom();
        printTop();
        printBottom();
    }
}
    public static void printTop(){
        System.out.println("  /\\" );
        System.out.println(" /  \\" );
        System.out.println("/    \\" );
    }

    public static void printBottom(){
        System.out.println("\\    /" );
        System.out.println(" \\  /" );
        System.out.println("  \\/" );
    }

