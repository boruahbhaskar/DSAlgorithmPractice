package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

**** Tabulation Recipe ****

1. Visualize the problem as a table
2. Size the table based on the inputs
3. Initialize the table with some values
4. Seed the trivial answer into the table
5. Iterate through the table
6. Fill further positions based on the current position

Write a methode bestSum (int targetSum, int[] numbers) that takes in a targetSum and an array of numbers as arguments

The method should return an array containing shortest combination of elements that add up to exactly the targetSum.

If there is no combination that add up to the targetSum, then return null.



m = target sum
n = numbers.length

Time - O(n^m * m )
Space - o(m^2)


 */
public class BestSumTabulation {

    public int[] bestSumT(int targetSum, int[] numbers) {

        // Sanity check
        if (targetSum == 0)
            return null;

        List<List<Integer>> table = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<>();

        table.add(lst);
        for (int i = 1; i <= targetSum; i++)
            table.add(null);


        for (int i = 0; i < targetSum; i++) {

            if (table.get(i) != null) {

                for (int num : numbers) {
                    int targetIndex = i + num;

                    if (targetIndex <= targetSum) {

                        // **** initialize this list (if needed) ****
                        lst = table.get(targetIndex);
                        if (lst == null)
                            lst = new ArrayList<>();

                        // **** copy all elements from table[i] to table[ndx] ****
                        List<Integer> src = table.get(i);
                        List<Integer> dest = table.get(targetIndex);

                        dest = new ArrayList<Integer>();
                        dest.addAll(src);

                        // **** add current element to dst list ****
                        dest.add(num);

                        // **** replace list at ndx (if shorter) ****
                        if (table.get(targetIndex) == null || dest.size() < table.get(targetIndex).size()) {
                            table.remove(targetIndex);
                            table.add(targetIndex, dest);
                        }


                    }


                }

            }
        }


        if (table.get(targetSum) == null)
            return null;
        else
            return table.get(targetSum).stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        BestSumTabulation bst = new BestSumTabulation();

        int[] numbers = {4, 3, 5, 7};
        int targetSum = 7;

        System.out.println("Possible combination of numbers for target sum : " + Arrays.toString(bst.bestSumT(targetSum, numbers)));
    }
}
