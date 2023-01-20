package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/*
Write a method howSumTabulation(targetSum,numbers) that takes in a targetSum and an array of numbers as arguments

The method should return an array containing any combination of elements that add up to exactly the targetSum

If there is no combination that adds up to the targetSum, then return null.

If there are multiple combination possible, you may return single one

 m = targetSum
 n = numbers.length

 Time: O(m^2 * n)  -  Space: O(m^2)

 */
public class HowSumTabulation {

    public int[] howSumTab(int targetSum, int[] numbers){

        /* Sanity Check*/
        if (targetSum == 0)
                return null;

        /*Initialization of the table*/
       // ArrayList<Integer>[] table = new ArrayList[targetSum+1];

        ArrayList<Integer>[] table = new ArrayList[targetSum + 1];

        // assign element with 0 index with an empty array
        table[0] = new ArrayList<Integer>();


        for(int i=0; i <= targetSum; i++ ){

            if(table[i] != null){

                for(int num: numbers){
                    // compute the target index
                    int targetIndex = i + num;


                    if (targetIndex <= targetSum){
                        // **** initialize list (if needed) ****
                        if (table[targetIndex] == null)
                            table[targetIndex] = new ArrayList<Integer>();

                        // **** copy all elements from table[i] to table[targetIndex] ****
                        ArrayList<Integer> src = table[i];
                        ArrayList<Integer> dest = table[targetIndex];

                        dest.clear();
                        dest.addAll(src);
                        // **** add current element to table[ndx] ****
                        dest.add(num);
                        table[targetIndex] = dest;
                    }

                }
            }


        }

        // **** check if no answer was found ****
        //IntStream.toArray() throws a NullPointerException if any null values are present in the list. below check is important
        if (table[targetSum] == null) return null;

        // **** get list of targetSum index from the table ****
        ArrayList<Integer> lst = table[targetSum];

        // **** convert List<Integer> to int[] ****
        int[] arr = lst.stream().mapToInt( x -> x).toArray();

        // **** return int[] ****

        return  arr;

        /*
        How to handle null values in the list?
            IntStream.toArray() throws a NullPointerException if any null values are present in the list. There are many options to handle null values:

            1. Filter out the null values before mapping:

            int[] primitive = list.stream()
                                .filter(Objects::nonNull)
                                .mapToInt(Integer::intValue)
                                .toArray();
            2. Map the null values to a default value:

            int[] primitive = list.stream()
                                .map(i -> (i == null ? 0 : i))
                                .mapToInt(Integer::intValue)
                                .toArray();
            3. Handle null inside the lambda expression itself:

            int[] primitive = list.stream()
                                .mapToInt(i -> (i == null ? 0 : i))
                                .toArray();

         */


    }


    public static void main(String[] args) {
        HowSumTabulation howSumTabulation = new HowSumTabulation();
        int targetSum = 6 ;
        int[] numbers = {5,1};

       // int[] result = new int[targetSum];
        //   result = ;
        System.out.println(Arrays.toString(howSumTabulation.howSumTab(targetSum,numbers)));


    }

}
