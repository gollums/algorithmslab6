package maze;

import java.util.Random;

public class Maze extends Board {

    private Random randomDirection;
    private Random randomCell;
    private ExtendedGraph graphPath;


    public Maze(int rows, int cols) {
        super(rows, cols);
        randomDirection = new Random();
        randomCell = new Random();
        graphPath = new ExtendedGraph();
    }

    /**
     * Creates a maze with help of unions.
     */
    public void create() {
        int cellID;
        int first, second, unionCounter = maxCell;
        Pair<Integer, Point.Direction> pair;
        DisjointSets disjointSets = new DisjointSets(maxCell);

        setChanged();
        notifyObservers("create");

        while(unionCounter > 1){

            cellID = randomCell.nextInt(maxCell-1);
            Point.Direction direction = getRandomDirection();
            pair = new Pair<>(cellID, direction);

            first = disjointSets.find(pair.first);

                switch (direction){
                    case DOWN:
                        if (pair.first < maxCell - maxCol) {
                            second = disjointSets.find(pair.first + maxCol);
                            if (first != second) {
                                disjointSets.union(first, second); // creates a set between two nodes in the grid
                                //Roads are connected depending on what direction is randomized
                                graphPath.addEdge(pair.first,pair.first + maxCol, 1.0); //links nodes with a bridge
                                graphPath.addEdge(pair.first + maxCol,pair.first,1.0);//links nodes with bridge back
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
                                graphPath.addEdge(pair.first,pair.first -1, 1.0);
                                graphPath.addEdge(pair.first -1,pair.first,1.0);
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
                                graphPath.addEdge(pair.first,pair.first - maxCol, 1.0);
                                graphPath.addEdge(pair.first -maxCol,pair.first,1.0);
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
                                graphPath.addEdge(pair.first,pair.first +1, 1.0);
                                graphPath.addEdge(pair.first +1,pair.first,1.0);
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

        for (int i : graphPath.getPath(maxCell - 1)){
            setChanged();
            notifyObservers(i);
        }

    }
}
