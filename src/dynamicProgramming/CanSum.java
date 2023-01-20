package dynamicProgramming;

import java.util.HashMap;

/*
Write a method canSumTabulation(int targetSum, int[] numbers) that takes in a targetSum and an array of numbers as arguments

 The method should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array

 You may use an element of the array as many times as needed

 you may assume that all input numbers are nonnegative

 Time - O(mn)
 Space - O(m)

 */

public class CanSum {

    //Brute Force Time O(n^m) || O(m) -- m is the target sum -- n is the length of the array

    //Memoization Time O( m * n ) || O(m) -- m is the target sum -- n is the length of the array

    private HashMap<Integer,Boolean> map = new HashMap<>();

    public boolean canSum(int totalSum, int[] arr){


        if(map.containsKey(totalSum)) {
           // System.out.println("I am here true "+totalSum);
            return map.get(totalSum);
        }

        if (totalSum == 0 ) {
            return true;
        }

        if (totalSum < 0 ) {
            return false;
        }



        for(int ar : arr){

            int reminder = totalSum - ar;

            if(canSum(reminder,arr)) {
                map.put(totalSum, true);
                return true;
            }
        }



        map.put(totalSum,false);
        return false;
    }

    public static void main(String[] args) {
        CanSum cs = new CanSum();
        System.out.println(cs.canSum(7,new int[]{2,4}));
    }
}
