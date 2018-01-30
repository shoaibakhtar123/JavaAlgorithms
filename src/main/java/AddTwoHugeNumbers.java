/*
a: [9876, 5432, 1999]
b: [1, 8001]
 */

import java.util.ArrayList;
import java.util.List;

public class AddTwoHugeNumbers {
    public static void main(String[] args) {


        ListNode<Integer> a = new ListNode<Integer>(0);
//        a.next = new ListNode<Integer>(5432);
//        a.next.next = new ListNode<Integer>(1999);

        ListNode<Integer> b = new ListNode<Integer>(0);
        b.next = new ListNode<Integer>(8001);
        b.next.next = new ListNode<Integer>(1000);

        System.out.println(addTwoHugeNumbers4(a,b));

    }

    static ListNode<Integer> addTwoHugeNumbers4(ListNode<Integer> a, ListNode<Integer> b) {

        a = reverseNode(a);
        b = reverseNode(b);
        int carryForward = 0;

        ListNode<Integer> current = null;
        ListNode<Integer> previous = null;

        while (true) {
            int data1 = 0;
            int data2 = 0;
            if (a!=null){
                data1 = a.value;
            }
            if (b!=null){
                data2 = b.value;
            }
            a = a.next;
            b = b.next;

            int tempTotal = data1 + data2 + carryForward;

            System.out.println("tempTotal=" + tempTotal);

            if (tempTotal > 9999) {
                carryForward = 1;
                tempTotal = (tempTotal - 10000) % 9999;
            } else {
                carryForward = 0;
            }

            System.out.println("carryForward=" + carryForward);

            previous = new ListNode<Integer>(tempTotal);
            previous.next = current;
            current = previous;

            if (a == null && b == null) {
                break;
            }

        }

        if (carryForward > 0) {
            previous = new ListNode<Integer>(carryForward);
            previous.next = current;
            current = previous;
        }
        return current;

    }

    private static ListNode<Integer> reverseNode(ListNode<Integer> a) {
        ListNode<Integer> p1 = a;
        ListNode<Integer> p2 = a.next;
        ListNode<Integer> temp;

        boolean first = true;

        while (p2 != null){
            temp = p2.next;
            p2.next = p1;
            if (first) {
                p1.next = null;
                first = false;
            }
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    static ListNode<Integer> addTwoHugeNumbers3(ListNode<Integer> a, ListNode<Integer> b) {

        List<Integer> arrayList1 = new ArrayList<Integer>(50);
        List<Integer> arrayList2 = new ArrayList<Integer>(50);

        ListNode<Integer> tempList1 = a;
        ListNode<Integer> tempList2 = b;

        while(true){
            if (tempList1 == null && tempList2 == null)
                break;

            if (tempList1 != null){
                arrayList1.add(tempList1.value);
                tempList1 = tempList1.next;

            }

            if (tempList2 != null){
                arrayList2.add(tempList2.value);
                tempList2 = tempList2.next;

            }

        }
        boolean loop = true;
        int carryForward = 0;
        ListNode<Integer> current = null;
        ListNode<Integer> previous = null;

        int count1 = arrayList1.size() - 1;
        int count2 = arrayList2.size() - 1;
        int data1 = 0;
        int data2 = 0;
        while (loop) {
            if (count1 >= 0) {
                data1 = arrayList1.get(count1--);
            }

            if (count2 >= 0) {
                data2 = arrayList2.get(count2--);
            }

            int tempTotal = data1 + data2 + carryForward;

            System.out.println("tempTotal=" + tempTotal);

            if (tempTotal > 9999) {
                carryForward = 1;
                tempTotal = (tempTotal - 10000) % 9999;
            } else {
                carryForward = 0;
            }

            System.out.println("carryForward=" + carryForward);

            previous = new ListNode<Integer>(tempTotal);
            previous.next = current;
            current = previous;

            if (count1 < 0 && count2 < 0) {
                loop = false;
            }
        }

        if (carryForward > 0) {
            previous = new ListNode<Integer>(carryForward);
            previous.next = current;
            current = previous;
        }
        return current;
    }

    static ListNode<Integer> addTwoHugeNumbers2(ListNode<Integer> a, ListNode<Integer> b) {

        int count1 = 0;
        ListNode<Integer> tempList = a;
        while (tempList != null) {
            count1++;
            tempList = tempList.next;
        }

        System.out.println("count1 = " + count1);
        int[] array1 = new int[count1];
        tempList = a;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = tempList.value;
            tempList = tempList.next;
        }


        int count2 = 0;
        tempList = b;
        while (tempList != null) {
            count2++;
            tempList = tempList.next;
        }
        System.out.println("count2 = " + count2);
        int[] array2 = new int[count2];

        tempList = b;
        for (int i = 0; i < array2.length; i++) {
            array2[i] = tempList.value;
            tempList = tempList.next;
        }

        boolean loop = true;
        int carryForward = 0;
        ListNode<Integer> current = null;
        ListNode<Integer> previous = null;

        count1--;
        count2--;
        while (loop) {
            int data1 = 0;
            int data2 = 0;
            if (count1 >= 0) {
                data1 = array1[count1];
            }

            if (count2 >= 0) {
                data2 = array2[count2];
            }

            int tempTotal = data1 + data2 + carryForward;

            System.out.println("tempTotal=" + tempTotal);

            if (String.valueOf(tempTotal).length() == 5) {
                carryForward = Integer.valueOf(String.valueOf(tempTotal).substring(0, 1));
                tempTotal = Integer.valueOf(String.valueOf(tempTotal).substring(1));
            } else {
                carryForward = 0;
            }

            System.out.println("carryForward=" + carryForward);

            if (current == null) {
                System.out.println("current");

                current = new ListNode<Integer>(tempTotal);
            } else {
                previous = new ListNode<Integer>(tempTotal);
                previous.next = current;
                current = previous;
            }

            count1--;
            count2--;

            if (count1 < 0 && count2 < 0) {
                loop = false;
            }
        }

        if (carryForward > 0) {
            previous = new ListNode<Integer>(carryForward);
            previous.next = current;
            current = previous;
        }
        return current;
    }

    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        String s1 = getAllValue(a);
        String s2 = getAllValue(b);

        System.out.println("s1=" + s1);
        System.out.println("s2=" + s2);

        int length1 = s1.length() / 4;
        String[] strArray1 = new String[length1];
        int length2 = s2.length() / 4;
        String[] strArray2 = new String[length2];
        int count1 = length1 - 1;
        int count2 = length2 - 1;

        for (int i = 0; i < length1; i++) {
            strArray1[i] = s1.substring(0, 4);
            s1 = s1.substring(4);
        }

        for (int i = 0; i < length2; i++) {
            strArray2[i] = s2.substring(0, 4);
            s2 = s2.substring(4);
        }

        boolean loop = true;
        int carryForward = 0;

        ListNode<Integer> current = null;
        ListNode<Integer> previous = null;

        while (loop) {
            int data1 = 0;
            int data2 = 0;
            if (count1 >= 0) {
                data1 = Integer.valueOf(strArray1[count1]);
            }

            if (count2 >= 0) {
                data2 = Integer.valueOf(strArray2[count2]);
            }

            int tempTotal = data1 + data2 + carryForward;

            System.out.println("tempTotal=" + tempTotal);

            if (String.valueOf(tempTotal).length() == 5) {
                carryForward = Integer.valueOf(String.valueOf(tempTotal).substring(0, 1));
                tempTotal = Integer.valueOf(String.valueOf(tempTotal).substring(1));
            } else {
                carryForward = 0;
            }

            System.out.println("carryForward=" + carryForward);

            if (current == null) {
                System.out.println("current");

                current = new ListNode<Integer>(tempTotal);
            } else {
                previous = new ListNode<Integer>(tempTotal);
                previous.next = current;
                current = previous;
            }

            count1--;
            count2--;

            if (count1 < 0 && count2 < 0) {
                loop = false;
            }
        }

        if (carryForward > 0) {
            previous = new ListNode<Integer>(carryForward);
            previous.next = current;
            current = previous;
        }

        return current;

    }

