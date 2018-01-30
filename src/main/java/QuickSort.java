import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] unsortedArray = getArray();
        quickSort(unsortedArray, 0, unsortedArray.length-1);

        printArray(unsortedArray);

    }

    private static void quickSort(int[] array, int left, int right) {

        if (left >= right)
            return;

        int pivot = array[(left + right)/2];

        int partitionIndex = partition(array, left, right, pivot);

        quickSort(array, left, partitionIndex-1);
        quickSort(array, partitionIndex, right);

    }

    private static int partition(int[] array, int left, int right, int pivot) {

        System.out.println("left = " + left + " right = " + right + " pivot=" + pivot);

        while (left <=right){

            while (array[left] < pivot)
                left++;

            while (array[right] > pivot)
                right--;

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }

        }
        System.out.println();
        printArray(array);
        System.out.println("partition = " + left);
        return left;
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
