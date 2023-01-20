package dynamicProgramming;

import java.util.HashMap;

/*
Write a method canConstruct(target,wordBank) that accepts a target string and an array of strings

The method should return a boolean indicating whether or not the 'target' can be constructed by concatenating elements of the
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
public class CanConstructWord {
    private HashMap<String,Boolean> map = new HashMap<>();

    public boolean canConstruct(String  target ,String[] wordBank){
        if(map.containsKey(target)){
            map.get(target);
        }

        if (target.equals("")) // if there is an emptry string in the target , it returns true as we can always construct an empty string
            return true;

        for(String word : wordBank){
           if(target.indexOf(word) == 0){
                 // String suffix  = target.substring(word.length());
               if(canConstruct(target.substring(word.length()),wordBank))
               {
                   map.put(target,true);
                   return true;
               }

           }

        }
        map.put(target,false);
        return false;
    }

    public static void main(String[] args) {

        CanConstructWord cc = new CanConstructWord();
        String target ="abcdef";
        String[] wordBank = new String[]{"ab","abc","cd","def","abcd"} ;
        System.out.println(cc.canConstruct(target,wordBank));

        String target1 ="skateboard";
        String[] wordBank1 = new String[]{"bo","rd","ate","t","ska","sk","boar"} ;
        System.out.println(cc.canConstruct(target1,wordBank1 ));

    }
}
