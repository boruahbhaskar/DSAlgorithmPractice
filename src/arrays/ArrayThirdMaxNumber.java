package arrays;/*
Given integer array nums, return the third maximum number in this array.
If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.

Example 2:

Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Can you find an O(n) solution
 */

public class ArrayThirdMaxNumber {

    public static void main(String[] args) {

        int[] nums = {3,2,1};

        System.out.println(thirdMax(nums));


    }

    public static int thirdMax(int[] nums) {

       Integer max = null; //Maximum number
       Integer maxSecond = null; // Second Maximum Number
       Integer maxThird = null;  // Third Maximum number

       for(Integer num : nums){

           // If number already checked then we can skip the number which will help if there is duplicate number
           if( num.equals(max) || num.equals(maxSecond)  || num.equals(maxThird)){
               continue;
           }

           if(max == null || num > max){
               maxThird = maxSecond;
               maxSecond = max;
               max = num;
           }else if(maxSecond == null || num > maxSecond){
               maxThird = maxSecond;
               maxSecond = num;
           }else if(maxThird == null || num > maxThird){

               maxThird = num;
           }

       }

       // If there is only 2 distinct element in the array then it will return the max number
       if (maxThird == null) {
           return max;
       }
       return maxThird;


     }

    }

    /*
    public static int thirdMax(int[] nums) {

        Arrays.sort(nums);

       int len =  removeDuplicates(nums);

        int index =len >= 3 ? len-3 : len-1 ;

       // System.out.println("index "+index);
       // for(int n:nums)
         //  System.out.println(n);

        return nums[index];

    }



    public static int removeDuplicates(int[] nums) {

         int length = nums.length;

         int[] tempArray = new int[length];

         int j = 0;

         for (int i = 0; i< length -1; i++){
             //int currentElement = nums[i];
             if(nums[i] != nums[i+1])
             {
                 tempArray[j++] = nums[i];
             }

         }
        tempArray[j++] =  nums[length-1];

         for(int i =0; i < j; i++){
             nums[i] = tempArray[i];
         }

        return j;

    }
    }
     */


