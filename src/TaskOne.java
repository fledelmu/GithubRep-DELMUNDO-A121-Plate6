import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        System.out.print("Enter amount of edges: ");
        int pairs = userInput.nextInt();

        for (int i = 0 ; i < pairs ; i++){
            System.out.print("Edge "+(i+1)+": ");
            int u = userInput.nextInt();
            int v = userInput.nextInt();

            adjacencyList.putIfAbsent(u, new ArrayList<>());
            adjacencyList.putIfAbsent(v, new ArrayList<>());

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        List<Integer> check = new ArrayList<>();
        for (int vertex : adjacencyList.keySet()) {
            boolean isConnectedToAll = true;
            for (int otherVertex : adjacencyList.keySet()) {
                if (otherVertex != vertex && !adjacencyList.get(vertex).contains(otherVertex)) {
                    isConnectedToAll = false;
                    break;
                }
            }
            if (isConnectedToAll) {
                check.add(vertex);
            }
        }
        
        int count = 0;
        for (List<Integer> adjacency : adjacencyList.values()) {
            count += adjacency.size();
        }
        
        count /= 2;
        if (check.size() == adjacencyList.keySet().size()) {
            System.out.print("Graph is connected.");
        } else {
            System.out.print("Graph is disconnected.\nNumber of connections: " + count);
        }
    }
}
