package maze;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExtendedGraph extends Graph {

    public List<Integer> getPath(int destName ) {
        unweighted(0);
        List<Integer> tmpList = new LinkedList<>();
        Vertex w = vertexMap.get(destName);
        if(w == null){
            throw new NoSuchElementException("Destination vertx not found");
        }else{
            return getPath(w);
        }
    }
    private List<Integer> getPath( Vertex dest ) {

        List<Integer> retList = new LinkedList<>();
        if(dest == null){
            return retList;
        }else{
            retList = getPath(dest.prev);
            retList.add(dest.name);
            return retList;
        }
    }
}
