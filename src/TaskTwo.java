import java.util.*;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("How many vertices? ");
        int n = userInput.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = userInput.nextInt();
            }
        }

        Map<String, Integer> edgeCounter = new HashMap<>();

        String currentEdge = "";
        for(int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    String edge = "("+(i + 1) + "," + (j + 1)+")";
                    if(!edge.equals(currentEdge)){
                        if(!currentEdge.isEmpty()){
                            System.out.println("Edge " + currentEdge + " : " + " Appeared " + edgeCounter.get(currentEdge) + " time(s)");
                        }
                        currentEdge = edge;

                        edgeCounter.put(currentEdge,0);
                    }
                    edgeCounter.put(currentEdge, edgeCounter.get(currentEdge) + matrix[i][j]);
                }
            }
        }
        if (!currentEdge.isEmpty()) {
            System.out.println("Edge " + currentEdge + " : " + " Appeared " + edgeCounter.get(currentEdge) + " time(s)");
        }
    }
}