    private static String getAllValue(ListNode<Integer> a) {
        String value = "";

        while (a != null) {
            value = value + getValueWithLeadingZeros(a.value.toString());
            a = a.next;
        }

        return value;
    }

    private static String getValueWithLeadingZeros(String s) {
        if (s.length() == 1) {
            s = "000" + s;
        } else if (s.length() == 2) {
            s = "00" + s;
        } else if (s.length() == 3) {
            s = "0" + s;
        }
        return s;
    }


    // Definition for singly-linked list:
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> addTwoHugeNumbersNew(ListNode<Integer> a, ListNode<Integer> b) {
        if(a == null) return b;
        if(b == null) return a;
        if(isZero(b)) {
            return trim(a);
        }
        ListNode<Integer> carry = computeCarry(a, b);
        a = computeRemainder(a, b);
        return addTwoHugeNumbersNew(a, carry);
    }

    ListNode<Integer> trim(ListNode<Integer> a) {
        while(a != null && a.value == 0) {
            a = a.next;
        }
        if(a == null){
            return new ListNode<Integer>(0);
        }
        return a;
    }

    boolean isZero(ListNode<Integer> b) {
        while(b !=null) {
            if(b.value != 0) {
                return false;
            }
            b = b.next;
        }
        return true;
    }

    ListNode<Integer> computeCarry(ListNode<Integer> a, ListNode<Integer> b) {
        a = reverse(a);
        b = reverse(b);
        ListNode<Integer> head = null;
        ListNode<Integer> old = null;
        int val3 = 0;
        while(a != null || b != null) {
            int val1 = a != null ? a.value : 0;
            int val2 = b != null ? b.value : 0;
            val3 = (val1 + val2) / 10000;

            old = head;
            head = new ListNode<Integer>(val3);
            head.next = old;

            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }

        ListNode<Integer> x = head;
        while(x != null) {
            if(x.next == null){
                x.next = new ListNode<Integer>(0);
                break;
            }
            x = x.next;
        }


        return head;
    }

    ListNode<Integer> computeRemainder(ListNode<Integer> a, ListNode<Integer> b) {
        a = reverse(a);
        b = reverse(b);
        ListNode<Integer> head = null;
        while(a != null || b != null) {
            int val1 = a != null ? a.value : 0;
            int val2 = b != null ? b.value : 0;


            int val3 = (val1 + val2) % 10000;

            ListNode<Integer> old = head;
            head = new ListNode<Integer>(val3);
            head.next = old;

            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }

        return head;
    }

    ListNode<Integer> reverse(ListNode<Integer> a) {
        ListNode<Integer> x = a;
        ListNode<Integer> head = null;
        while(x != null) {

            ListNode<Integer> old = head;
            head = new ListNode<Integer>(x.value);
            head.next = old;
            x = x.next;
        }
        return head;
    }

}
