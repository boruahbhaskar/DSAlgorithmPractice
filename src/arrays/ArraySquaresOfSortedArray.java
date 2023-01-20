package arrays;/*
* Given an integer array nums sorted in non-decreasing order,
* return an array of the squares of each number sorted in non-decreasing order.
*
* Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
*
*Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

*
* Example 1 -
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
*
* Example 2 -
*
* Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

*
*
* */

import java.util.Arrays;

public class ArraySquaresOfSortedArray {

    public static void main(String[] args) {

        int[] nums = {-4,-1,0,3,10};

        ArraySquaresOfSortedArray arraySquaresOfSortedArray = new ArraySquaresOfSortedArray();

        System.out.println("Input Array : "+ Arrays.toString(nums));

        System.out.println("Output Array squares of sorted array : "+Arrays.toString(arraySquaresOfSortedArray.getSquaresOfSortedArray(nums)));
    }

    public int[] getSquaresOfSortedArray(int[] nums){

        int array_length  = nums.length;
        int[] square_array = new int[array_length];

        int left = 0;
        int right = array_length -1;

        for(int i = array_length-1; i>=0 ; i--){

            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                square_array[i] = nums[left] * nums[left];
                left++;
            }else{
                square_array[i] = nums[right] * nums[right];
                right--;
            }

        }


        // Easy solution using built in data structures
        /*
        for(int i =0; i< array_length;i++){

            square_array[i] = nums[i]* nums[i];
        }

        Arrays.sort(square_array);
        */
        //end here



        return square_array;



    }

}
