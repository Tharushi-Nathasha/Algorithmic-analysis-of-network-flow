// FlowEdge.java
public class FlowEdge {
    private final int v;             // from
    private final int w;             // to
    private final int capacity;      // capacity
    private int flow;                // current flow

    public FlowEdge(int v, int w, int capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int from()         { return v; }
    public int to()           { return w; }
    public int capacity()     { return capacity; }
    public int flow()         { return flow; }
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Invalid endpoint");
    }

    public int residualCapacityTo(int vertex) {
        if (vertex == v) return flow;              // backward edge
        else if (vertex == w) return capacity - flow;   // forward edge
        else throw new IllegalArgumentException("Invalid endpoint");
    }

    public void addResidualFlowTo(int vertex, int delta) {
        if (vertex == v) flow -= delta;           // backward edge
        else if (vertex == w) flow += delta;     // forward edge
        else throw new IllegalArgumentException("Invalid endpoint");
    }

    @Override
    public String toString() {
        return v + "->" + w + " (" + flow + "/" + capacity + ")";
    }
}