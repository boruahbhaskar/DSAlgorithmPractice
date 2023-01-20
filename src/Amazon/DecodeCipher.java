package Amazon;

/*

Observations
s.length() = rows * cols
s[i] and s[i+cols+1] are adjacent characters in original text.
For example,
"cipher" to "ch ie pr", cols = 3
s[0] = 'c'
s[4] = 'i'
s[8] = 'p'
Explanation
For every character in the first row in the matrix,
find it's adjacent characters in diagonal position in the matrix.
Read all these chara one by one,
return the trimmed result string.


Complexity
Time O(n)
Space O(n)

 */
public class DecodeCipher {

    public static void main(String[] args) {

        DecodeCipher dc = new DecodeCipher();

     System.out.println(dc.decodeCipher("mnes__ya_____mi",3));

    }

    public String decodeCipher(String encodedString , int rows){

        int n = encodedString.length();

        int cols = n/rows ;

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < cols ; i++){

            for(int j = i ; j < n ; j+= cols +1){

                if(encodedString.charAt(j) =='_'){
                    sb.append(' ');
                }else{
                    sb.append(encodedString.charAt(j));
                }

            }

        }

        while( sb.length() > 0 && sb.charAt(sb.length() - 1) ==' ' )
             sb.setLength(sb.length() -1);

        return sb.toString();

    }

}
