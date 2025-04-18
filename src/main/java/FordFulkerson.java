// FordFulkerson.java
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private boolean[] marked;     // marked[v] = true iff s->v path in residual graph
    private FlowEdge[] edgeTo;    // edgeTo[v] = last edge on shortest residual s->v path
    private int value;            // current value of max flow

    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0;

        while (hasAugmentingPath(G, s, t)) {
            System.out.println("\nFound augmenting path:");

            // Compute bottleneck capacity
            int bottle = Integer.MAX_VALUE;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }
            System.out.println("Bottleneck capacity: " + bottle);

            // Augment flow
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
                System.out.println("Updated edge: " + edgeTo[v]);
            }

            value += bottle;
            System.out.println("Current flow value: " + value);
        }
    }

    public int value() {
        return value;
    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        marked = new boolean[G.V()];
        edgeTo = new FlowEdge[G.V()];
        Queue<Integer> q = new LinkedList<>();

        marked[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.remove();

            for (FlowEdge e : G.adj(v)) {
                int w = e.other(v);

                // Found path from s to w in the residual network?
                if (e.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }

        return marked[t];
    }
}