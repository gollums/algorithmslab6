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

    public void create() {
        //TODO!
        int cellID;
        int first, second;
        Pair<Integer, Point.Direction> pair;
        DisjointSets disjointSets = new DisjointSets(maxCell);
        fini = new LinkedList<>();

        setChanged();
        notifyObservers("create");

        while(!disjointSets.trySet()){

            cellID = randomCell.nextInt(maxCell);
            Point.Direction direction = getRandomDirection();
            System.out.println(cellID);
            System.out.println(direction);
            pair = new Pair<>(cellID, direction);

            first = disjointSets.find(pair.first);

            if (disjointSets.find(cellID) != cellID){
                switch (direction){
                    case DOWN:
                        second = disjointSets.find(pair.first + maxCol);

                        if (first !=  second)
                            disjointSets.union(first,second);
                        break;

                    case LEFT:
                        second = disjointSets.find(pair.first - 1);
                        if (first !=  second)
                            disjointSets.union(first,second);
                        break;

                    case UP:
                        second = disjointSets.find(pair.first - maxCol);
                        if (first !=  second)
                            disjointSets.union(first,second);
                        break;

                    case RIGHT:
                        second = disjointSets.find(pair.first + 1);
                        if (first !=  second)
                            disjointSets.union(first,second);
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
