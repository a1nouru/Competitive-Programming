package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

public class Main {

    static class Graph {

       public static int v;
       public static LinkedList<Integer> adjArray[];

        public Graph(int v) {
            this.v = v;

            // define the size of array as
            // number of vertices
            adjArray = new LinkedList[v];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for (int i = 0; i < v; i++) {
                adjArray[i] = new LinkedList<>();
            }
        }

        // Adds an edge to an undirected graph
        static void addEdge(Graph graph, int src, int dest) {
            // Add an edge from src to dest.
            graph.adjArray[src].addFirst(dest);
            //add an adge from dest to src since it's an undirected edge.
            graph.adjArray[dest].addFirst(src);
        }

        // A utility function to print the adjacency list
        // representation of graph

        static void printGraph(Graph graph) {

            for (int i = 0; i < graph.v; i++) {
                System.out.println("Adjacency list of vertex " + i);
                System.out.print("head ");

                for (Integer traver : graph.adjArray[i]) {
                    System.out.print("->"+traver);
                }
                System.out.println();
            }
        }

       public static void BFS(int src){

            boolean visited[] = new boolean[v];

            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[src] = true;

            queue.add(src);

            while(queue.size() != 0){

                int n = queue.poll();
                System.out.print(n+" ");

                Iterator<Integer> iter = adjArray[n].listIterator();

                while(iter.hasNext()){

                    int tempNum = iter.next();

                    if(!visited[tempNum]){
                        visited[tempNum] = true;
                        queue.add(tempNum);
                    }
                }
            }
        }

        public static void main(String args[]) {
            int v = 5;
            Graph graph = new Graph(4);

            addEdge(graph, 0, 1);
            addEdge(graph, 0, 2);
            addEdge(graph, 1, 2);
            addEdge(graph, 2, 0);
            addEdge(graph, 2, 3);
            addEdge(graph, 3, 3);
          //  addEdge(graph, 3, 4);
            
//            addEdge(0, 1);
//            g.addEdge(0, 2);
//            g.addEdge(1, 2);
//            g.addEdge(2, 0);
//            g.addEdge(2, 3);
//            g.addEdge(3, 3);

            BFS(2);

            //printGraph(graph);
        }
    }
}
