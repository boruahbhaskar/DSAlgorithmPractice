package arrays;/*
Find All Numbers Disappeared in an Array

Solution
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count a


 */

import java.util.ArrayList;
import java.util.List;

public class ArrayNumberDisappeared {

    public static void main(String[] args) {

        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> disappearlist = new ArrayList<>();

        disappearlist = findDisappearedNumbers(nums);

        for(Integer lst: disappearlist)
            System.out.println(lst.toString());

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            int index = Math.abs(nums[i]) -1;

            if(nums[index]> 0){

                nums[index] = nums[index] *-1;
            }

        }

        for( int j = 0; j< nums.length; j++){

            if(nums[j]> 0){

                list.add(j+1);
            }
        }


        /*
        int length = nums.length;



        HashSet<Integer> hashSet = new HashSet<>();

        for(Integer n: nums)
            hashSet.add(n);

        for(Integer i = 1; i<= length ; i++){

            if(!hashSet.contains(i)){
                list.add(i);
            }

        }


         */

        return list;

    }

}
