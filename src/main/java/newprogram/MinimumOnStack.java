/*
Note: Write a solution with O(operations.length) complexity, since this is
what you would be asked to do during a real interview.

Implement a modified stack that, in addition to using push and pop operations,
allows you to find the current minimum element in the stack by using a min operation.

Example

For operations =
["push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"],
the output should be
minimumOnStack(operations) = [10, 5, 5, 5, 10].

The operations array contains 5 instances of the min operation. The results array
contains 5 numbers, each representing the minimum element in the stack at the moment
when min was called.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.string operations

An array of operations consistently applied to the stack. For each valid i,
operations[i] is one of the following operations:

push x: add the number x to the stack;
pop: remove an element from the top of the stack;
min: find the minimum element from the current stack elements.
It is guaranteed that pop and min are not applied to an empty stack. It is also
guaranteed that all of the numbers in the stack are positive and not greater than 109.
Guaranteed constraints:
1 ≤ operations.length ≤ 104.

[output] array.integer

For each min operation, return the minimum element from the current stack elements
at the moment when the operation was called.
 */
package newprogram;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class MinimumOnStack {
    public static void main(String[] args) {

        String[] str = {"push 538580174",
                "min",
                "push 120004347",
                "min",
                "pop",
                "min",
                "pop",
                "push 791405182",
                "min",
                "pop",
                "push 336848461",
                "min",
                "pop",
                "push 279001335",
                "min",
                "push 594354012",
                "min"};
        MinimumOnStack minimumOnStack = new MinimumOnStack();
        minimumOnStack.minimumOnStack(str);

    }

    int[] minimumOnStack(String[] operations) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        int min = 110;
        for(String str:operations){
            if (str.contains("pop")){
                int data = stk.pop();
                if (data == min && !stk.isEmpty()){
                    //find the next min value
                    min = getMinValue(stk);
                }
            }else if (str.contains("min")){
                queue.add(min);
            } else if (str.contains("push")){
                int data = Integer.valueOf(str.substring(5));
                if (stk.isEmpty()){
                    min = data;
                }else if (data < min){
                    min = data;
                }
                stk.push(data);

            }
        }
        int[] finalArray = new int[queue.size()];
        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = queue.poll();
            System.out.println(finalArray[i]);
        }
        return finalArray;
    }

    private int getMinValue(Stack<Integer> stk) {

        int newMin = -1;
        ListIterator<Integer> integerListIterator = stk.listIterator();
        while (integerListIterator.hasNext()){
            int temp = integerListIterator.next();
            if (newMin == -1){
                newMin = temp;
            }else if (newMin > temp){
                newMin = temp;
            }

        }
        return newMin;
    }
}
