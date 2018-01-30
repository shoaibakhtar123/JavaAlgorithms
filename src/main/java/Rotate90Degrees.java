/*
Note: Try to solve this task in-place (with O(1) additional memory), since this is
what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees
(clockwise).

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
Input/Output

[time limit] 3000ms (java)
[input] array.array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 100,
a[i].length = a.length,
1 ≤ a[i][j] ≤ 104.

[output] array.array.integer

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}
 */
public class Rotate90Degrees {

    private static int[][] a = new int[4][4];

    public static void main(String[] args) {
        initArray();
        printArray();
        System.out.println();
        rotateNintyDegrees();
        printArray();
    }

    private static void rotateNintyDegrees() {
        int noOfLoops = a.length/2;
        int dim = a.length -1;
        int[][] newArr = new int[a.length][a.length];

        for (int row = 0; row <= noOfLoops; row++) {
            for (int col = 0; col <= noOfLoops; col++) {
//                System.out.println(row + "," + col + "-->" + col + "," + (dim-row) + " value=" + a[row][col]);
//                System.out.println(col + "," + (dim-row) + "-->" + (dim-row) + "," + (dim-col) + " value=" + a[col][dim-row]);
//                System.out.println((dim-row) + "," + (dim-col) + "-->" + (dim-col) + "," + (row) + " value=" + a[dim-row][dim-col]);
//                System.out.println((dim-row) + "," + (row) + "-->" + (row) + "," + (col) + " value=" + a[dim-row][row]);

                newArr[col][dim-row] = a[row][col];
                newArr[dim-row][dim-col] = a[col][dim-row];
                newArr[dim-col][row] = a[dim-row][dim-col];
                newArr[row][col] = a[dim-col][row];
            }
        }
        a = newArr;
    }

    private static void initArray() {
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = count++;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < a.length; i++) {
            System.out.println();
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                System.out.print(",");
            }
        }
    }

}
