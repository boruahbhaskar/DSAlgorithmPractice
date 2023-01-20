package dynamicProgramming;


import java.util.ArrayList;
import java.util.Arrays;

/*
        Write a method allConstructWord(target,wordBank) that accepts a target string and an array of strings

        The method should return a 2D array containing all of the ways that  the 'target' can be constructed by concatenating elements of the
        'wordBank' array. Each element of the 2D array should represent one combination that construct the target

        you may reuse element of the array as many times as needed

        m - target.length
        n = wordBank.length

        Time - O(n^m )
        Space - O(n^m)


        **** Tabulation Recipe ****

1. Visualize the problem as a table (determine data type)
2. Size the table based on the inputs
3. Initialize the table with some values (determine base case)
4. Seed the trivial answer into the table
5. Iterate through the table
6. Fill further positions based on the current position

**** Dynamic Programming Approach ****

1. Notice any overlapping subproblems
2. Decide what is the trivially smallest input (i.e., base case)
3. Think recursively to use Memoization
4. Think iteratively to use Tabulation
5. Define a strategy first!!!



        */
public class AllConstructWordTabulation {

    public String[][] allConstructWordT(String target, String[] wordBank){


        // **** sanity check(s) [[]]****
        if (target.length() == 0) {
            String[][] ans = new String[1][1];
            ans[0] = new String[] {""};
            return ans;
        }

        // **** create and initialize table ****
        ArrayList<ArrayList<ArrayList<String>>> table = new ArrayList<ArrayList<ArrayList<String>>>();
        for (int i = 0; i < target.length() + 1; i++)
            table.add(i, new ArrayList<ArrayList<String>>());
        ArrayList<ArrayList<String>> lol = table.get(0);
        lol.add(new ArrayList<String>());

        // ???? ????
      //  System.out.println("<<<  table: " + table.toString() + " size: " + table.size());

        // **** iterate through the table ****
        for (int i = 0; i < table.size(); i++) {

            // **** get to the current list of lists ****
            lol = table.get(i);

            // **** if blank entry (skip) ****
            if (lol.size() == 0)
                continue;

            // **** iterate through the word bank ****
            for (int j = 0; j < wordBank.length; j++) {

                // **** for ease of use ****
                String word = wordBank[j];

                // **** generate index ****
                int ndx = i + word.length();

                // **** if we can NOT extract prefix from target (skip) ****
                if (ndx > target.length())
                    continue;

                // **** extract prefix from the target ****
                String prefix = target.substring(i, ndx);

                // **** if word and prefix do NOT match (skip) ****
                if (!word.equals(prefix))
                    continue;

                // **** source list of lists ****
                ArrayList<ArrayList<String>> src = table.get(i);

                // **** destination list of lists ****
                ArrayList<ArrayList<String>> dst = table.get(ndx);

                // **** copy source list(s) to this table entry ****
                for (int k = 0; k < src.size(); k++) {

                    // **** source list to copy ****
                    ArrayList<String> srcLst = src.get(k);

                    // **** destination list ****
                    ArrayList<String> dstLst = new ArrayList<String>();

                    // **** add source to destination list ****
                    dstLst.addAll(srcLst);

                    // **** append word to destination list ****
                    dstLst.add(word);

                    // **** add destination list to destinaltion list of lists ****
                    dst.add(dstLst);
                }

                // ???? ????
              //  System.out.println("<<<  table: " + table.toString() + " size: " + table.size());
            }
        }

        // **** get last list of lists in table ****
        ArrayList<ArrayList<String>> ansLst = table.get(target.length());

        // **** 2D array to hold answer ****
        String[][] ans = new String[ansLst.size()][];

        // **** traverse the list of lists ****
        for (int i = 0; i < ansLst.size(); i++) {

            // **** get this array list ****
            ArrayList<String> al = ansLst.get(i);

            // **** generate array from array list ****
            String[] arr = al.toArray(new String[0]);

            // **** insert array into 2D array ****
            ans[i] = arr;
        }

        // **** return 2D array ****
        return ans;

    }

    public static void main(String[] args) {

        AllConstructWordTabulation acWT = new AllConstructWordTabulation();


        String target ="abcdef";
        String[] wordBank = new String[]{"ab","abc","cd","def","abcd"} ;
        System.out.println("All construction word : "+Arrays.deepToString(acWT.allConstructWordT(target,wordBank)));

    }
}
