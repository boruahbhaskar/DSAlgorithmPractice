package dynamicProgramming;

public class FibonacciTabulation {

    // Time O(n)
    // Space O(n)b

    public long getFibbo(int n){

        long[] dp = new long[n+2];

        for(int i = 0 ; i < dp.length; i++){
            dp[i] = 0;
        }
        //dp[0] = 0;
        dp[1] = 1;

       for(int i = 0 ; i <=  n -1 ; i++){

          // System.out.println(i);

          // System.out.println(dp[i]);

           dp[i + 1] += dp[i]  ;
          // System.out.println(i+1 +" = i +1 = "+dp[i + 1]);
           dp[i + 2] += dp[i]  ;
          //  System.out.println(i+2 +" = i +2 = "+dp[i + 2]);
       }


        return dp[n];
    }

    public static void main(String[] args) {

        FibonacciTabulation ft = new FibonacciTabulation();

        System.out.println("Result : "+ft.getFibbo(8));

        //System.out.println("Result : "+ft.getFibbo(50));


    }
}
