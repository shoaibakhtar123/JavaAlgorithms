package newprogram;

public class NearestGreater {
    public static void main(String[] args) {

        NearestGreater nearestGreater = new NearestGreater();

        int[] arr = {1, 4, 2, 1, 7, 6};
//        [1, 4, 1, 2, -1, 4].
        int[] ints = nearestGreater.nearestGreater(arr);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    int[] nearestGreater(int[] a) {

        if (a == null){
            return null;
        }

        int[] newArr = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            int leftIndex = getLeftIndex(a, i);
            int rightIndex = getRightIndex(a, i);

            if (leftIndex == -1){
                newArr[i] = rightIndex;
            }else if (rightIndex == -1){
                newArr[i] = leftIndex;
            } else {
                int leftDistance = i - leftIndex;
                int rightDistance = rightIndex - i;

                if (leftDistance == rightDistance){
                    newArr[i] = leftIndex;
                } else if (leftDistance < rightDistance){
                    newArr[i] = leftIndex;
                } else {
                    newArr[i] = rightIndex;
                }
            }
        }
        return newArr;
    }

    private int getRightIndex(int[] a, int index) {
        for (int i = index+1; i < a.length; i++) {
            if (a[index] < a[i]){
                return i;
            }
        }
        return -1;
    }

    private int getLeftIndex(int[] a, int index) {
        for (int i = index-1; i > -1; i--) {
            if (a[index] < a[i]){
                return i;
            }
        }
        return -1;
    }


}
