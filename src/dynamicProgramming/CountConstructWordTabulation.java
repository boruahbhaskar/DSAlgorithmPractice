package dynamicProgramming;

/*
Write a method countConstructWord(target,wordBank) that accepts a target string and an array of strings

The method should return number of ways the 'target' can be constructed by concatenating elements of the
'wordBank' array.

you may reuse element of the array as many times as needed

m - target.length
n = wordBank.length


Time - O(n*m^2)
Space - O(m)


 */


public class CountConstructWordTabulation {

    public int countConstructWordT(String target, String[] wordBank){

        int[] table = new int[target.length()+1];

        table[0] =1;

       // System.out.println(Arrays.toString(table));

        for(int i=0; i < target.length(); i++){

            if(table[i] ==1){

                for(String word :wordBank){
                    int targetIndex = i + word.length();

                    if(targetIndex <= target.length()){

                        if(target.substring(i,targetIndex).equals(word) )
                                table[targetIndex] += table[i];
                    }

                }


            }

        }


        return table[target.length()];
    }

    public static void main(String[] args) {
        CountConstructWordTabulation countCWT = new CountConstructWordTabulation();

        String target ="abcdef";
        String[] wordBank = new String[]{"ab","abc","cd","def","abcd"} ;
        System.out.println(countCWT.countConstructWordT(target,wordBank));

        String target1 ="skateboard";
        String[] wordBank1 = new String[]{"bo","rd","ate","t","ska","sk","boar"} ;
        System.out.println(countCWT.countConstructWordT(target1,wordBank1 ));
    }

}
