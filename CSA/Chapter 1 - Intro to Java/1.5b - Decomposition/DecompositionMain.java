public class DecompositionMain {
    public static void main(String[] args) {
        printTriangle();
        printBox();
        printUSA();
        printBox();
        printTriangle();
    }


    public static void printTriangle(){
        System.out.println("   /\\" );
        System.out.println("  /  \\" );
        System.out.println(" /    \\" );
    }

    public static void printBox(){
        System.out.println("+------+" );
        System.out.println("|      |" );
        System.out.println("|      |" );
        System.out.println("+------+" );
    }

    public static void printUSA() {
        System.out.println("|UNITED|" );
        System.out.println("|STATES|" );
    }

}