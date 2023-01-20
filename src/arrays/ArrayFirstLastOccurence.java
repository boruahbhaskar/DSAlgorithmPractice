package arrays;/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109


 */

public class ArrayFirstLastOccurence {

    public static void main(String args[]){

        int[] nums = {5,7,7,8,8,10};
        int[] res = new int[2];

        ArrayFirstLastOccurence arrayFirstLastOccurence = new ArrayFirstLastOccurence();

        res = arrayFirstLastOccurence.searchRange(nums,8);

        for(int i = 0 ; i< res.length; i++)
            System.out.print(res[i]);
    }


    public int[] searchRange(int[] nums, int target) {

        int[] results = new int[2];

        results[0] = findFirstPosition(nums,target);
        results[1] = findLastPosition(nums,target);

        return results;

    }

    public int findFirstPosition(int[] nums, int target){

        int index = -1;
        int start = 0;
        int end = nums.length -1;

        while(start <= end){

            int mid_point = start + (end-start)/2 ;

            if(nums[mid_point] >= target ){

                end = mid_point - 1;

            }else{

                start = mid_point + 1;
            }

            if(nums[mid_point] == target) index = mid_point;

        }

        return index;

    }


    public int findLastPosition(int[] nums, int target){

        int index = -1;
        int start = 0;
        int end = nums.length -1;

        while(start <= end){

            int mid_point = start + (end-start)/2 ;

            if(nums[mid_point] <= target ){

                start = mid_point + 1;

            }else{

                end = mid_point - 1;
            }

            if(nums[mid_point] == target) index = mid_point;

        }

        return index;

    }


}
