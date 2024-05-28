import java.util.*;

public class TaskFive {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Character> groups = new HashMap<>();
        char currentSet = 'A';

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

        for (int node : adjacencyList.keySet()){
            if(!groups.containsKey(node)){
                groups.put(node, currentSet);
                currentSet = (currentSet == 'A' ) ? 'B' : 'A';
            }
        }

        boolean bipartite = true;
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()){
            int vertex = entry.getKey();
            char group = groups.get(vertex);

            List<Integer> connections = entry.getValue();
            for (int links : connections){
                char type = groups.get(links);
                if (type == group){
                    bipartite = false;
                    break;
                }
            }
            if(!bipartite){
                break;
            }
        }
        if (bipartite) {
            System.out.println("Graph is bipartite.");
        } else {
            System.out.println("Graph is not bipartite.");
        }
    }
}
