package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/*

Write a methode bestSum (int targetSum, int[] numbers) that takes in a targetSum and an array of numbers as arguments

The method should return an array containing shortest combination of elements that add up to exactly the targetSum.

If there is no combination that add up to the targetSum, then return null.


Brute Force
m = target sum
n = numbers.length

Time - O(n^m * m )
Space - o(m^2)

Memoization

Time - O(n * m^2)
Space - O(m^2)

 */

public class BestSum {

    private HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();

    public int[] bestSum(int targetSum, int[] numbers){

        if(map.containsKey(targetSum))
            return map.get(targetSum);

        int arrayLength = Math.abs(targetSum) + 1;

        if(targetSum == 0)
            return new int[0];
        if(targetSum < 0)
            return null;


        int[] shortestCombi = null;

        for(int num: numbers){

            int remainder = targetSum - num;

            int[] remainderList = new int[arrayLength];

            remainderList = bestSum(remainder,numbers);

            if(remainderList != null){

               int[] remainderListArr = Arrays.copyOf(remainderList,remainderList.length+1);
               remainderListArr[remainderList.length] = num ;

                if(shortestCombi == null || remainderListArr.length < shortestCombi.length){
                    shortestCombi = remainderListArr;
                }

            }


        }

        map.put(targetSum,shortestCombi);
        return map.get(targetSum);

    }

    public static void main(String[] args) {

        BestSum bs = new BestSum();
        int[] numbers = {4,3,5,7};
        int targetSum = 7;

        System.out.println("Possible combination of numbers for target sum : "+ Arrays.toString(bs.bestSum(targetSum,numbers)));

    }
}
