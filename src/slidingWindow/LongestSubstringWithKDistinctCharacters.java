package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static int findLongestSubstringWithKDistinctCharacters(String str, int k){
        int maxLength = 0;
        int windowStart = 0;

        Map<Character,Integer> characterFreqMap = new HashMap<>();

        for(int windowEnd =0; windowEnd < str.length(); windowEnd++){

            char rightChar = str.charAt(windowEnd);

            characterFreqMap.put(rightChar,characterFreqMap.getOrDefault(rightChar,0)+1);

            while(characterFreqMap.size()>k){
                char leftChar = str.charAt(windowStart);
                characterFreqMap.put(leftChar,characterFreqMap.get(leftChar)-1);

                if(characterFreqMap.get(leftChar) ==0){
                    characterFreqMap.remove(leftChar);
                }
                windowStart++;

            }


          maxLength = Math.max(maxLength,(windowEnd-windowStart) +1);

        }

      return maxLength;
    }


    public static void main(String[] args) {

        String inputString = "aaahhibc";
        int k = 2 ; // distinct characters

        System.out.println(findLongestSubstringWithKDistinctCharacters(inputString,k));


        /// some test cases
    //    console.assert(longestSubstringWithKDistinctCharacters('aaahhibc'.split(''), 2) === 5, 'aaahhibc');
   //     console.assert(longestSubstringWithKDistinctCharacters('aaabc'.split(''), 3) === 5, 'aaabc');
// only one letter in string
    //    console.assert(longestSubstringWithKDistinctCharacters('aaa'.split(''), 2) === -Infinity, 'aaa');
    }
}
