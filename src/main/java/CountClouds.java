/*
Given a 2D grid skyMap composed of '1's (clouds) and '0's (clear sky), count the
number of clouds. A cloud is surrounded by clear sky, and is formed by connecting
adjacent clouds horizontally or vertically. You can assume that all four edges of
the skyMap are surrounded by clear sky.

Example

For

skyMap = [['0', '1', '1', '0', '1'],
          ['0', '1', '1', '1', '1'],
          ['0', '0', '0', '0', '1'],
          ['1', '0', '0', '1', '1']]
the output should be
countClouds(skyMap) = 2;

For

skyMap = [['0', '1', '0', '0', '1'],
          ['1', '1', '0', '0', '0'],
          ['0', '0', '1', '0', '1'],
          ['0', '0', '1', '1', '0'],
          ['1', '0', '1', '1', '0']]
the output should be
countClouds(skyMap) = 5.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.char skyMap

A 2D grid that represents a map of the sky, as described above.

Guaranteed constraints:

0 ≤ skyMap.length ≤ 300,
0 ≤ skyMap[i].length ≤ 300.

[output] integer

The number of clouds in the given skyMap, as described above.
 */
import java.util.HashSet;
import java.util.Set;

public class CountClouds {
    public static void main(String[] args) {
        CountClouds countClouds = new CountClouds();

        char[][] arr = 	{{'0', '1', '0', '0', '1'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '1', '0', '1'},
                         {'0', '0', '1', '1', '0'},
                         {'1', '0', '1', '1', '0'}};

//        char[][] arr = 	{{'0', '1', '1', '0', '1'},
//                        {'0', '1', '1', '1', '1'},
//                        {'0', '0', '0', '0', '1'},
//                        {'1', '0', '0', '1', '1'}};
        System.out.println(countClouds.countClouds(arr));

    }

    int countClouds(char[][] skyMap) {
        Set<String> coordinates = new HashSet<>();

        int clouds = 0;

        for (int i = 0; i < skyMap.length; i++) {
            for (int j = 0; j < skyMap[i].length; j++) {
                char c = skyMap[i][j];
                if (c == '0'){
                    continue;
                }

                String str = "" + i + "," + j;
                if (!coordinates.contains(str)){
                    clouds++;
                    coordinates.add(str);
                    addNeighbours(skyMap, i, j, coordinates);
                }
            }
        }

        return clouds;

    }

    private void addNeighbours(char[][] skyMap, int row, int col, Set<String> coordinates) {
        if (row > 0){
            char c = skyMap[row-1][col];
            if (c == '1'){
                String str = "" + (row-1) + "," + col;
                if (!coordinates.contains(str)){
                    coordinates.add(str);
                    addNeighbours(skyMap, row-1, col, coordinates);
                }
            }
        }
        if (row < skyMap.length-1){
            char c = skyMap[row+1][col];
            if (c == '1'){
                String str = "" + (row+1) + "," + col;
                if (!coordinates.contains(str)){
                    coordinates.add(str);
                    addNeighbours(skyMap, row+1, col, coordinates);
                }
            }

        }
        if (col > 0){
            char c = skyMap[row][col-1];
            if (c == '1'){
                String str = "" + row + "," + (col-1);
                if (!coordinates.contains(str)){
                    coordinates.add(str);
                    addNeighbours(skyMap, row, col-1, coordinates);
                }
            }

        }
        if (col < skyMap[row].length -1){
            char c = skyMap[row][col+1];
            if (c == '1'){
                String str = "" + row + "," + (col+1);
                if (!coordinates.contains(str)){
                    coordinates.add(str);
                    addNeighbours(skyMap, row, col+1, coordinates);
                }
            }

        }
    }

}
