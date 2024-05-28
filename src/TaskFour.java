import java.util.*;

public class TaskFour {
    public static void main(String[] args){
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

        HashMap<Integer, Integer> deg = new HashMap<>();

        for(Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()){
            int vertex = entry.getKey();
            int degree = entry.getValue().size();
            deg.put(vertex, degree);
        }

        for(Map.Entry<Integer, Integer> entry : deg.entrySet()){
            System.out.println("Node "+ entry.getKey() + " has a degree of " + entry.getValue());
        }
    }
}
