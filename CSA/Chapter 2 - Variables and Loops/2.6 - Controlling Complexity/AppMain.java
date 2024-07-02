public class AppMain {
    public static final int Size = 6;
    // Desired output (two different examples, depending on what the constant is set to)...
    // SIZE = 3
    //   #============#
    //   |    <><>    |
    //   |  <>....<>  |
    //   |<>........<>|
    //   |<>........<>|
    //   |  <>....<>  |
    //   |    <><>    |
    //   #============#
    // SIZE = 4
    //   #================#
    //   |      <><>      |
    //   |    <>....<>    |
    //   |  <>........<>  |
    //   |<>............<>|
    //   |<>............<>|
    //   |  <>........<>  |
    //   |    <>....<>    |
    //   |      <><>      |
    //   #================#
    
    public static void main(String[] args) {
        drawTopBottom();
        drawMiddleTop();
        drawMiddle();
        drawTopBottom();
    }
    
    public static void drawTopBottom() {
        // Multiply by 4 each time use for loop to do
        System.out.print("#");
        for(int i=0; i < 4 * Size; i++){
            System.out.print("=");
        }
        System.out.println("#");
    }

    public static void drawMiddleTop(){
        for (int i = 1; i <= Size; i++) {
            System.out.print("|");
        for(int z = 0; z < (4*Size-4*(i-1)-4) / 2; z++){
                System.out.print(" ");
            }
            System.out.print("<>");
            for (int c = 0; c<4*(i-1); c++){
                System.out.print(".");
            }
            System.out.print("<>");
            for(int z = 0; z < (4*Size-4*(i-1)-4) / 2; z++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    public static void drawMiddle() {
        for (int i = 0; i < Size; i++) {
            System.out.print("|");
            for(int z = 0; z < (4*Size-(4*Size-4*(i+1))-4) / 2; z++){
                System.out.print(" ");
            }
            System.out.print("<>");
            for (int c = 0; c<4*Size-4*(i+1); c++){
                System.out.print(".");
            }
            System.out.print("<>");
            for(int z = 0; z < (4*Size-(4*Size-4*(i+1))-4) / 2; z++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
