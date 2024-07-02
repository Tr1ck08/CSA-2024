package logic;
 
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
 
import game.ElevatorController;
import game.Game;
 
public class OtherElevatorController implements ElevatorController {
    private Game game;
    private int elevatorCount;
    private int topFloor;
    private List<List<int[]>> requests; // List of requests for each floor
    private List<Integer> elevatorDestinations; // List of current destinations for each elevator
    private boolean[] elevatorDirection; // Direction of each elevator
    private List<Queue<int[]>> elevatorRequests; // Priority queue for each elevator
 
    // Returns the student's name
    public String getStudentName() {
        return "Adarsh";
    }
 
    // Returns the student's period
    public int getStudentPeriod() {
        return 1;
    }
 
    // Called when the game starts, initializes necessary variables
    public void onGameStarted(Game game) {
        this.game = game;
        this.elevatorCount = game.getElevatorCount();
        this.topFloor = game.getFloorCount() - 1;
        this.requests = new ArrayList<>(game.getFloorCount());
        this.elevatorDestinations = new ArrayList<>(elevatorCount);
        this.elevatorDirection = new boolean[elevatorCount];
        this.elevatorRequests = new ArrayList<>(elevatorCount);
 
        for (int i = 0; i < game.getFloorCount(); i++) {
            requests.add(new ArrayList<>()); // Initialize the list for each floor
        }
 
        for (int i = 0; i < elevatorCount; i++) {
            elevatorDestinations.add(-1); // -1 indicates no destination
            elevatorDirection[i] = true; // true indicates Up direction, false indicates Down direction
            elevatorRequests.add(new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]))); // Priority queue sorted by endFloor
        }
    }
 
    // Called when an elevator request changes
    public void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        System.out.println("onElevatorRequestChanged(" + floorIdx + ", " + dir + ", " + reqEnable + ")");
        if (reqEnable) {
            addFloorRequest(floorIdx, dir);
        }
    }
 
    // Called when a floor request changes
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        System.out.println("onFloorRequestChanged(" + elevatorIdx + ", " + floorIdx + ", " + reqEnable + ")");
        if (reqEnable) {
            requests.get(floorIdx).add(new int[]{floorIdx, floorIdx}); // Adding as self-request
        }
    }
 
    // Called when an elevator arrives at a floor
    public void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, Direction travelDirection) {
        System.out.println("onElevatorArrivedAtFloor(" + elevatorIdx + ", " + floorIdx + ", " + travelDirection + ")");
        List<int[]> currentFloorRequests = requests.get(floorIdx);
        Queue<int[]> elevatorQueue = elevatorRequests.get(elevatorIdx);
 
        // Drop off any requests that match the current floor
        currentFloorRequests.removeIf(request -> request[1] == floorIdx);
        elevatorQueue.removeIf(request -> request[1] == floorIdx);
 
        if (floorIdx == 0) {
            elevatorDirection[elevatorIdx] = true; // Switch direction to Up if reached bottom
        } else if (floorIdx == topFloor) {
            elevatorDirection[elevatorIdx] = false; // Switch direction to Down if reached top
        }
 
        if (!elevatorQueue.isEmpty()) {
            int[] nextRequest = elevatorQueue.poll();
            elevatorDestinations.set(elevatorIdx, nextRequest[1]);
            gotoFloor(elevatorIdx, nextRequest[1]);
        } else {
            elevatorDestinations.set(elevatorIdx, -1); // Clear destination if no more requests
        }
    }
 
    // Called periodically to update the state of the game
    public void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }
 
        for (int i = 0; i < elevatorCount; i++) {
            if (game.isElevatorIdle(i)) {
                handleIdleElevator(i);
            }
        }
    }
 
    // Handles movement of idle elevators
    private void handleIdleElevator(int elevatorIdx) {
        int currentFloor = (int) game.getElevatorFloor(elevatorIdx);
        Direction direction = elevatorDirection[elevatorIdx] ? Direction.Up : Direction.Down;
        Queue<int[]> elevatorQueue = elevatorRequests.get(elevatorIdx);
 
        if (!elevatorQueue.isEmpty()) {
            int[] nextRequest = elevatorQueue.peek();
            elevatorDestinations.set(elevatorIdx, nextRequest[1]);
            gotoFloor(elevatorIdx, nextRequest[1]);
        } else {
            // If no requests are pending, switch directions and find new requests
            if (direction == Direction.Up) {
                for (int i = currentFloor + 1; i <= topFloor; i++) {
                    if (!requests.get(i).isEmpty() && !isRequestAssignedToOtherElevator(i)) {
                        elevatorDestinations.set(elevatorIdx, i);
                        game.setElevatorTravelDirection(elevatorIdx, Direction.Up);
                        if(game.elevatorHasFloorRequest(elevatorIdx, i) || game.hasElevatorRequestUp(i)){
                            gotoFloor(elevatorIdx, i);
                        }
                        return;
                    }
                }
                elevatorDirection[elevatorIdx] = false;
                game.setElevatorTravelDirection(elevatorIdx, Direction.Down);
            } else {
                for (int i = currentFloor - 1; i >= 0; i--) {
                    if (!requests.get(i).isEmpty() && !isRequestAssignedToOtherElevator(i)) {
                        elevatorDestinations.set(elevatorIdx, i);
                        game.setElevatorTravelDirection(elevatorIdx, Direction.Down);
                        if(game.elevatorHasFloorRequest(elevatorIdx, i) || game.hasElevatorRequestDown(i)){
                            gotoFloor(elevatorIdx, i);
                        }
                        return;
                    }
                }
                elevatorDirection[elevatorIdx] = true;
                game.setElevatorTravelDirection(elevatorIdx, Direction.Up);
            }
        }
    }
 
    // Adds a floor request and assigns it to the nearest idle elevator
    private void addFloorRequest(int floorIdx, Direction dir) {
        int elevatorIdx = getNearestIdleElevator(floorIdx, dir);
        if (elevatorIdx != -1) {
            elevatorDestinations.set(elevatorIdx, floorIdx);
            game.setElevatorTravelDirection(elevatorIdx, dir);
            gotoFloor(elevatorIdx, floorIdx);
        } else {
            requests.get(floorIdx).add(new int[]{floorIdx, dir == Direction.Up ? topFloor : 0});
        }
    }
 
    // Finds the nearest idle elevator considering the direction
    private int getNearestIdleElevator(int floorIdx, Direction dir) {
        int nearestElevator = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < elevatorCount; i++) {
            if (game.isElevatorIdle(i)) {
                int elevatorFloor = (int) game.getElevatorFloor(i);
                int distance = Math.abs(elevatorFloor - floorIdx);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestElevator = i;
                }
            }
        }
        return nearestElevator;
    }
 
    // Checks if a request on a specific floor is already assigned to another elevator
    private boolean isRequestAssignedToOtherElevator(int floorIdx) {
        for (int destination : elevatorDestinations) {
            if (destination == floorIdx) {
                return true;
            }
        }
        return false;
    }
 
    // Adds a request for an elevator from the start floor to the end floor
    public void requestElevator(int startFloor, int endFloor) {
        requests.get(startFloor).add(new int[]{startFloor, endFloor});
        addFloorRequest(startFloor, startFloor < endFloor ? Direction.Up : Direction.Down);
    }
 
    // Simulates elevator movement to a specific floor
}