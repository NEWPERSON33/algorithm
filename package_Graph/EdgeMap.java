package package_Graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeMap {
    public List<Edge>edges  ;
    public EdgeMap(){
        edges = new ArrayList<>() ;
    }

    public void build(){
        edges.add(new Edge("1", "2", 4));
        edges.add(new Edge("1", "3", -1));
        edges.add(new Edge("2", "3", 3));
        edges.add(new Edge("2", "4", 5));
        edges.add(new Edge("4", "5", 10));
        edges.add(new Edge("0", "2", 10));
        edges.add(new Edge("0", "3", 10));
        edges.add(new Edge("0", "4", 1));
        edges.add(new Edge("0", "5", 1));
        edges.sort(Edge::compareTo);
    }
}
