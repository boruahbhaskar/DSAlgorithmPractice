package arrays;/*
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height.
Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100

Example 1 -
            Input: heights = [1,1,4,2,1,3]
            Output: 3
            Explanation:
            heights:  [1,1,4,2,1,3]
            expected: [1,1,1,2,3,4]
            Indices 2, 4, and 5 do not match.

Example 2 -

            Input: heights = [5,1,2,3,4]
            Output: 5
            Explanation:
            heights:  [5,1,2,3,4]
            expected: [1,2,3,4,5]
            All indices do not match.


Example 3 -

            Input: heights = [1,2,3,4,5]
            Output: 0
            Explanation:
            heights:  [1,2,3,4,5]
            expected: [1,2,3,4,5]
            All indices match.


 */

public class ArrayHeightChecker {

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3}; //{1,2,3,4,5};  //{5,1,2,3,4} ; //
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        //Counting Sort

        int[] heightIndexCount = new int[101];

        //assigning the count of heights index wise
        for(int h : heights ){
            heightIndexCount[h]++;
        }

        int result = 0;
        int curHeight = 0;

        for(int i = 0 ; i < heights.length; i++){

            while(heightIndexCount[curHeight]==0){
                curHeight++;
            }

            if(curHeight != heights[i]){
                result++;
            }

            heightIndexCount[curHeight]--;

        }



       /* int[] expected =  new int[heights.length];

        for(int i=0; i< heights.length; i++){
            expected[i] =heights[i];
        }

        Arrays.sort(expected);

        for(int exp : expected)
         System.out.print(exp+" ");

        int h = 0;


        for(int j=0 ; j < heights.length ; j++ )
        {
            if(expected[j] != heights[j]){
                h++;
            }

        }

        System.out.println();
        return h;
        */
     //   System.out.println("Afterrrrr");
        return result;
    }


}
