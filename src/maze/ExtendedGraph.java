package maze;

import java.util.Iterator;
import java.util.List;

public class ExtendedGraph extends Graph {
    List <Integer> pathList;

    public List<Integer> getPath(int destName ) {
        dijkstra(destName);
        printPath(destName);
        ad;

        for(int i = 0; i < destName; i++) {
            getPath(vertexMap.get(i));
        }

        return null;
    }
    private List<Integer> getPath( Vertex dest ) {

        if (dest.name == 0){

        }else {
            dest.adj.get(0);
            getPath(vertexMap.get(0).prev);
        }

        return null;
    }
}
