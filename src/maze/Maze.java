package maze;


import java.util.Random;

public class Maze extends Board {

    private Random randomDirection;
    private Random randomCell;


    public Maze(int rows, int cols) {
        super(rows, cols);
        //TODO!
        randomDirection = new Random();
        randomCell = new Random();
    }

    public void create() {
        //TODO!
        int cellID;
        Pair<Integer, Point.Direction> pair;
        DisjointSets disjointSets = new DisjointSets(maxCell);

        setChanged();
        notifyObservers("create");

        for (int i = 0; i < maxCell; i++){
            cellID = randomCell.nextInt(maxCell);
            Point.Direction direction = getRandomDirection();
            System.out.println(cellID);
            System.out.println(direction);
            pair = new Pair<>(cellID, direction);

            if (disjointSets.find(cellID) != cellID){
                switch (direction){
                    case DOWN:
                        disjointSets.union(cellID,cellID+maxCol);
                        break;

                    case LEFT:
                        disjointSets.union(cellID,cellID -1);
                        break;

                    case UP:
                        disjointSets.union(cellID, cellID + maxCol);
                        break;

                    case RIGHT:
                        disjointSets.union(cellID, cellID + 1);
                        break;

                }
            }
            setChanged();
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
