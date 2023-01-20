package arrays;

import java.util.HashMap;
import java.util.Map;

public class Array001 {

    public static void main(String[] args) {

        int[] arr = { 1,2,3,3,4,4};

       System.out.println(getMostFrequentNumber(arr));

    }

    public static int getMostFrequentNumber(int[] arr){

        HashMap<Integer,Integer> arrMap = new HashMap<>();


        for(int i= 0; i < arr.length; i++) {

            if (arrMap.containsKey(arr[i])){

                arrMap.put(arr[i],arrMap.get(arr[i]) + 1);

            }else{
                arrMap.put(arr[i],1);

            }

        }

       // System.out.println(arrMap);
        int maxFreq=0;
        int maxFrqNumber = 0;
        /*
        for(int j=0; j<arr.length; j++ ){
            maxFreq = Math.max(maxFreq,arrMap.get(arr[j]));

            return maxFreq;
        }
        */


        for(Map.Entry<Integer,Integer>  entry: arrMap.entrySet()){

           // System.out.println(entry.getKey()+"-->"+ entry.getValue());

            maxFreq =  Math.max(maxFreq,entry.getValue());

            if (entry.getValue() == maxFreq)

                maxFrqNumber = entry.getKey();
        }
        return maxFrqNumber;

       // return 0;
    }



}
