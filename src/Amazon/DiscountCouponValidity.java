package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Problem Description:
Determine whether a given discount coupon is valid or not
The validity of a coupon is determined by:
An empty discount coupon is valid
if a coupon A is valid, then a coupon C made by adding one character d to both the beginning of A and the end of A is also valid ( C = dAd is valid)
if two coupons A & B are valid, then the concatenation of B & A is also valid ( AB & BA are both valid )
Given n coupons, all lower case english characters, determine if a coupon is valid or not. Valid is denoted by 1, invalid by 0
coupons = ['abba', 'abca']
checking abba
An empty coupon is valid
Under the second rule, the same character can be added to the beginning and end of a valid coupon. Add b to get bb as valid
Using the same rule, add a to the beginning and end of 'bb' to get 'abba'.
it is valid
check 'abca'
using rule 2, the 'a' added to the beginning and end of bc does not change its validity
the remaining string bc is not valid. there is no rule allowing the addition of different chars to the ends of the string
it is invalid
coupons = ['daabbd', 'abc']
aa & bb are valid therefore aabb is valid
adding d to front and end makes it daabbd valid
[1, 0]
coupons = ['acac']
Invalid


 */
public class DiscountCouponValidity {

    public static List<Integer> findValidDiscountCoupons(List<String> discounts){
       List<Integer> validCouponList = new ArrayList<>();
       boolean isValid ; //0 is invalid ;   1 is valid

       for(String str:discounts){

          // System.out.println(str);
           isValid =  checkValidCoupon(str,0,str.length()-1);

           System.out.println("Stringg : "+str+" valid ? :"+isValid);

           if(isValid){
               validCouponList.add(1);
           }else{
               validCouponList.add(0);
           }
       }

        return validCouponList;
    }

    public static boolean isValid(String discount){
        if(discount.length()%2==1)
            return false;
        Stack<Character> st = new Stack<>();

        for(char c : discount.toCharArray()){
            //pop the character when stack is not empty and top element is equal to current character
            //else push to stack
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
            }
            else{
                st.push(c);
            }
        }

        return st.isEmpty();

    }

    public static boolean checkValidCoupon(String str,int left,int right){

        //Empty String

        if(left==right)
            return true;

        if(str.equals(""))
            return true;

        if(left > right)
            return false;

        if(str.charAt(left) == str.charAt(right)){
            System.out.println("Substring");
            boolean rule1 = checkValidCoupon(str,left+1,right-1);
            if (rule1)
                return true;

        }

        // Checking if even length string
       // if((right-left+1)%2 !=0)
         //   return false;


        if(str.charAt(left) == str.charAt(right)){
            System.out.println("Inside");
            boolean rule1 = checkValidCoupon(str,left+1,right-1);
            if (rule1)
                return true;

        }else {

            System.out.println("Left " + left);
            System.out.println("Right " + right);

            int mid = left + (right - left) / 2;

            System.out.println("mid : " + mid);
            boolean rule2 = checkValidCoupon(str, left + 1, mid);
            System.out.println("rule2 :" + rule2);
            boolean rule3 = checkValidCoupon(str, mid + 1, right - 1);
            System.out.println("rule3 :" + rule3);
            System.out.println(rule2 && rule3);
            return rule2 && rule3;
        }

        return false;
    }

    public static void main(String[] args) {

        List<String> coupons = new ArrayList<>();

        coupons.add("abba");
       // coupons.add("aba");
       // coupons.add("abca");
        //coupons.add("daabbd");
        //coupons.add("abc");
        //coupons.add("acac");

        System.out.println(findValidDiscountCoupons(coupons));

    }
}
