package graph;

import java.util.LinkedList;
import java.util.Queue;

class DFSSolution{

    public int findNumberOfProvince(int[][] isConnected){

        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int[] visited = new int[isConnected.length];
        int count = 0;



        for(int i=0; i<isConnected.length; i++){

            if(visited[i] == 0){
                DFS(isConnected, visited, i);
                count++;
            }

        }
        return count;
    }

    public void DFS(int[][] isConnected, int[] visited, int i){

        for(int j = 0 ; j< isConnected.length; j++){

            if(isConnected[i][j]  == 1 && visited[j] == 0){

                visited[j] = 1;
                DFS(isConnected,visited,j);

            }

        }


    }

}

class BFSSolution{

    public int bfsCountProvince(int[][] M){



        if (M == null || M.length == 0) {
            return 0;
        }
        int[] visited = new int[M.length] ;
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i< M.length; i++){

            if(visited[i] == 0){

                queue.add(i);

                while(!queue.isEmpty()){

                    int s = queue.remove();
                    visited[s] = 1;

                    for(int j= 0; j< M.length; j++){

                        if(M[s][j] == 1 && visited[j] ==0){

                            queue.add(j);
                        }


                    }


                }

                count++;
            }


        }

        return count;
    }

}

public class GraphDFSBFSNumberOfProvince {

    public static void main(String[] args) {

        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] isConnected2 = {{1,1,0},{1,1,0},{0,0,1}};

        DFSSolution df = new DFSSolution();
        int  dfsCount = df.findNumberOfProvince(isConnected);

        System.out.println(dfsCount);


        BFSSolution bf = new BFSSolution();
        int  bfsCount = bf.bfsCountProvince(isConnected2);

        System.out.println(bfsCount);

    }


}
