package newprogram;

public class NewQuickSort {
    public static void main(String[] args) {

        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        int k = 2;

        NewQuickSort newQuickSort = new NewQuickSort();
        newQuickSort.kthLargestElement(nums, k);

//        Arrays.sort(nums.length-k-1);


    }


    int kthLargestElement(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return nums[k-1];
    }

    private void quickSort(int[] nums, int start, int end) {

        if (start >= end){
            return;
        }

        int pivot = nums[(start+end)/2];

        int index = partition(nums, start, end, pivot);

        quickSort(nums, start, index-1);
        quickSort(nums, index, end);

    }

    private int partition(int[] nums, int left, int right, int pivot) {

        while (left <= right){

            while (nums[left] > pivot){
                left++;
            }

            while(nums[right] < pivot){
                right--;
            }

            if (left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }

        }

        return left;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
