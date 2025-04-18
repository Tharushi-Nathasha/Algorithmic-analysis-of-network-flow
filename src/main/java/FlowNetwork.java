// FlowNetwork.java
import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private final int V;
    private List<List<FlowEdge>> adj;

    public FlowNetwork(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int v = 0; v < V; v++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj.get(v).add(e);
        adj.get(w).add(e); // add to both adjacency lists
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj.get(v);
    }

    public int V() {
        return V;
    }

    public Iterable<FlowEdge> edges() {
        List<FlowEdge> edges = new ArrayList<>();
        for (int v = 0; v < V; v++)
            for (FlowEdge e : adj.get(v))
                if (e.to() != v) // only add once (avoid duplicates)
                    edges.add(e);
        return edges;
    }
}