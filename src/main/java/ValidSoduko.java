/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers
in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that
compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a
valid Sudoku puzzle according to the layout rules described above. Note that the puzzle
represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column,
each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[time limit] 3000ms (java)
[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.

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
public class ValidSoduko {

    public static void main(String[] args) {

    }

    static boolean sudoku2(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != '.'){
                    if(!checkIfValid(grid, i, j, grid[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkIfValid(char[][] grid, int i, int j, char c) {
        for (int k = 0; k < grid.length; k++) {
            if (k == i)
                continue;

            if (grid[k][j] == c){
                return false;
            }

        }
        for (int k = 0; k < grid.length; k++) {
            if (k == j)
                continue;

            if (grid[i][k] == c){
                return false;
            }

        }

        int rowStart;
        int rowEnd;

        if (i <= 2){
            rowStart = 0;
            rowEnd = 2;
        } else if (i <= 5){
            rowStart = 3;
            rowEnd = 5;
        } else {
            rowStart = 6;
            rowEnd = 8;
        }

        int colStart;
        int colEnd;
        if (j <= 2){
            colStart = 0;
            colEnd = 2;
        } else if (j <= 5){
            colStart = 3;
            colEnd = 5;
        } else {
            colStart = 6;
            colEnd = 8;
        }


        System.out.println("grid="+ grid[i][j]  +"char=" + c +"i=" +i +"j=" +j+"rowStart = " + rowStart + "rowEnd=" + rowEnd + "colStart=" + colStart + "colEnd="+colEnd);
        for (int l = rowStart; l <= rowEnd; l++){
            for (int k = colStart; k <= colEnd; k++) {
                if (l == i && k == j){
                    continue;
                }
                if (grid[l][k] == c){
                    System.out.println("mmm"+c);
                    return false;
                }
            }

        }

        return true;
    }

    //Need to check the 3.3 grid as well.


}
