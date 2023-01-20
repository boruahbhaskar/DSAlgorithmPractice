package arrays;/*
Given a sorted array, remove the duplicates such that each element appears only once.
Input: array = [1, 1, 2]
Output: [1, 2]

Input: array = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
Output: [0, 1, 2, 3, 4]

 */

public class ArrayRepeatedDeletion {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        copyWithRemovedDuplicates(arr);

        for(int ar : arr)
            System.out.print(ar+" ");

    }

    public static int[] copyWithRemovedDuplicates(int[] nums) {

        int len = nums.length;
        //check for edge cases
        if (nums == null || len ==0) {
            return nums;
        }

        // Use the two pointer technique to remove the duplicate in-place
        // The first element should not be touched; it's already in the correct place

        int writePointer = 1;

        // Go through each element of the array
        for(int readPointer =1; readPointer< len; readPointer++){

            //If the current element we are reading is *different* to the previous element
            if(  nums[readPointer] != nums[readPointer - 1]){
                //Copy it into the next position at the front ,tracked by the writePointer
                nums[writePointer] = nums[readPointer];
                //And we need to now increment writePointer, because the next element should be written one space over
                writePointer++;

            }

        }

        // This turns out to be the correct length value
        // return writePointer;

        for(int j = 0; j< nums.length; j++)
        {
            if (j >= writePointer){
                nums[j] = 0;
            }

        }

        return nums;

    }

}
