package slidingWindow;

/*
    Find the max sum sub array of fixed size K

   Input :
   array = {4,2,1,7,8,1,2,8,1,0}
   k = 3

   Output = 16

   Space O(n)
   Time O(n)

 */

public class MaxSumSubArray {

    public static int getMaxSumSubArray(int[] arr, int k){

        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i=0; i< arr.length; i++){

            currentSum += arr[i];

            if(i >= (k-1) ){
              // int x = k-1;
             //   System.out.println("i "+i);
             //   System.out.println("k-1 "+x);

                maxValue = Math.max(maxValue,currentSum);

                currentSum = currentSum - arr[i-(k-1)];

            }

        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,7,8,1,2,8,1,0};
        int k = 3;

        System.out.println(getMaxSumSubArray(arr,k));
    }
}
