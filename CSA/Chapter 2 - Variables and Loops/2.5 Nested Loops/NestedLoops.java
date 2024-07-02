public class NestedLoops{

    public static void main(String[] args){
        loopOne();
        loopTwo();
        loopThree();
        loopFour();
        loopFive();
        loopSix();
        loopSeven();
    }

    public static void loopOne(){
        for(int i=0; i<6; i++){
            for(int c=0; c<i+1; c++){
                System.out.print(i+1);
            }
            System.out.println();
        }
    }

    public static void loopTwo(){
        for(int i=0; i<5; i++){
            for(int c=0; c<5-i; c++){
                System.out.print(" ");
            }
            System.out.println(i+1);
        }
    }
    
    public static void loopThree(){
        for(int i=0; i<3; i++){
            for(int c=0; c<10; c++){
                System.out.print(c + "" + c + "" + c);
            }
            System.out.println();
        }
    }

    public static void loopFour(){
        for(int i=0; i<5; i++){
            for(int c=0; c<5-i; c++){
                System.out.print("-");
            }
            for(int k=0; k<2*i+1; k++){
                System.out.print(2*i+1);
            }
            for(int j=0; j<5-i; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void loopFive(){

        for(int i=9; i>0; i--){
            for(int c=0; c<9; c++){
                if(i-c<1){
                    System.out.print(9+(i-c) + " ");
                } else{
                    System.out.print(i-c + " ");
                }
            }
                System.out.println();
        }
    }

    public static void loopSix(){
        int prev2 = 1; 
        int prev1 = 1;
        int num = 1;
        for(int i = 0; i < 15; i++){
            if(i != 0 && i != 1){
                num = prev2 + prev1;
                prev2 = prev1;
                prev1 = num;
            }
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void loopSeven(){
        for(int i=0; i < 4; i++){
            for(int c=0; c<10; c++){
                if(c+1 == 10){
                    System.out.print("|");
                }
                else{
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
        for(int i=0; i < 4; i++){
            for(int c=0; c<10; c++){
                if(c+1 == 10){
                    System.out.print(0);
                }
                else{
                    System.out.print(c+1);
                }
            }
        }
    }
}