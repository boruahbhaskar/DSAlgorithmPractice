package dynamicProgramming;


/*
Write a method canConstruct(target,wordBank) that accepts a target string and an array of strings

The method should return a boolean indicating whether or not the 'target' can be constructed by concatenating elements of the
'wordBank' array.

you may reuse element of the array as many times as needed


m - target.length
n = wordBank.length

Time - O(m^2 * n)
Space - O(m)


 */
public class CanConstructWordTabulation {

    public boolean canConstructWordT(String target, String[] wordBank){

        //Sanity check

        if(target.equals(""))
            return false;

        // Initialization of the table
        boolean[] table= new boolean[target.length()+1];

        table[0] = true;

        for(int i = 1; i < table.length; i++)
            table[i] = false;

       // System.out.println(Arrays.toString(table));

        for(int i = 0; i < target.length();i++){

            // Proceed to the next only if current index at the table is true
            if(table[i]){
               // System.out.println(i+" "+table[i]);

                for(String word:wordBank){

                    int indexLength = i + word.length();

                    if(indexLength <= target.length())
                    {
                        if(target.substring(i,indexLength).equals(word))
                            table[indexLength] = true;

                    }

                }

            }

        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        CanConstructWordTabulation ccwt = new CanConstructWordTabulation();

        String target ="abcdef";
        String[] wordBank = new String[]{"ab","abc","cd","def","abcd"} ;
        System.out.println(ccwt.canConstructWordT(target,wordBank));

        String target1 ="skateboard";
        String[] wordBank1 = new String[]{"bo","rd","ate","t","ska","sk","boar"} ;
        System.out.println(ccwt.canConstructWordT(target1,wordBank1 ));

    }
}
