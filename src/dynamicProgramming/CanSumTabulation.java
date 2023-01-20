package dynamicProgramming;

/*
 Write a method canSumTabulation(int targetSum, int[] numbers) that takes in a targetSum and an array of numbers as arguments

 The method should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array

 You may use an element of the array as many times as needed

 you may assume that all input numbers are nonnegative

 Time - O(mn)
 Space - O(m)

 where m is the   targetSum
 n is the length of the numbers array

 */

public class CanSumTabulation {

    public boolean canSumTabulation(int targetSum, int[] numbers){

        boolean[] table = new boolean[targetSum+1];
        // Creating a table array to have indices with targetSum.. with boolean type and all elements marked as false

        for(boolean t: table)
             t = false;

        //for(boolean b : table)
        //System.out.println(b);

        // For O target sum , it will always be true as 0 can be achieved without any numbers
        table[0] = true;

        for(int i = 0 ; i <= targetSum; i++){

            if(table[i]){ // If table[i] is true that means (table[i+num] also true

                for(int num: numbers){

                    if(i+num < targetSum+1) // to take care array out of bound exceptions
                    table[i+num] = true;

                }

            }
        }


        return table[targetSum];
    }

    public static void main(String[] args) {
        CanSumTabulation canSumT = new CanSumTabulation();

        int target = 7;
        int[] numbers = {5,3,4};

        System.out.println(canSumT.canSumTabulation(target, numbers));

    }
}
