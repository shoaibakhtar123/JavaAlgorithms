/*
Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.

Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.

Example

For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
Input/Output

[time limit] 3000ms (java)
[input] linkedlist.integer l1

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 104,
-109 ≤ element value ≤ 109.

[input] linkedlist.integer l2

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 104,
-109 ≤ element value ≤ 109.

[output] linkedlist.integer

A list that contains elements from both l1 and l2, sorted in non-decreasing order.

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

public class MergeTwoLinkedLists {

    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> l3 = null;
        ListNode<Integer> nextElement = null;
        ListNode<Integer> temp = null;

        while (true){
            if (l1 == null && l2 == null){
                break;
            } else if (l1 != null && l2 == null){
                temp = new ListNode<Integer>(l1.value);
                if (l3 == null){
                    l3 = temp;
                    l3.next = nextElement;
                    nextElement = l3;
                } else {
                    nextElement.next = temp;
                    nextElement = nextElement.next;
                }
                l1 = l1.next;
            } else if (l1 == null && l2 != null){
                temp = new ListNode<Integer>(l2.value);
                if (l3 == null){
                    l3 = temp;
                    l3.next = nextElement;
                    nextElement = l3;
                } else {
                    nextElement.next = temp;
                    nextElement = nextElement.next;
                }
                l2 = l2.next;

            } else {
                if (l1.value.compareTo(l2.value) >=0 ){
                    temp = new ListNode<Integer>(l2.value);
                    if (l3 == null){
                        l3 = temp;
                        l3.next = nextElement;
                        nextElement = l3;
                    } else {
                        nextElement.next = temp;
                        nextElement = nextElement.next;
                    }
                    l2 = l2.next;
                } else {
                    temp = new ListNode<Integer>(l1.value);
                    if (l3 == null){
                        l3 = temp;
                        l3.next = nextElement;
                        nextElement = l3;
                    } else {
                        nextElement.next = temp;
                        nextElement = nextElement.next;
                    }
                    l1 = l1.next;
                }
            }
        }

        return l3;

    }

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

}
