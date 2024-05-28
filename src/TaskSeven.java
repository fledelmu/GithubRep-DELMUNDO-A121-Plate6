import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = userInput.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = userInput.nextInt();

        int[][] incidenceMatrix = new int[vertices][edges];


        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge " + (i + 1) + ": ");
            int u = userInput.nextInt();
            int v = userInput.nextInt();

            incidenceMatrix[u - 1][i] = 1;
            incidenceMatrix[v - 1][i] = 1;
        }

        for (int i = 0 ; i < vertices ; i++){
            for (int j = 0 ; j < edges ; j++){
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
