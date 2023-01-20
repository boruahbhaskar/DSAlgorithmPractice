package graph;

//Time complexity Union-find constructor O(n)
//Time complexity Find O(H)
// Time Complexity Union  O(H)
// Connected (H)

// n is the number of vertices in the graph and H is the height of the tree

class QuickUnionFind{

    private int[]  root;

    //create the array with vertices as index and root as value to the index

    public QuickUnionFind(int size){

        root = new int[size];

        for (int i = 0 ; i < root.length; i++){

            root[i] = i;
        }

    }


    // Method to find the root value

    public int find(int x){

        if (root[x] == x){
            return x;
        }

        return root[x] = find(root[x]);

       /* while(x != root[x]){

            x = root[x];

        }

        return x;


        */
    }


    // Method to connect to vertices and have single root

    public void union(int x , int y){

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
           root[rootY] = rootX;
        }

    }

    // Method to check whether two vertices are connected or not

    public boolean connected(int x, int y){

        return find(x) == find(y);
    }



}

public class GraphDisjoinSetQuickUnion {

    public static void main(String args[]) throws  Exception{

        QuickUnionFind uf = new QuickUnionFind(10);

        // 1-2-5-6-7   3-8-9 4

        uf.union(1,2);
        uf.union(2,5);
        uf.union(5,6);
        uf.union(6,7);
        uf.union(3,8);
        uf.union(8,9);

        System.out.println(uf.connected(1,5));
        System.out.println(uf.connected(5,7));
        System.out.println(uf.connected(4,9));


        // 1-2-5-6-7 3-8-9-4

        uf.union(9,4);
        System.out.println(uf.connected(4,9));
    }

}
