package arrays;/*
* Given a fixed length array arr of integers, duplicate each occurrence of zero,
* shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place, do not return anything from your function.
*
1 <= arr.length <= 10000
0 <= arr[i] <= 9
*
* Example 1 :
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
*
* Example 2:
Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
*
* */

import java.util.Arrays;

public class ArrayDuplicateZero {

    public static void main(String[] args) {
        int[] arr = {1,2,3,0};//{1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(arr));
        ArrayDuplicateZero arrayDuplicateZero = new ArrayDuplicateZero();
        arrayDuplicateZero.getDuplicateZero(arr);
    }

    public void getDuplicateZero(int[] arr){

        int length = arr.length;
        int indexZero = 0;
        for(int i= 0; i<length;i++){

            if(arr[i]==0 && arr[i-1]!=0)
                insertDuplicateZero(arr,i);
           // break;
        }

        System.out.println(Arrays.toString(arr));

    }

    public int[] insertDuplicateZero(int arr[], int k){

       // System.out.println("array length"+arr.length);

        for(int j = arr.length-2; j>=k ;j--){
        //    System.out.println("j --"+j);
            arr[j+1] =arr[j];
        }
        arr[k] = 0;


      //  System.out.println("insertDuplicateZero"+Arrays.toString(arr));

        return arr;
    }


}
