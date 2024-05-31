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

        int count = 0;
        List<Integer> check = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            boolean connected = true;
            for (List<Integer> adjacent : adjacencyList.values()) {
                if (!adjacent.contains(vertex)) {
                    connected = false;
                    break;
                }
            }
            if (!connected) {
                count++;
            } else {
                check.add(vertex);
            }
        }

        count /= 2;
        if(check.size() == adjacencyList.size()){
            System.out.print("Graph is connected.");
        }else{
            System.out.print("Graph is disconnected.\nNumber of connections: "+count);
        }

    }
}
