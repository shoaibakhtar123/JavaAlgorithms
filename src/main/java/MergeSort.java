import java.util.ArrayList;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = getArray();
        mergeSort(array, 0, array.length-1);
        ArrayList<Integer> i = new ArrayList<Integer>();
        printArray(array);

    }

    static void mergeSort(int[] array, int leftStart, int rightEnd){

//        System.out.println("leftStart = " + leftStart + " rightEnd = " + rightEnd);
//        printArray(array);

        if (leftStart >= rightEnd){
            return;
        }

        int middleIndex = (leftStart + rightEnd)/2;

        System.out.println("Merge Sort For left");
        mergeSort(array, leftStart, middleIndex);
        System.out.println("Merge Sort For Right");
        mergeSort(array, middleIndex+1, rightEnd);
        System.out.println("Merge halves");
        mergeHalves(array, leftStart, rightEnd);

    }

    private static void mergeHalves(int[] array, int leftStart, int rightEnd) {
        System.out.println(" calling mergeHalves " + "leftStart = " + leftStart + " rightEnd = " + rightEnd);
        int leftEnd = (rightEnd+leftStart)/2;
        int rightStart = leftEnd+1;
        int size = rightEnd-leftStart+1;
        int left = leftStart;
        int right = rightStart;
        int[] temp = new int[array.length];

        int index=leftStart;

        while (left <= leftEnd && right <= rightEnd){
            if (array[left] < array[right]){
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd-left + 1);
        System.arraycopy(array, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

    }

    static void swap(int[] arrData, int i, int j){
        int tempData = arrData[i];
        arrData[i] = arrData[j];
        arrData[j] = tempData;
    }


    static int[] getArray(){
        int size = 10;
        int[] intArray = new int[size];

        Random r = new Random(1000);
        for (int i =0; i < size; i++){
            intArray[i] = r.nextInt(10);
        }

        printArray(intArray);
        System.out.println();

        return intArray;
    }

    static void printArray(int[] array){
        for (int i =0; i < array.length; i++){
            System.out.print(", " + array[i]);
        }

    }

}
