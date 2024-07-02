package ai;
import game.Target;
import game.PowerUp;
import game.Tank;
import game.TankAIBase;
import game.Vec2;
import game.Game;

public class TankAI extends TankAIBase {
    int r = 0;
    //AVG Score 750
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

    public PowerUp findShortestPowerUp(Vec2 pos, PowerUp powerUp1, PowerUp powerUp2, PowerUp powerUp3) { //Shortest powerup...   
        double dist1 = Math.sqrt(Math.pow((powerUp1.getPos().x - pos.x),2) + Math.pow((powerUp1.getPos().y - pos.y),2));
        double dist2 = Math.sqrt(Math.pow((powerUp2.getPos().x - pos.x),2) + Math.pow((powerUp2.getPos().y - pos.y),2));
        double dist3 = Math.sqrt(Math.pow((powerUp3.getPos().x - pos.x),2) + Math.pow((powerUp3.getPos().y - pos.y),2));
        double smallestDistance = Math.min(dist1, Math.min(dist2, dist3));
        //only target r, most points...
        if(powerUp1.getType() == "R" && powerUp2.getType() == "R" && powerUp3.getType() == "R"){
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
            if(powerUp1.getType() == "R" && powerUp2.getType() == "R"){
                smallestDistance = Math.min(dist1, dist2);
                if(smallestDistance == dist1){
                    return powerUp1;
                }
                return powerUp2;
            }
            if(powerUp3.getType() == "R" && powerUp2.getType() == "R"){
                smallestDistance = Math.min(dist3, dist2);
                if(smallestDistance == dist3){
                    return powerUp3;
                }
                return powerUp2;
            }
            if(powerUp2.getType() == "R" && powerUp3.getType() == "R"){
                smallestDistance = Math.min(dist2, dist3);
                if(smallestDistance == dist2){
                    return powerUp2;
                }
                return powerUp3;
            }
            if(powerUp1.getType() == "R"){
                return powerUp1;
            }
            if(powerUp2.getType() == "R"){
                return powerUp2;
            }
            if(powerUp3.getType() == "R"){
                return powerUp3;
            }     
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

    public Target findShortestTarget(Vec2 pos, Target target1, Target target2, Target target3) { //Target distance...
        double dist1 = Math.sqrt(Math.pow((target1.getPos().x - pos.x),2) + Math.pow((target1.getPos().y - pos.y),2));
        double dist2 = Math.sqrt(Math.pow((target2.getPos().x - pos.x),2) + Math.pow((target2.getPos().y - pos.y),2));
        double dist3 = Math.sqrt(Math.pow((target3.getPos().x - pos.x),2) + Math.pow((target3.getPos().y - pos.y),2));
        double smallestDistance = Math.min(dist1, Math.min(dist2, dist3));

        if(smallestDistance > tank.getShotRange()){
            return null;
        }

        if (dist1 == smallestDistance) {
            return target1;
        }

        else if (dist2 == smallestDistance) {
            return target2;
        }

        else {
            return target3;
        }
    }

    public boolean isWithinRange(Vec2 pos, Target target){
        if(Math.sqrt(Math.pow((target.getPos().x - pos.x),2) + Math.pow((target.getPos().y - pos.y),2)) < getTankShotRange()){
            return true;
        }
        return false;
    }

    public boolean updateAI() {
        if(r == 0){
            queueCmd("move", new Vec2(0.5,0.5));
            r++;
        }
        PowerUp[] powers = this.getPowerUps();
        Target[] targets = this.getTargets();
        Target shortestTarget = findShortestTarget(tank.getPos(), targets[0], targets[1], targets[2]);
        PowerUp shortestPowerUp = findShortestPowerUp(tank.getPos(), powers[0], powers[1], powers[2]);
        if(getTankShotRange() > 12){
            targets = getTargets();
            queueCmd("move", new Vec2(12 - tank.getPos().x, 0));
            queueCmd("move", new Vec2(0, 6 - tank.getPos().y));
            for (int i = 0; i < 3; i++) { //For single player comment out for loop if 1v1...
                Target target = targets[i];
                if (isWithinRange(tank.getPos(), target)) {
                    queueCmd("shoot", new Vec2(target.getPos().x - 12, target.getPos().y - 6));
                }
            }
            //If 1v1... (Safer but slower)
            //queueCmd("shoot", new Vec2(shortestTarget.getPos().x - tank.getPos().x, shortestTarget.getPos().y - tank.getPos().y));

        }
        else{
            if(shortestTarget != null){
                queueCmd("shoot", new Vec2(shortestTarget.getPos().x - tank.getPos().x, shortestTarget.getPos().y - tank.getPos().y));
            } 
            queueCmd("move", new Vec2(shortestPowerUp.getPos().x - tank.getPos().x, 0));
            queueCmd("move", new Vec2(0, shortestPowerUp.getPos().y - tank.getPos().y+0.5));   //Adds 0.5 to move on line...
        }
        return true;
    }



}