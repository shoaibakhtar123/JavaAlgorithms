/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the
number of elements in l, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.

Example

For l = [0, 1, 0], the output should be
isListPalindrome(l) = true;
For l = [1, 2, 2, 3], the output should be
isListPalindrome(l) = false.
Input/Output

[time limit] 3000ms (java)
[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 5 · 105,
-109 ≤ element value ≤ 109.

[output] boolean

Return true if l is a palindrome, otherwise return false.

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

public class RemoveKFromList {
    public static void main(String[] args) {

    }

    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        if (l == null)
            return null;

        ListNode<Integer> previous = l;
        ListNode<Integer> nextList = l;

        while (nextList != null) {
            if (previous.value.equals(k)){
                previous = previous.next;
                l = previous;
            } else if (nextList.value.equals(k)){
                previous.next = nextList.next;
            } else {
                previous = nextList;
            }
            nextList = nextList.next;
        }
        return l;
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
