// NetworkFlow.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NetworkFlow {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java NetworkFlow <input-file>");
            return;
        }

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            // Read number of nodes
            int V = scanner.nextInt();
            FlowNetwork network = new FlowNetwork(V);

            // Read edges
            while (scanner.hasNextInt()) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                int capacity = scanner.nextInt();
                network.addEdge(new FlowEdge(v, w, capacity));
            }
            scanner.close();

            // Compute max flow
            FordFulkerson ff = new FordFulkerson(network, 0, V-1);

            // Output results
            System.out.println("Maximum flow: " + ff.value());
            System.out.println("Flow details:");
            for (FlowEdge e : network.edges()) {
                if (e.from() != e.to()) { // skip self-loops if any
                    System.out.println(e);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
        }
    }
}