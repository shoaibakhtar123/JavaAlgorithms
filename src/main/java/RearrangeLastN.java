public class RearrangeLastN {
    public static void main(String[] args) {

    }

    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {

        if (n == 0)
            return l;

        ListNode<Integer> temp = l;
        ListNode<Integer> pointer = l;
        for (int i = 0; i < n; i++) {
            pointer = temp;
            temp = temp.next;
        }

        if (pointer == null || pointer.next==null)
            return l;

        ListNode<Integer> current = l;
        ListNode<Integer> previous = null;

        while (pointer.next != null){
            previous = current;
            current = current.next;
            pointer = pointer.next;
        }



        if (previous == null)
            previous = current;

        System.out.println(current.value);
        System.out.println(pointer.value);
        System.out.println(previous.value);


        previous.next = null;
        pointer.next = l;
        l = current;

        return l;

    }


    // Definition for singly-linked list:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }


}
