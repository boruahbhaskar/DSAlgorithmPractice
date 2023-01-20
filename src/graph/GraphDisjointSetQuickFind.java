package graph;


//Time complexity Union-find constructor O(n)
//Time complexity Find O(1)
// Time Complexity Union  O(n)
// Connected (1)

class UnionFind{

    private int[]  root;

    //create the array with vertices as index and root as value to the index

    public UnionFind(int size){

        root = new int[size];

        for (int i = 0 ; i < root.length; i++){

            root[i] = i;
        }

    }


    // Method to find the root value

    public int find(int x){

        return root[x];
    }


    // Method to connect to vertices and have single root

    public void union(int x , int y){

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){

            for(int i=0; i< root.length; i++){

                if(root[i] == rootY){
                    root[i] = rootX;
                }

            }
        }

    }

    // Method to check whether two vertices are connected or not

    public boolean connected(int x, int y){

        return find(x) == find(y);
    }



}

public class GraphDisjointSetQuickFind {

    public static void main(String args[]) throws  Exception{

        UnionFind uf = new UnionFind(10);

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
