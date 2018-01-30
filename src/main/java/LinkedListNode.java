import java.util.ArrayDeque;
import java.util.ArrayList;

public class LinkedListNode {
    private int data;
    private LinkedListNode nextNode;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public void appendToTail(int data){
        LinkedListNode newNode = new LinkedListNode(data);

        LinkedListNode tempNode = this;

        while (tempNode != null){
            tempNode = tempNode.nextNode;
        }
        this.data = data;
        this.nextNode = newNode;
    }

    public LinkedListNode deleteNode(LinkedListNode head, int d) {

        if (head.data == d)
            return head.nextNode;

        LinkedListNode tempNode = head;
        while (tempNode.nextNode != null){
            if (tempNode.nextNode.data == d){
                tempNode.nextNode = tempNode.nextNode.nextNode;
                return head;
            }
            tempNode = tempNode.nextNode;
        }

        return head;
    }

    public LinkedListNode removeDuplicateNodes(LinkedListNode head) {
        if (head == null)
            return head;

        LinkedListNode tempNode = head;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(head.data);

        while (tempNode.nextNode != null){
            if (arrayList.contains(tempNode.nextNode.data)){
                tempNode = tempNode.nextNode.nextNode;
            }
            tempNode = tempNode.nextNode;
        }

        return nextNode;
    }

    public void removeDuplicateNodesWithoutBuffer(LinkedListNode head) {
        if (head == null || head.nextNode == null)
            return;

        LinkedListNode tempNode = head;
        LinkedListNode tempNodeInternal = head.nextNode;

        while (tempNode.nextNode != null){
            int data = tempNode.data;
            while (tempNodeInternal.nextNode != null){
                if (tempNodeInternal.nextNode.data == data){
                    tempNodeInternal = tempNodeInternal.nextNode.nextNode;
                }
            }
            tempNode = tempNode.nextNode;
        }
    }

    public LinkedListNode findNthLastElement(LinkedListNode head, int fourthLastElement) {
        if (head == null || head.nextNode == null)
            return null;

        LinkedListNode tempNode = head;

        if (tempNode.getSize(tempNode) < fourthLastElement){
            return null;
        }

        ArrayDeque<LinkedListNode> queue = new ArrayDeque<LinkedListNode>();

        while (tempNode.nextNode != null){
            if (queue.size() == fourthLastElement){
                queue.poll();
            }
            queue.add(tempNode);
            tempNode = tempNode.nextNode;
        }

        return queue.poll();
    }

    public int getSize(LinkedListNode head){
        if (head == null)
            return 0;

        int size = 0;
        LinkedListNode tempNode = head;
        while (tempNode.nextNode!=null){
            size++;
            tempNode = tempNode.nextNode;
        }

        return size;
    }

//    public LinkedList<Integer> removeDuplicateNodesWithoutTempBuffer(LinkedList<Integer> head) {
//        if (head == null)
//            return head;
//
//        LinkedList<Integer> tempNode = head;
//
//        head.getFirst();
//
//        LinkedHashSet<Integer> hashSet = new LinkedHashSet<Integer>(head);
//
//
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//        arrayList.add(head.data);
//
//        while (tempNode.nextNode != null){
//            if (arrayList.contains(tempNode.nextNode.data)){
//                tempNode = tempNode.nextNode.nextNode;
//            }
//            tempNode = tempNode.nextNode;
//        }
//
//        return nextNode;
//    }

}
