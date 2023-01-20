package graph;

import java.util.ArrayList;
import java.util.List;


/*
Here EE = Number of edges, VV = Number of vertices.

Time complexity: {O}(E + V)O(E+V).

Building the adjacency list will take {O}(E)O(E) operations, as we iterate over the list of edges once, and insert each edge into two lists.

During the DFS traversal, each vertex will only be visited once. This is because we mark each vertex as visited as soon as we see it, and then we only visit vertices that are not marked as visited. In addition, when we iterate over the edge list of each vertex, we look at each edge once. This has a total cost of {O}(E + V)O(E+V).

Space complexity: {O}(E + V)O(E+V).

Building the adjacency list will take {O}(E)O(E) space. To keep track of visited vertices, an array of size {O}(V)O(V) is required. Also, the run-time stack for DFS will use {O}(V)O(V) space.
 */
public class GraphNoOfConnectedComponentUndirectGraph {

    public static void main(String[] args) {

        GraphNoOfConnectedComponentUndirectGraph dfsCountComponent = new GraphNoOfConnectedComponentUndirectGraph();

        int[][] edges = {{0,1},{1,2},{3,4}};

        int count = dfsCountComponent.countComponent(5,edges);



        System.out.println(count);
    }

    public  int countComponent(int n, int[][] edges){



        int component = 0;

        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];

        for(int i = 0; i < n ; i++){

            adjList[i] = new ArrayList<Integer>();

        }
        for(int i = 0; i< edges.length; i++){

            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);

        }

        for (int i = 0; i < n ; i++){

            if(visited[i] == 0){
                component++;
                dFSCount(adjList,visited,i);

            }

        }

        return component;
    }

    public void dFSCount(List<Integer>[] adjList, int[] visited, int startNode){

        visited[startNode] = 1;

        for(int i=0; i < adjList[startNode].size(); i++){

            if(visited[adjList[startNode].get(i)] ==0){

                dFSCount(adjList, visited, adjList[startNode].get(i));
            }

        }


    }

}
