package arrays;

public class ArrayLesson {


    public static void main(String[] args) {

        int[] intArray = new int[7];

        System.out.println("Array Length " +intArray.length);

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -45;
        intArray[3] = 60;
        intArray[4] = 5;
        intArray[5] = -25;
        intArray[6] = 28;

        for(int i = 0 ; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }


    }
}
