package arrays;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * Example 1 -
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 *
 * Example 2
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */

public class ArrayNumberWithEvenNumberDigit {



    public static void main(String[] args) {

        int[] nums = {12,345,2,6,7896};//,87,765489,90,43,66590};

        ArrayNumberWithEvenNumberDigit arrayNumberWithEvenNumberDigit = new ArrayNumberWithEvenNumberDigit();
        System.out.print("Output: "+arrayNumberWithEvenNumberDigit.getEvenNumberOfDigit(nums));
    }



    public int getEvenNumberOfDigit(int[] nums){

        int noEvenDigit = 0;


        for(int n : nums)
        {
            /*
            Easy solution by converting integer to string

            String str = Integer.toString(n);
            if(str.length()%2==0)
                noEvenDigit++;
             */

           // System.out.println(n+" length of digit "+findLengthOfDigit(n));

            if(findLengthOfDigit(n)%2==0)
                noEvenDigit++;

        }

        return  noEvenDigit;
    }

    public int findLengthOfDigit(int num){

       if(num/10 == 0)
           return 1;
       else
           return 1 + findLengthOfDigit(num/10);

        /*
         int lengthOfNumber = 0;
        while(num != 0){

            num = num/10;
            ++lengthOfNumber;
           // System.out.println( num+" num "+lengthOfNumber);

        }
        return  lengthOfNumber;
         */

    }

}
