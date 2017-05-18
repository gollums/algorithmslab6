package maze;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Maze extends Board {

    private Random randomDirection;
    private Random randomCell;
    private List<Integer> fini;



    public Maze(int rows, int cols) {
        super(rows, cols);
        //TODO!
        randomDirection = new Random();
        randomCell = new Random();
    }

    /**
     * Creates a maze with help of unions.
     */
    public void create() {
        //TODO!
        int cellID;
        int first, second, unionCounter = maxCell;
        Pair<Integer, Point.Direction> pair;
        DisjointSets disjointSets = new DisjointSets(maxCell);

        setChanged();
        notifyObservers("create");

        while(unionCounter > 1){

            cellID = randomCell.nextInt(maxCell-1);
            Point.Direction direction = getRandomDirection();
            System.out.println(cellID);
            System.out.println(direction);
            pair = new Pair<>(cellID, direction);

            first = disjointSets.find(pair.first);

                switch (direction){
                    case DOWN:
                        if (pair.first < maxCell - maxCol) {
                            second = disjointSets.find(pair.first + maxCol);
                            if (first != second) {
                                disjointSets.union(first, second);
                                unionCounter--;
                                setChanged();
                            }
                        }
                        break;

                    case LEFT:
                        if(pair.first % maxCol != 0) {
                            second = disjointSets.find(pair.first - 1);
                            if (first != second) {
                                disjointSets.union(first, second);
                                unionCounter--;
                                setChanged();
                            }
                        }
                        break;

                    case UP:
                        if (pair.first > maxCol -1) {
                            second = disjointSets.find(pair.first - maxCol);
                            if (first != second) {
                                disjointSets.union(first, second);
                                unionCounter--;
                                setChanged();
                            }
                        }
                        break;

                    case RIGHT:
                        if(pair.first % maxCol != maxCol -1) {
                            second = disjointSets.find(pair.first + 1);
                            if (first != second) {
                                disjointSets.union(first, second);
                                unionCounter--;
                                setChanged();
                            }
                        }
                        break;
                }
            notifyObservers(pair);
        }

    }

    private Point.Direction getRandomDirection() {
        int r = randomDirection.nextInt(4);

        switch (r) {
            case 0:
                return Point.Direction.LEFT;
            case 1:
                return Point.Direction.RIGHT;
            case 2:
                return Point.Direction.UP;
            case 3:
                return Point.Direction.DOWN;
        }
        return null;
    }

    public void search() {
        //TODO!



    }
    
    // TODO!
}
