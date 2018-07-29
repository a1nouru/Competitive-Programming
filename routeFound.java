package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;


// We can easily find a route between 2 Vertices by just doing a simple Graph traversal. 
Here i used DFS to get more familliar with it, but you might as well use BFS. 


public class Main {

    static class Graph {

        int v;
        LinkedList<Integer> adjArray[];

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

        boolean DFSUtil(int v, int dest, boolean visited[]){
            visited[v] = true;

            Iterator<Integer> iter = adjArray[v].listIterator();

            while(iter.hasNext()){
                int n = iter.next();
                if(!visited[n])
                {
                    if(n == dest){
                        return true;
                    }
                    DFSUtil(n, dest, visited);
                }
            }
            return false;
        }

        boolean DFS(int v, int dest){
            boolean visited[] = new boolean[this.v];

            if(DFSUtil(v,dest,visited))
                return true;

            return false;
        }

        public static void main(String args[]) {
            int v = 5;
            Graph graph = new Graph(5);

            addEdge(graph, 0, 1);
            addEdge(graph, 0, 4);
            addEdge(graph, 1, 2);
            addEdge(graph, 1, 3);
            addEdge(graph, 1, 4);
            addEdge(graph, 2, 3);
            addEdge(graph, 3, 4);

            if(graph.DFS(1, 4)){
                System.out.println("Route found in Bestween "+ 1 + " and " + 4);
            }
            else
                System.out.println("No route found");
            //printGraph(graph);
        }
    }
}
