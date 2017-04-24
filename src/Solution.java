import java.io.*;
import java.util.*;

public class Solution 
{

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for (int i = 0; i < queries; i++) 
        {
            int numOfNodes = in.nextInt();
            int numOfEdges = in.nextInt();
            int[][] adjacencyMatrix = new int[numOfNodes+1][numOfNodes+1];
            for (int j = 0; j<numOfEdges; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adjacencyMatrix[u][v] = 6;
                adjacencyMatrix[v][u] = 6;
            }
            int startNode = in.nextInt();
            Queue<Integer> bfs = new LinkedList<Integer>();
            
            bfs.add(startNode);
            boolean[] visited = new boolean[numOfNodes+1];
            int[] distance = new int[numOfNodes+1];
            visited[startNode] = true;
            //visited[0] = true;
            while (!bfs.isEmpty()) {
                int current = bfs.remove();
                for (int k = 1; k <= numOfNodes; k++) {
                    if (adjacencyMatrix[current][k] != 0 && (!visited[k])) {
                        bfs.add(k);
                        visited[k] = true;
                        distance[k] = distance[current] + adjacencyMatrix[current][k];
                    }
                }
            }
            for (int l = 0; l <= numOfNodes; l++) {
                if(distance[l] == 0)
                    distance[l] = -1;
            }
            distance[0] = 0;
            distance[startNode] = 0;
            for (int l = 0; l <= numOfNodes; l++) {
                if (distance[l] != 0)
                    System.out.print(distance[l] + " ");
            }
            System.out.println();
        }
    }
}
