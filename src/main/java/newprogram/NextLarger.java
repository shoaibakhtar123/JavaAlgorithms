/*
Note: Write a solution with O(n) complexity, since this is what you would be asked
to do during a real interview.

Given an array a composed of distinct elements, find the next larger element for each
element of the array, i.e. the first element to the right that is greater than this
element, in the order in which they appear in the array, and return the results as a
new array of the same length. If an element does not have a larger element to its right,
put -1 in the appropriate cell of the result array.

Example

For a = [6, 7, 3, 8], the output should be
nextLarger(a) = [7, 8, 8, -1].

In this array, the next larger element for 6 is 7, for 7 is 8, for 3 is 8 (7 is not a
valid option since elements from a can only be compared to elements to their right),
and for 8 there is no such element, so we put -1 in the last cell.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

An array composed of distinct elements.

Guaranteed constraints:
1 ≤ a.length ≤ 104,
0 ≤ a[i] ≤ 105.

[output] array.integer

The result array, in which the ith cell corresponds to the first element in a to the
right of a[i] that is larger than a[i], or -1 if there is no such element.
 */
package newprogram;

import java.util.Stack;

public class NextLarger {
    public static void main(String[] args) {

        NextLarger nextLarger = new NextLarger();
        int[] arr = {10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6};
        nextLarger.nextLarger(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    int[] nextLarger(int[] a) {

        Stack<Integer> stk = new Stack<>();
        Stack<Integer> increasingStack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            stk.push(a[i]);
        }

        int largeNum = 0;
        int index = a.length-1;
        boolean found = false;

        while(!stk.isEmpty()){
            found = false;
            largeNum = stk.pop();
            if (increasingStack.isEmpty()){
                increasingStack.push(largeNum);
                a[index] = -1;
            } else {
                while (!increasingStack.isEmpty()){
                    int temp = increasingStack.pop();
                    if (temp > largeNum){
                        increasingStack.push(temp);
                        increasingStack.push(largeNum);
                        a[index] = temp;
                        found = true;
                        break;
                    }
                }

                if (!found){
                    increasingStack.push(largeNum);
                    a[index] = -1;
                }

            }
            index--;
        }

        return a;
    }
}
