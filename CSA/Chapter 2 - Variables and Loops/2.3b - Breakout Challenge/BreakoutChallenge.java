
public class BreakoutChallenge {
    /* Challenge Goal
     *  In this challenge, you are implementing part of a break-out style game.
     * If you are not familiar with this type of game, check out this wiki page (and a youtube video)...
     *  https://en.wikipedia.org/wiki/Breakout_(video_game)
     *  https://www.youtube.com/watch?v=hW7Sg5pXAok 
     * 
     * The game is partially/mostly implemented for you. You are not writing the game's simulation code.
     *  What you are writing is the graphics (i.e. the display). Everything else is already completed. 
     *  The display should be implemented with ASCII style graphics, print/println...the things you are familiar with. 
     *  You get to pick the display details (like what character is used for the walls, ball, etc). 
     *  Just make it look good, make it your own.
     * 
     * The game has side/top walls, a ball, a paddle at the bottom (controlled with the mouse), and bricks.
     * 
     **********************************************************************************************
     *** THIS IS THE ONLY FILE YOU SHOULD MODIFY FOR THE MAIN/DISPLAY PORTION OF THIS CHALLENGE ***
     **********************************************************************************************
     *  
     * But...if manage to complete this, an additional challenge is to modify the game in some way.
     *  One possibility is to add support for a 'multi-ball' powerup. For this additional challenge, 
     * you can (and should) modify the other files. Be creative, make it fun.
     * 
     */
    private static Simulation sim = new Simulation();

    public static void draw(){
        while(true){
        System.out.print("|");
        for(int a = 0; a <= sim.GRID_WIDTH; a++){
            System.out.print("-");
        }
        System.out.println("|");
        for(int b = 0; b <= sim.GRID_HEIGHT; b++){
            System.out.print("|");
            for(int i = 0; i <= sim.GRID_WIDTH; i++){
                if(sim.isBrickInGridSquare(i,b)){
                    System.out.print("#");
                }
                else{
                    System.out.print(" ");
                }
            }   
            System.out.println("|");
        }
        System.out.print("|");
        for(int a = 0; a <= sim.GRID_WIDTH; a++){
            System.out.print("-");
        }
        System.out.print("|");
        sim.endFrame();
    }
    
    }
    public static void main(String[] args) {
        draw();
    }
}
