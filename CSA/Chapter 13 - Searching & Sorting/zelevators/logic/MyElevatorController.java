package logic;
 
import game.ElevatorController;
import game.Game;
 
public class MyElevatorController implements ElevatorController {
    // Private member data
    private Game game;
    //to check elevator directions to know if its the most optimal run or not 
    private Direction[] elevatorDirections;
 
    // Students should implement this function to return their name
    public String getStudentName() {
        return "Alex";   
    }
    public int getStudentPeriod() {
        return 1;           
    }
 
    // Event: Game has started
    public void onGameStarted(Game game) {
        this.game = game;
        
    }
 
    // Event: "outside-the-elevator" request, requesting an elevator.
    // The event will be triggered when the request is created/enabled & when it is cleared (reqEnable indicates which).
    public void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        System.out.println("onElevatorRequestChanged(" + floorIdx + ", " + dir + ", " + reqEnable + ")");
        if(!reqEnable) { 
            return; 
        }
        //find closest elevator if there is a pending request from a zombie on that floor
        if(reqEnable) {
            double closestDist = Double.MAX_VALUE;
            int closestElevator = -1;
            for(int i = 0; i < game.getElevatorCount(); i++) {
                if (game.isElevatorIdle(i)) {
                    double floor = game.getElevatorFloor(i);
                    double dist = Math.abs(floor - floorIdx);
                    if (dist < closestDist) {
                        closestElevator = i;
                        closestDist = dist;
                        
                    }
                }
            }
            //send closest elevator to that floor
            if(closestDist != Double.MAX_VALUE) {
                gotoFloor(closestElevator, floorIdx);
            }
            else {
                //else you look for direction and send elevator to the floor that is going in the same direction to save the most amount of time
                for(int i = 0; i < game.getElevatorCount(); i++) {
                    double floor = game.getElevatorFloor(i);
                    Direction currentDir = game.getElevatorTravelDirection(i);
                    if((currentDir == dir) && ((dir == Direction.Up && floor <= floorIdx) || (dir == Direction.Down && floor >= floorIdx))) {
                        gotoFloor(i, floorIdx);
                        break;
                    }
                }
            }
        }
    }
 
    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered when the request is created/enabled & when it is cleared (reqEnable indicates which).
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        System.out.println("onFloorRequestChanged(" + elevatorIdx + ", " + floorIdx + ", " + reqEnable + ")");
        if(!reqEnable) { return; }
        if(reqEnable) {
            if(game.isElevatorIsOnFloor(elevatorIdx, floorIdx) || game.isElevatorIdle(elevatorIdx)) {
                gotoFloor(elevatorIdx, floorIdx);
            }
            else {
                Direction currDir = game.getElevatorTravelDirection(elevatorIdx);
                double floor = game.getElevatorFloor(elevatorIdx);
                if((currDir == Direction.Up && floor <= floorIdx) || (currDir == Direction.Down && floor >= floorIdx)) {
                    gotoFloor(elevatorIdx, floorIdx);
                }
            }
        }
    }
 
    // Event: Elevator has arrived at the floor & doors are open.
    public void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, Direction travelDirection) {
        System.out.println("onElevatorArrivedAtFloor(" + elevatorIdx + ", " + floorIdx + ", " + travelDirection + ")");
        elevatorDirections = new Direction[game.getElevatorCount()];
        //if only one elevator dont assign directions to any
        if(game.getElevatorCount() == 1) {
            elevatorDirections[0] = null;
        }
        else {
            boolean goingUp = true;
            //if elevator is going up set it to up, else set it to down
            for(int i = 0; i < game.getElevatorCount(); i++) {
                if(goingUp) {
                    elevatorDirections[i] = Direction.Up;
                }
                else {
                    elevatorDirections[i] = Direction.Down;
                }
                goingUp = !goingUp;
            }
        }
        //sending elevator to respective floors
         for(int i = 0; i < game.getFloorCount(); i++) {
             if(game.elevatorHasFloorRequest(elevatorIdx, i)) {
                 gotoFloor(elevatorIdx, i);
                 return;
             }
         }
 
    }
 
    // Event: Called each frame of the simulation (i.e. called continuously)
    public void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }//run each frame, if an elevator is idle with no zombies inside it will send it to a floor that has a request
        for(int i = 0; i < game.getElevatorCount(); i++) {
            if(game.isElevatorIdle(i)) {
                for(int j = 0; j < game.getFloorCount(); j++) {
                    if(game.hasElevatorRequestUp(j) || game.hasElevatorRequestDown(j)) {
                        gotoFloor(i, j);
                        return;
                    }
                }
            }
        }
    }
}
 
