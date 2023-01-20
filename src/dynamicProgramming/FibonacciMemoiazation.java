package dynamicProgramming;

import java.util.HashMap;

public class FibonacciMemoiazation {

    // Time O(n) || Space O(n) where is the n is the length of the series

    private HashMap<Integer,Long> map = new HashMap<>(); //O(1)

    public long getFibonaciValue(int n){

        if(n < 0)
        {
            throw new IllegalArgumentException(" Index was negative.");
        }else if( n == 0 || n ==1){ //base case
            return 1;
        }

        // see if we already calculated n
        if(map.containsKey(n)){
            return map.get(n);
        }

        long result = getFibonaciValue(n-1) + getFibonaciValue(n-2);

        //momoize
        map.put(n,result);

        return result;

    }

    public static void main(String[] args) {
        FibonacciMemoiazation fm = new FibonacciMemoiazation();
        System.out.println("Fibonaccie values of 50 is : "+fm.getFibonaciValue(50));
    }
}
