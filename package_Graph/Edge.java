package package_Graph;

public class Edge implements Comparable<Edge> {
    public String from ;
    public String to ;
    public int val ;
    public Edge(String from , String to , int val){
        this.from = from ;
        this.to = to ;
        this.val = val ;
    }

    @Override
    public int compareTo(Edge o) {
        return this.val - o.val ;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", val=" + val +
                '}';
    }
}
