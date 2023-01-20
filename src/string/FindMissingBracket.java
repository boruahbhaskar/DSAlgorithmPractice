package string;

public class FindMissingBracket {

    public int findMissingBracket(String s){

        int balanceCount = 0;

        int bracket = 0;
        int rightBracket = 0;

        int sqrBracket = 0;
        int rightSqrBracket = 0;

        int quesCount = 0;



        if(isBalanced(s)){
            System.out.println("This is a balanced tree");

            for(int i=0; i < s.length(); i++){

                if(s.charAt(i) =='(')
                    bracket++;
                else if(s.charAt(i) ==')')
                    bracket--;
                else if(s.charAt(i) =='[')
                    sqrBracket++;
                else if (s.charAt(i) ==']')
                    sqrBracket--;
                else if (s.charAt(i) =='?')
                    quesCount++;

                    if((bracket == 0) && (sqrBracket == 0) ) {
                        balanceCount++;

                    }

                    if (bracket != 0 && (quesCount > 0)){
                        quesCount = bracket -quesCount;
                        bracket = 0;
                    }

                    if ( sqrBracket!= 0 && ( quesCount > 0)){
                        quesCount = sqrBracket -quesCount;
                        sqrBracket =0;
                    }

            }


            return balanceCount;
        }else{
            System.out.println("This is not a balanced tree");
            return 0;
        }


    }

    static  boolean isBalanced(String s){

        long  bracketCountL = s.chars().filter(ch -> ch =='(').count();
        long sqrBracketCountL = s.chars().filter(ch -> ch =='[').count();
        long bracketCountR = s.chars().filter(ch -> ch ==')').count();
        long sqrBracketCountR = s.chars().filter(ch -> ch ==']').count();
        long noOfQuestion = s.chars().filter(ch -> ch =='?').count();

       // System.out.println("bracketCountL : " + bracketCountL + " bracketCountR : " + bracketCountR +" sqrBracketCountL : "
          //      + sqrBracketCountL + " sqrBracketCountR : " +sqrBracketCountR +" noOfQuestion : " + noOfQuestion);


      //  System.out.println(bracketCountL + bracketCountR + sqrBracketCountL + sqrBracketCountR + noOfQuestion);


            if((bracketCountL + bracketCountR + sqrBracketCountL + sqrBracketCountR + noOfQuestion) %2 == 0)
           // System.out.println("3");
            return  true;


            return false;
    }



    public static void main(String[] args) {

        FindMissingBracket fb = new FindMissingBracket();

        System.out.println(fb.findMissingBracket("(?][)("));



    }
}
