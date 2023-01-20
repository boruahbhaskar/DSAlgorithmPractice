package dynamicProgramming;

/*
Say that you are a traveller on a 2D grid. you begin in the top left corner
and your goal is to travel to the bottom right corner. you only move one down or right.

In how many ways can you travel to the goal on a grid with dimension m * n ?

Write a method to gridTravller(m , n) that calculate this

Approach -

Add a an extra row and column to the existing grid

consider dp[1][1] = 1 as there is only one way to reach grid of 1 by 1

Time - O(mn)
Space - O(mn)

 */

public class GridTravellerTabulation {

    public int gridTraveller(int m, int n){

        int[][] dp = new int[m+1][n+1];

        for(int i= 0; i < m; i++){

            for(int j=0; j<n ; j++){
                dp[i][j] = 0;
            }
        }

        dp[1][1] = 1;

      //  System.out.println(Arrays.deepToString(dp));

        for(int i= 0 ; i<=m ; i++){
            for(int j= 0; j <=n ; j++){

                int currentValue = dp[i][j];

                if(j+1 <= n) // to take care of array out of bound exceptions
                dp[i][j+1] += currentValue;

                if(i+1 <= m) // to take care of array out of bound exceptions
                dp[i+1][j] += currentValue;

            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {

        GridTravellerTabulation gt = new GridTravellerTabulation();

        System.out.println("We can travel to the goal on a grid with dimension m*n , ways : "+gt.gridTraveller(15,15));

    }
}
