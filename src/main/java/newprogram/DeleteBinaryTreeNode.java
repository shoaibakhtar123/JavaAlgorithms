package newprogram;

public class DeleteBinaryTreeNode {

    private Tree<Integer> rootNode;

    public static void main(String[] args) {
        DeleteBinaryTreeNode deleteBinaryTreeNode = new DeleteBinaryTreeNode();
        deleteBinaryTreeNode.addNode(5);
        deleteBinaryTreeNode.addNode(2);
        deleteBinaryTreeNode.addNode(1);
        deleteBinaryTreeNode.addNode(3);
        deleteBinaryTreeNode.addNode(6);
        deleteBinaryTreeNode.addNode(8);
        deleteBinaryTreeNode.addNode(7);

        int[] queries = {4, 5, 6};

        deleteBinaryTreeNode.deleteFromBST(deleteBinaryTreeNode.rootNode, queries);
//        deleteBinaryTreeNode.deleteNodeTree(null, deleteBinaryTreeNode.rootNode,11, false);

//        inOrderTraversal(deleteBinaryTreeNode.rootNode);

    }

    Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {

        if (t==null){
            return null;
        }
        for (int i : queries){
            t = deleteNodeTree(null, t, i, false);
        }
        return t;
    }

    private Tree<Integer> deleteNodeTree(Tree<Integer> parentNode, Tree<Integer> node, Integer value, boolean isLeft) {
        if (node == null){
            return parentNode;
        }

        if (node.value.equals(value)){
            //need to delete the root node.
            if (node.left == null) {
                node = node.right;
                if (parentNode == null){
                    parentNode = node;
                } else {
                    if (isLeft){
                        parentNode.left = node;
                    } else {
                        parentNode.right = node;
                    }
                }
                return parentNode;
            } else {
                Tree<Integer> rightNodeInLeft = getRightMostNodeFromLeft(node, node.left, true);
                rightNodeInLeft.right = node.right;
                rightNodeInLeft.left = node.left;
                if (parentNode == null){
                    parentNode = rightNodeInLeft;
                } else {
                    if (isLeft){
                        parentNode.left = node;
                    } else {
                        parentNode.right = node;
                    }
                }
                return parentNode;
            }
        } else if (node.value.compareTo(value) > 0){
            deleteNodeTree(node, node.left, value, true);
        } else {
            deleteNodeTree(node, node.right, value, false);
        }

        return node;
    }

    private Tree<Integer> getRightMostNodeFromLeft(Tree<Integer> parentNode, Tree<Integer> childNode, boolean isLeft) {

        Tree<Integer> rightMostChild = null;

        if (childNode.right == null){
            if (isLeft){
                parentNode.left = childNode.left;
            } else {
                parentNode.right = childNode.left;
            }
            return childNode;
        } else {
            parentNode = childNode;
            childNode = childNode.right;
            rightMostChild = getRightMostNodeFromLeft(parentNode, childNode, false);
        }
        return rightMostChild;
    }


    private void inOrderTraversal(Tree<Integer> node) {

        if (node == null){
            return;
        }

        System.out.print(node.value + " ");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);


    }

//    public Tree findNodeTree(Integer value, Tree node){
//        return null;
//    }

    public void addNode(Integer value){
        if (rootNode == null){
            rootNode = new Tree<>(value);
            return;
        }

        if (rootNode.value.compareTo(value) > 0){
            addLeftNode(rootNode, value);
        } else {
            addRightNode(rootNode, value);
        }

    }

    private void addLeftNode(Tree<Integer> node, Integer value) {
        if (node.left == null){
            node.left = new Tree<>(value);
        }else if (node.left.value.compareTo(value) > 0){
            addLeftNode(node.left, value);
        } else {
            addRightNode(node.left, value);
        }

    }

    private void addRightNode(Tree<Integer> node, Integer value) {
        if (node.right == null){
            node.right = new Tree<>(value);
        }else if (node.right.value.compareTo(value) > 0){
            addLeftNode(node.right, value);
        } else {
            addRightNode(node.right, value);
        }

    }
}

// Definition for binary tree:
class Tree<T> {
    Tree(T x) {
        value = x;
    }

    T value;
    Tree<T> left;
    Tree<T> right;
}
