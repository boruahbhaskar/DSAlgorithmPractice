package dynamicProgramming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 *
 */
public class AllConstructWord {


    /**
     * Write a function `allConstruct(String target, String[] wordBank)`
     * that accepts a target string and an array of strings.
     *
     * The function should return a 2D array containing all of the ways
     * that the `target` can be constructed by concatenating elements of
     * the `wordBank` array. Each element of the 2D array should represent
     * one combination that constructs the `target`.
     *
     * You may reuse elements of `wordBank` as many times as needed.
     *
     * Recursive call without memoization.
     *
     * m = =target.length
     * n = wordBank.length
     *
     * Time: O(n^m)  Space: O(m)
     */
    static List<List<String>> allConstruct(String target, String[] wordBank) {

        // **** base case(s)****
        if (target.length() == 0) return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        // **** initialization ****
        List<List<String>> result = new ArrayList<>();

        // **** loop through the word bank making a recursive call (if needed) ****
        for (String word : wordBank) {

            // **** recursive call (if word is a prefix of target) ****
            if (target.indexOf(word) == 0) {

                // **** generate suffix for target ****
                String suffix = target.substring(word.length());

                // **** make recursive call ****
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);

                // **** ****
                List<List<String>> targetWays = new ArrayList<>();

                // **** add prefix to the head of each list ****
                for (int i = 0; i < suffixWays.size(); i++) {

                    // **** create a new list ****
                    List<String> tmp = new ArrayList<>(suffixWays.get(i));

                    // **** add preffix to this list ****
                    tmp.add(0, word);

                    // **** add this list to this list of lists ****
                    targetWays.add(tmp);
                }

                // **** add lists to result ****
                for (int i = 0; i < targetWays.size(); i++)
                    result.add(new ArrayList<>(targetWays.get(i)));
            }
        }

        // **** return all possible combinations ****
        return result;
    }


    /**
     * Write a function `allConstruct(String target, String[] wordBank)`
     * that accepts a target string and an array of strings.
     *
     * The function should return a 2D array containing all of the ways
     * that the `target` can be constructed by concatenating elements of
     * the `wordBank` array. Each element of the 2D array should represent
     * one combination that constructs the `target`.
     *
     * You may reuse elements of `wordBank` as many times as needed.
     *
     * Recursive call with memoization.
     *
     * m = =target.length
     * n = wordBank.length
     *
     * Time: O(n^m)  Space: O(m)
     */
    static List<List<String>> allConstructMemo(String target, String[] wordBank) {

        // **** sanity check(s) ****
        if (target.length() == 0) return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        // **** initialization ****
        HashMap<String, List<List<String>>> memo = new HashMap<>();

        // **** recursive call ****
        List<List<String>> ans = allConstructMemo(target, wordBank, memo);

        // ???? ????
        System.out.println("<<< memo: " + memo.toString());

        // **** return ans ****
        return ans;
    }


    /**
     * Recursive call with memoization.
     */
    static List<List<String>> allConstructMemo( String target,
                                                String[] wordBank,
                                                HashMap<String, List<List<String>>> memo) {

        // **** base case(s)****
        if (memo.containsKey(target)) return memo.get(target);
        if (target.length() == 0) return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        // **** initialization ****
        List<List<String>> result = new ArrayList<>();

        // **** loop through the word bank making a recursive call (if needed) ****
        for (String word : wordBank) {

            // **** recursive call (if word is a prefix of target) ****
            if (target.indexOf(word) == 0) {

                // **** generate suffix for target ****
                String suffix = target.substring(word.length());

                // **** make recursive call ****
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);

                // **** ****
                List<List<String>> targetWays = new ArrayList<>();

                // **** add prefix to the head of each list ****
                for (int i = 0; i < suffixWays.size(); i++) {

                    // **** create a new list ****
                    List<String> tmp = new ArrayList<>(suffixWays.get(i));

                    // **** add preffix to this list ****
                    tmp.add(0, word);

                    // **** add this list to this list of lists ****
                    targetWays.add(tmp);
                }

                // **** add lists to result ****
                for (int i = 0; i < targetWays.size(); i++)
                    result.add(new ArrayList<>(targetWays.get(i)));
            }
        }

        // **** save the key-value pair ****
        memo.put(target, result);

        // **** return all possible combinations ****
        return result;
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** initialization ****
        long start  = 0;
        long end    = 0;
        List<List<String>> ans = null;

        // **** open a buffered reader ****
      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the target string ****
        //String target = br.readLine().trim();

        // **** read the readBank String[] ****
      //  String[] wordBank = br.readLine().trim().split(",");

        // **** close the buffered reader ****
       // br.close();

        // ???? ????

        String target = "abcdef";
        String[] wordBank = {"ab","abc","cd","def","abcd"} ;

        System.out.println("main <<< target ==>" + target + "<==");
        System.out.println("main <<< wordBank: " + Arrays.toString(wordBank));


        // ???? ????
        List<List<String>> ll = new ArrayList<>(Arrays.asList(new ArrayList<>()));
        System.out.println("main <<< ll: " + ll.toString());

        // ???? ????
        ll = new ArrayList<List<String>>();
        // System.out.println("main <<< ll: " + ll.toString());

        // ???? ????
        List<ArrayList<String>> lol = new ArrayList<ArrayList<String>>();
        // System.out.println("main <<< lol: " + lol.toString());

        // ???? ????
        ArrayList<ArrayList<String>> lofl = new ArrayList<ArrayList<String>>();
        // System.out.println("main <<< lofl: " + lofl.toString());


        // **** generate the list for the specified target and word bank ****
        start = System.currentTimeMillis();
        ans = allConstruct(target, wordBank);
        end = System.currentTimeMillis();

        // **** display answer ****
        System.out.println("main <<< allConstruct: " + ans.toString());
        System.out.println("main <<< time: " + (end - start) + " ms.");

        // **** generate the list for the specified target and word bank ****
        start = System.currentTimeMillis();
        ans = allConstructMemo(target, wordBank);
        end = System.currentTimeMillis();

        // **** display answer ****
        System.out.println("main <<< allConstructMemo: " + ans.toString());
        System.out.println("main <<< time: " + (end - start) + " ms.");
    }
}