package arrays;/*
* Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

* Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
*
Input: arr = [2,1]
Output: false
*
*
Input: arr = [3,5,5]
Output: false
*
*
Input: arr = [0,3,2,1]
Output: true

* Intuition behind solution: Iterate through the array while elements are increasing. If your pointer is still 0 (there is no increasing sequence) or if your pointer
* is at the end of the array (entire array is increasing) return false. Otherwise,
* continue iterating through the remainder of the array ensuring it is strictly decreasing, if at any point it's not, return false. If you reach the end of the array, return true.
*
*
* */

public class ArrayValidMountainArray {
    public static void main(String[] args) {
     int[] arr = {0,3,2,1};

    System.out.println(validMountainArray(arr));

    }

    public static boolean validMountainArray(int[] arr) {

        if( arr == null || arr.length<3)
            return false;

        int i = 0;

          // increasing validation
        // i+1 < arr.length  -  will check for array over flow
        while( i < arr.length && i+1 < arr.length  && arr[i] < arr[i + 1]){
            i++;
        }

        // if i is decreasing at the begining or  always increasing till end of the array then return false
        if( i == 0 || i+1 >= arr.length){

            return false;
        }

        //Decreasing validation

        while(i < arr.length && i+1 < arr.length){

            //adding i++ to avoid any infinity loop
            if(arr[i] <= arr[i++ + 1]){

                return false;
            }

        }

    return true;

    }

}
