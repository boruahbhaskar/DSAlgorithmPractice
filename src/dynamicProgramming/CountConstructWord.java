package dynamicProgramming;

/*
Write a method countConstructWord(target,wordBank) that accepts a target string and an array of strings

The method should return number of ways the 'target' can be constructed by concatenating elements of the
'wordBank' array.

you may reuse element of the array as many times as needed

Brute Force -

m - target.length
n = wordBank.length

Time - O(n^m*m )
Space - O(m)

Memoization -

Time - O(n*m^2)
Space - O(m^2)


 */

import java.util.HashMap;

public class CountConstructWord {

    private HashMap<String,Integer> map = new HashMap<>();

    public int countConstructWord(String target, String[] wordBank){

        if(map.containsKey(target)){
            map.get(target);
        }

        if (target.equals(""))
             return 1;  // if it reaches empty string then at least 1 way to get the target word

        int totalCount = 0;

        for(String word:wordBank){

            if(target.indexOf(word) == 0){
                int numWaysForRest = countConstructWord( target.substring(word.length()),wordBank);
                totalCount += numWaysForRest;
            }

        }

        map.put(target,totalCount);

        return totalCount;
    }

    public static void main(String[] args) {

        CountConstructWord ccw = new CountConstructWord();

        String target ="abcdef";
        String[] wordBank = new String[]{"ab","abc","cd","def","abcd"} ;
        System.out.println(ccw.countConstructWord(target,wordBank));

        String target1 ="skateboard";
        String[] wordBank1 = new String[]{"bo","rd","ate","t","ska","sk","boar"} ;
        System.out.println(ccw.countConstructWord(target1,wordBank1 ));
    }
}
