package slidingWindow;
/*
  Find the smallest subarray of a given sum

  input
   array {4,2,2,7,8,1,2,8,10}
   targetSum = 8

   output 1 i.e. 8 at the 4th index

 */

public class SmallestSubArrayGivenSum {

    public static int smallestSubArray(int targetSum, int[] arr){

         int minWindowSize = Integer.MAX_VALUE;
         int currentWindowSum = 0;

         int windowStart = 0;

         for(int windowEnd = 0 ; windowEnd < arr.length ; windowEnd++){

             currentWindowSum += arr[windowEnd];

             while(currentWindowSum >= targetSum){
                   minWindowSize = Math.min(minWindowSize,windowEnd-windowStart+1);
                   currentWindowSum -= arr[windowStart];
                    windowStart++;

             }

         }


        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,2,7,8,1,2,8,10};
        int targetSum = 8;

        System.out.println(smallestSubArray(targetSum,arr));
    }
}
