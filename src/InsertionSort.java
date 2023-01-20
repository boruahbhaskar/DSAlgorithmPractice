public class InsertionSort {

    /*Function to sort array using insertion sort*/
     void insertionSort(int arr[]){

        int n = arr.length;

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < n ; firstUnsortedIndex++){

            int key = arr[firstUnsortedIndex];

            int i;

            for(i= firstUnsortedIndex; i > 0 && arr[i-1] > key ; i--){

                arr[i] = arr[i-1];
            }

            arr[i] = key;

        }

    }

    /* A utility function to print an array of size n */
    static void printArray(int arr[]){

        int n =arr.length;

        for(int i= 0 ; i < n ; i++){
            System.out.print(arr[i]+" ");
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int arr[] = { 20 , 35 , -15 , 7 , 55 , 1 , -22};

        InsertionSort obj = new InsertionSort();
        obj.insertionSort(arr);

        printArray(arr);


    }




}
