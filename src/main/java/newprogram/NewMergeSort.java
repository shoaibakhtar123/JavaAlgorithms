package newprogram;

public class NewMergeSort {
    public static void main(String[] args) {

        NewMergeSort newMergeSort = new NewMergeSort();

        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        int k = 2;
        newMergeSort.kthLargestElement(nums, k);
    }


    int kthLargestElement(int[] nums, int k) {
        mergeSort(nums, 0, nums.length-1);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return nums[k-1];
    }

    private void mergeSort(int[] nums, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart+rightEnd)/2;

        mergeSort(nums, leftStart, middle);
        mergeSort(nums, middle+1, rightEnd);

        mergeHalves(nums, leftStart, rightEnd);

    }

    private void mergeHalves(int[] array, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd+leftStart)/2;
        int rightStart = leftEnd+1;
        int size = rightEnd-leftStart+1;
        int left = leftStart;
        int right = rightStart;
        int[] temp = new int[array.length];

        int index=leftStart;

        while (left <= leftEnd && right <= rightEnd){
            if (array[left] < array[right]){
                temp[index] = array[right];
                right++;
            } else {
                temp[index] = array[left];
                left++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd-left + 1);
        System.arraycopy(array, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

    }


}
