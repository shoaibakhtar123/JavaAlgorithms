import java.util.Random;

public class BubbleSort {

    private static int[] intArray;
    public static void main(String[] args) {

        int size = 10;
        intArray = new int[size];

        Random r = new Random(1000);
        for (int i =0; i < size; i++){
            intArray[i] = r.nextInt(10);
            System.out.print(", " + intArray[i]);
        }

        bubbleSortRefined(intArray);
    }

    public static void bubbleSort(int[] arrData){

        //O(N^2)
        for (int i = 0; i < arrData.length; i++){
            for (int j = i+1; j < arrData.length; j++){
                if (arrData[i]>arrData[j]){
                    swap(arrData, i, j);
                }
            }

        }
        for (int i = 0; i < arrData.length; i++){
            System.out.println(" , " + arrData[i]);
        }
    }

    public static void bubbleSortRefined(int[] arrData){

        //O(N^2)
        System.out.println("");

        int size = arrData.length-1;
        boolean isSorted = false;


        while (!isSorted){
            isSorted = true;

            for (int i = 0; i < size; i++){
                if (arrData[i]>arrData[i+1]){
                    swap(arrData, i, i+1);
                    isSorted = false;
                }
            }
            size--;
        }

        for (int i = 0; i < arrData.length; i++){
            System.out.print(", " + arrData[i]);
        }
    }

    static void swap(int[] arrData, int i, int j){
        int tempData = arrData[i];
        arrData[i] = arrData[j];
        arrData[j] = tempData;
    }

}
