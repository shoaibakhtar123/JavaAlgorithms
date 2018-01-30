import java.util.ArrayList;

public class SimpleBinaryTree<T extends Comparable<T>> {
    private Node<T> rootNode;

    public static void main(String[] args) {
        SimpleBinaryTree<Integer> simpleBinaryTree = new SimpleBinaryTree<>();

        simpleBinaryTree.addNode(7);
        simpleBinaryTree.addNode(1);
        simpleBinaryTree.addNode(0);
        simpleBinaryTree.addNode(3);
        simpleBinaryTree.addNode(2);
        simpleBinaryTree.addNode(5);
        simpleBinaryTree.addNode(4);
        simpleBinaryTree.addNode(6);
        simpleBinaryTree.addNode(9);
        simpleBinaryTree.addNode(8);
        simpleBinaryTree.addNode(10);

//        simpleBinaryTree.preOrderTraversal();
//        simpleBinaryTree.inOrderTraversal();
//        simpleBinaryTree.postOrderTraversal();

        ArrayList<Integer> arrayList = new ArrayList<>();

        simpleBinaryTree.hasPathWithGivenSum(simpleBinaryTree.getRootNode(), 2, 0, arrayList);

    }

    void addNode(T data){
        if (rootNode == null){
            rootNode = new Node(data);
            rootNode.leftNode = null;
            rootNode.rightNode = null;
        } else if (rootNode.data.compareTo(data) > 0){
            addLeftNode(rootNode, data);
        } else if (rootNode.data.compareTo(data) < 0){
            addRightNode(rootNode, data);
        }
    }

    private void addRightNode(Node<T> rootNode, T data) {
        if (rootNode.rightNode == null){
            rootNode.rightNode = new Node(data);
        } else if (rootNode.rightNode.data.compareTo(data) > 0){
            addLeftNode(rootNode.rightNode, data);
        } else if (rootNode.rightNode.data.compareTo(data) < 0){
            addRightNode(rootNode.rightNode, data);
        }
    }

    private void addLeftNode(Node<T> rootNode, T data) {
        if (rootNode.leftNode == null){
            rootNode.leftNode = new Node(data);
        } else if (rootNode.leftNode.data.compareTo(data) > 0){
            addLeftNode(rootNode.leftNode, data);
        } else if (rootNode.leftNode.data.compareTo(data) < 0){
            addRightNode(rootNode.leftNode, data);
        }
    }

    boolean findNode(T data){
        return findNodeIfExist(rootNode, data);
    }

    private boolean findNodeIfExist(Node<T> rootNode, T data) {
        if (rootNode == null){
            return false;
        }

        if (rootNode.data.compareTo(data) == 0){
            return true;
        }

        if (rootNode.data.compareTo(data) > 0){
            findNodeIfExist(rootNode.leftNode, data);
        } else if (rootNode.data.compareTo(data) < 0){
            findNodeIfExist(rootNode.rightNode, data);
        }

        return false;
    }

    void preOrderTraversal(){
        System.out.println();
        preOrderTraversal(rootNode);
    }

    void inOrderTraversal(){
        System.out.println();
        inOrderTraversal(rootNode);
    }

    void postOrderTraversal(){
        System.out.println();
        postOrderTraversal(rootNode);
    }

    private void preOrderTraversal(Node<T> node){

        if (node == null){
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.leftNode);
        preOrderTraversal(node.rightNode);

    }

    private void inOrderTraversal(Node<T> node){

        if (node == null){
            return;
        }

        inOrderTraversal(node.leftNode);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightNode);

    }

//    void hasPathWithGivenSum(int s, int totalSum, ArrayList<Integer> list) {
//        hasPathWithGivenSum(rootNode, 2, 0, new ArrayList<Integer>());
//
//    }

    private Node<T> getRootNode(){
        return this.rootNode;
    }

    void hasPathWithGivenSum(Node<Integer> node, int s, int totalSum, ArrayList<Integer> list) {
        if (node == null){
            return;
        }

        if (node.leftNode == null && node.rightNode == null){
            // it is a leaf node
            totalSum += node.data;
            System.out.println("totalSum = " + totalSum);
            list.add(totalSum);
        }

        if (node.leftNode != null){
            hasPathWithGivenSum(node.leftNode, s, totalSum+node.data, list);
        }

        if (node.rightNode != null){
            hasPathWithGivenSum(node.rightNode, s, totalSum+node.data, list);
        }
    }
    private void postOrderTraversal(Node<T> node){

        if (node == null){
            return;
        }

        postOrderTraversal(node.leftNode);
        postOrderTraversal(node.rightNode);
        System.out.print(node.data + " ");
    }

    class Node<T extends Comparable<T>>{
        T data;
        Node leftNode;
        Node rightNode;

        public Node(T data) {
            this.data = data;
        }
    }

}
