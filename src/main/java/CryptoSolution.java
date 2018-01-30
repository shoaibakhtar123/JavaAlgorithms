/*
A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence
between letters and digits, such that the given arithmetic equation consisting of letters
holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the
mapping of letters and digits, solution. The array crypt will contain three non-empty
strings that follow the structure: [word1, word2, word3], which should be interpreted as
the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with
digits using the mapping in solution, becomes a valid arithmetic equation containing
no numbers with leading zeroes, the answer is true. If it does not become a valid
arithmetic solution, the answer is false.

Example

For crypt = ["SEND", "MORE", "MONEY"] and

solution = [['O', '0'],
            ['M', '1'],
            ['Y', '2'],
            ['E', '5'],
            ['N', '6'],
            ['D', '7'],
            ['R', '8'],
            ['S', '9']]
the output should be
isCryptSolution(crypt, solution) = true.

When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in crypt, you
get 9567 + 1085 = 10652 which is correct and a valid arithmetic equation.

For crypt = ["TEN", "TWO", "ONE"] and

solution = [['O', '1'],
            ['T', '0'],
            ['W', '9'],
            ['E', '5'],
            ['N', '4']]
the output should be
isCryptSolution(crypt, solution) = false.

Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes, meaning that this
is not a valid solution.

Input/Output

[time limit] 3000ms (java)
[input] array.string crypt

An array of three non-empty strings containing only uppercase English letters.

Guaranteed constraints:
crypt.length = 3,
1 ≤ crypt[i].length ≤ 14.

[input] array.array.char solution

An array consisting of pairs of characters that represent the correspondence between
letters and numbers in the cryptarithm. The first character in the pair is an uppercase
English letter, and the second one is a digit in the range from 0 to 9.

Guaranteed constraints:
solution[i].length = 2,
'A' ≤ solution[i][0] ≤ 'Z',
'0' ≤ solution[i][1] ≤ '9',
solution[i][0] ≠ solution[j][0], i ≠ j,
solution[i][1] ≠ solution[j][1], i ≠ j.

It is guaranteed that solution only contains entries for the letters present in crypt
and that different letters have different values.

[output] boolean

Return true if the solution represents the correct solution to the cryptarithm crypt,
otherwise return false.

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

public class CryptoSolution {
    public static void main(String[] args) {
        String[] crypt = {"SEND", "MORE", "MONEY"};
        char[][] solution = {{'O', '0'},{'M', '1'},{'Y', '2'},{'E', '5'},{'N', '6'},{'D', '7'},{'R', '8'},{'S', '9'}};
        System.out.println(isCryptSolution(crypt, solution));

    }

    static boolean isCryptSolution(String[] crypt, char[][] solution) {

        String num1 = getNumber(crypt[0], solution);
        String num2 = getNumber(crypt[1], solution);
        String num3 = getNumber(crypt[2],solution);
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);
        System.out.println("num3=" + num3);

        if ((num1.charAt(0) == '0' && num1.length() > 1)
                || (num2.charAt(0) == '0' && num2.length() > 1)
                || (num3.charAt(0) == '0' && num3.length() > 1)){
            return false;
        }

        return (Long.valueOf(num1) + Long.valueOf(num2) == Long.valueOf(num3));
    }

    private static String getNumber(String s, char[][] solution) {
        char[] chars = s.toCharArray();
        String data = "";
        for (char c : chars){
            data = data + getCorrespondingNumber(c, solution);
        }

        System.out.println("data=" + data);
        return data;
//        return Integer.valueOf(data).intValue();
    }

    private static char getCorrespondingNumber(char c, char[][] solution) {

        for (int i = 0; i < solution.length; i++) {
            if (solution[i][0] == c){
                return solution[i][1];
            }
        }

        return '0';
    }


}
