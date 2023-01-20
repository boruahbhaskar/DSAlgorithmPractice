public class SelectionSort {

    void selectionSort(int arr[]){

        int n = arr.length;

        for( int lastUnsortedIndex = n -1 ; lastUnsortedIndex > 0 ; lastUnsortedIndex--){

            int largest = 0;
 
            for( int i =1 ; i <= lastUnsortedIndex; i++){

                if (arr[i] > arr[largest]){
                    largest = i;
                }

            }
            swap(arr,largest,lastUnsortedIndex);


        }


    }

    /*A utility function to swap two element in array*/
    public static void swap(int[] arr,int i, int j){

        if (i == j ) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;


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

        SelectionSort obj = new SelectionSort();
        obj.selectionSort(arr);

        printArray(arr);


    }

}
