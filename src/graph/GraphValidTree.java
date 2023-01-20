package graph;

//Iterative Depth First Search

import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class IterativeDFSValidTree{

    public boolean validTree(int n, int[][] edges){

        //For a graph to be valid , it must have exactly n-1 edges where n is the number of nodes/vertices
        //Any less it cant not be a fully connected
        //Any greater, it has to contain a cycle

        if(edges.length != n - 1) return false;

        //Create a new list of list

        List<List<Integer>>  adjacencyList = new ArrayList<>();

        // Initialise an empty list for each node

        for(int i = 0; i < n; i++){

            adjacencyList.add(new ArrayList<Integer>());

        }

        // Go through the edge list and populating through the adjacency list
         for(int[] edge : edges){

             adjacencyList.get(edge[0]).add(edge[1]);
             adjacencyList.get(edge[1]).add(edge[0]);

         }

        // define a stack to keep track of the unexplored nodes
        Stack<Integer> stack = new Stack<>();

         // define a set to keep track of already seen nodes to avoid infinite looping
        Set<Integer> seen = new HashSet<>();

        stack.push(0);
        seen.add(0);

        while(!stack.isEmpty()){

            int node = stack.pop();

            // check for unseen neighbour of this node
            for(int neighbour : adjacencyList.get(node) ) {

                //check if we've already seen this node, if yes, go the next iteration
                if (seen.contains(neighbour)) continue;

                //otherwise put the neighbour onto stack and record that the node has been seen
                stack.push(neighbour);
                seen.add(neighbour);
            }

        }

        // return true of DFS traversed all the nodes
        return seen.size() == n ;
    }


}

public class GraphValidTree {

    public static void main(String[] args) {

        IterativeDFSValidTree iterativeDFSValidTree = new IterativeDFSValidTree();

        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

        System.out.println(iterativeDFSValidTree.validTree(n,edges));

    }
}
