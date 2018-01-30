/*
Note: Your solution should have O(n) time complexity, where n is the number of element
in l, and O(1) additional space complexity, since this is what you would be asked to
accomplish in an interview.

Given a linked list l, reverse its nodes k at a time and return the modified list. k is
a positive integer that is less than or equal to the length of l. If the number of nodes
in the linked list is not a multiple of k, then the nodes that are left out at the end
should remain as-is.

You may not alter the values in the nodes - only the nodes themselves can be changed.

Example

For l = [1, 2, 3, 4, 5] and k = 2, the output should be
reverseNodesInKGroups(l, k) = [2, 1, 4, 3, 5];
For l = [1, 2, 3, 4, 5] and k = 1, the output should be
reverseNodesInKGroups(l, k) = [1, 2, 3, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
reverseNodesInKGroups(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].
Input/Output

[time limit] 3000ms (java)
[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
1 ≤ list size ≤ 104,
-109 ≤ element value ≤ 109.

[input] integer k

The size of the groups of nodes that need to be reversed.

Guaranteed constraints:
1 ≤ k ≤ l size.

[output] linkedlist.integer

The initial list, with reversed groups of k elements.

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

public class ReverseNodesInKGroups {
    public static void main(String[] args) {

    }


    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {

        if (k == 1)
            return l;

        int countOfLoops = getCountOfLoops(l, k);

        ListNode<Integer> previousLink = null;

        int count = 0;

        ListNode<Integer> head = null;
        ListNode<Integer> tail = null;
        ListNode<Integer> temp = null;
        ListNode<Integer> previous = null;
        ListNode<Integer> current = l;

        while (count < countOfLoops) {
            count++;
            tail = current;
            for (int i = 0; i < k; i++) {
                temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }
            head = previous;
            if (previousLink == null) {
                previousLink = tail;
                l = head;
            } else {
                previousLink.next = head;
                previousLink = tail;
            }
        }

        previousLink.next = current;

        return l;

    }

    private int getCountOfLoops(ListNode<Integer> l, int k) {
        int length = 0;
        while (l != null){
            length++;
            l = l.next;
        }

        return length/k;
    }


    //     Definition for singly-linked list:
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

}
