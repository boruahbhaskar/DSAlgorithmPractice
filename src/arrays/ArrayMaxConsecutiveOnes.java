package arrays;

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Example 1 -
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.

Example 2 -

Input: nums = [1,0,1,1,0,1]
Output: 2

* */
public class ArrayMaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] nums = {1,0,1,1,0,1};
        ArrayMaxConsecutiveOnes arrayMaxConsecutiveOnes = new ArrayMaxConsecutiveOnes();

        System.out.println("Output :"+arrayMaxConsecutiveOnes.getMaxConsecutiveOnes(nums));



    }

    public int getMaxConsecutiveOnes(int[] nums){

        if(nums.length ==0 || nums == null )
        return 0;


        int currentCount = 0;
        int maxCount = 0;

        /*
        for (int i= 0 ; i < nums.length; i++){

            if(nums[i] ==1)
                currentCount++;
            else
                currentCount = 0;

            maxCount = Math.max(currentCount,maxCount);

        }




         */

        for (int num : nums)
            maxCount = Math.max(maxCount,currentCount = num == 0 ? 0 : currentCount+1);

        return maxCount;

    }


}
