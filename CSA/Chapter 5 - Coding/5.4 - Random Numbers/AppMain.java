public class AppMain {
    // The program should...
    //  Uses at least two functions.
    //  Picks a random die: 𝑑4, 𝑑6, 𝑑8, 𝑑10, 𝑑12, and 𝑑20.
    //  Then find the average of rolling that die rolled 𝟏𝟎𝟎 times.
    // 
    // Example output…
    //  Die: d8
    //  Average = 4.32

    private static final int ROLLCOUNT = 100;

    public static void main(String[] args){
        int dice = chooseDice();
        System.out.println("Die: " + dice);
        System.out.print("Average = " + diceAverage(dice));
    }
    public static int chooseDice(){
        int dice = 0;
        int rand = 1 + (int)(Math.random() * 6);
    
        if(rand == 1){
            dice+=4;
            return dice;
        }
        else if(rand == 2){
            dice+=6;
            return dice;
        }
        else if(rand == 3){
            dice += 8;
            return dice;
        }
        else if(rand == 4){
            dice += 10;
            return dice;
        }
        else if(rand == 5){
            dice += 12;
            return dice;
        }
        else{
            dice += 20;
            return dice;
        }
    }
    public static double diceAverage(int n){
        int i = 0;
        double finalNum = 0;
        while(i < ROLLCOUNT){
            int rand = 1 + (int)(Math.random() * n);
            finalNum += rand;
            i++;
        }
        return finalNum/(double)ROLLCOUNT;
    }
    // Your code goes here...
}
