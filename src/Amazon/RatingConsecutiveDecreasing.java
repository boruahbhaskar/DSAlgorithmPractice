package Amazon;

import java.util.ArrayList;
import java.util.List;

/*

Problem Description:
You are given an array of ratings for n days. Find the number of groups that can be formed consisting of 1 or more consecutive days such that the ratings continously decreases over the days.
The rating is consecutively decreasing if it has the form r, r - 1, r - 2 ... and so on, where r is the rating on the first day of the group. Two groups are considered different if they contain the ratings of different consecutive days.
Example
ratings = [4,3,5,4,3] answer = 9
there are 9 periods in which the rating is consecutively decreasing
5 one day periods: [4],[3],[5],[4],[3]
3 two day periods: [4,3], [5,4], [4, 3]
1 three day period: [5, 4, 3]

ratings = [2, 1, 3] answer = 4
groups are [2],[1], [3], [2, 1]

ratings = [4,2,3,1] answer = 4
groups are [4], [2], [3], [1] are the only groups

############################################################################

Time O(n) Space O(1)

Check if rating is the first day or difference between 2 days is 1
if yes increament the current by 1;
if no  reset the current to 1 and move to next iteration

update countRating by adding the current data for each iteration

return countRating


 */


public class RatingConsecutiveDecreasing {

    public static long countDecreaseRating(List<Integer> ratings){

      // long count = 0;
       long current = 0;

       long countRating = 0;

       for(int i=0; i < ratings.size(); i++){

           if(i==0 || (ratings.get(i-1) - ratings.get(i)==1)){
               current++;
           }else{
              // count += getTriangleNumber(current);
               current = 1;
           }

          // System.out.println(ratings.get(i)+" --i -- "+i+" current : "+current+" count: "+count);
           countRating += current;
       }

         // System.out.println("x "+x);
        //System.out.println(" Final current : "+current+" count: "+count);

       // count += getTriangleNumber(current);

       return countRating;
    }

    public static long getTriangleNumber(long n){

        long sum = 0;

        while( n!=0){
            sum += n;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {

        List<Integer> ratings = new ArrayList<>();

       ratings.add(4);
        ratings.add(3);
        ratings.add(5);
        ratings.add(4);
        ratings.add(3);



       /*
        ratings.add(2);
        ratings.add(1);
        ratings.add(3);

        */

       /* ratings.add(4);
        ratings.add(2);
        ratings.add(3);
        ratings.add(1);

        */


        System.out.println(countDecreaseRating(ratings));


    }

}
