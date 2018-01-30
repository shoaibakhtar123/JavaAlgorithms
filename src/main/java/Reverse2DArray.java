public class Reverse2DArray {

    private static int[][] twoDArray = new int[5][2];

    public static void main(String[] args) {
        initArray();
        printArray();
        reverseArray();
        printArray();
    }

    private static void reverseArray() {

        int loopNeeded = twoDArray.length*twoDArray[0].length/2;
        int row = twoDArray.length-1;
        int col = twoDArray[0].length-1;

        for (int i = 0; i <= row; i++) {
            if (loopNeeded == 0)
                break;
            for (int j = 0; j <= col; j++) {
                if (loopNeeded == 0)
                    break;

                int temp = twoDArray[i][j];
                twoDArray[i][j] = twoDArray[row-i][col-j];
                twoDArray[row-i][col-j] = temp;
                --loopNeeded;
            }
        }

    }

    private static void initArray() {
        int count = 1;
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[0].length; j++) {
                twoDArray[i][j] = count++;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < twoDArray.length; i++) {
            System.out.println();
            for (int j = 0; j < twoDArray[0].length; j++) {
                System.out.print(twoDArray[i][j]);
                System.out.print(",");
            }
        }
    }

}
