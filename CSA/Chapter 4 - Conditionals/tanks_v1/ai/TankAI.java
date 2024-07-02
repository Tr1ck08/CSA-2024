package ai;

import game.PowerUp;
import game.Tank;
import game.TankAIBase;
import game.Vec2;

public class TankAI extends TankAIBase {

    public String getPlayerName() {
        return "Alex";  // <---- Put your first name here
    }
    public int getPlayerPeriod() {
        return 1;
    }
        
    // You are free to add member variables & methods to this class (and delete this comment).
    //  You should use the methods in its base class (TankAIBase) to query the world. 
    //  Note that you are not allowed to reach into game code directly or make any
    //  modifications to code in the game package. Use your judgement and ask your 
    //  teacher if you are not sure. If it feels like cheating, it probably is.

    public PowerUp findShortestPowerUp(Vec2 pos, PowerUp powerUp1, PowerUp powerUp2, PowerUp powerUp3) {
        double dist1 = Math.sqrt(Math.pow((powerUp1.getPos().x - pos.x),2) + Math.pow((powerUp1.getPos().y - pos.y),2));
        double dist2 = Math.sqrt(Math.pow((powerUp2.getPos().x - pos.x),2) + Math.pow((powerUp2.getPos().y - pos.y),2));
        double dist3 = Math.sqrt(Math.pow((powerUp3.getPos().x - pos.x),2) + Math.pow((powerUp3.getPos().y - pos.y),2));
        double smallestDistance = Math.min(dist1, Math.min(dist2, dist3));

        if (dist1 == smallestDistance) {
            return powerUp1;
        }
        else if (dist2 == smallestDistance) {
            return powerUp2;
        }
        else {
            return powerUp3;
        }

    }

    public boolean updateAI() {
        // TODO: Your code goes here
        PowerUp[] powers = this.getPowerUps();
         PowerUp shortestPowerUp = findShortestPowerUp(tank.getPos(), powers[0], powers[1], powers[2]);
        queueCmd("move", new Vec2(shortestPowerUp.getPos().x - tank.getPos().x, 0));
        queueCmd("move", new Vec2(0, shortestPowerUp.getPos().y - tank.getPos().y));
        return true;
    }
}