package dynamicProgramming;


/*

Write a methode howManySum (int targetSum, int[] numbers) that takes in a targetSum and an array of numbers as arguments

The method should return an array containing any combination of elements that add up to exactly the targetSum.

If there is no combination that add up to the targetSum, then return null.

If there are multiple combination possible , you may return any single one


Brute Force
m = target sum
n = numbers.length

Time - O(n^m * m )
Space - o(m)

Memoization

Time - O(n * m^2)
Space - O(m)

 */

import java.util.Arrays;
import java.util.HashMap;

public class HowManySum {

    private HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();

    public int[] howManySum(int targetSum, int[] numbers){

        if(map.containsKey(targetSum))
            return map.get(targetSum);

        int indexCount = Math.abs(targetSum) +1;

        if(targetSum == 0)
            return new int [0];
        if(targetSum < 0 )
            return  null ;

        for(int num: numbers){
            int remainder = targetSum - num;


            int[] remianderResult = new int[indexCount] ;

            remianderResult =  howManySum(remainder,numbers);


            if(remianderResult != null) {
                map.put(targetSum,copyArray(remianderResult,num));
                return map.get(targetSum)   ;//copyArray(remianderResult,num);
            }
        }


        map.put(targetSum,null);
        return map.get(targetSum);

    }

    public static int[] copyArray(int[] arr, int numb){

        int[] newArray = Arrays.copyOf(arr,arr.length+1);
        newArray[arr.length] = numb;
        return newArray;

    }

    public static void main(String[] args) {
        HowManySum hms = new HowManySum();
        int[] numbers = {2,3,5};
        int targetSum = 8;

        System.out.println("Possible combination of numbers for target sum : "+ Arrays.toString(hms.howManySum(targetSum,numbers)));



    }
}
