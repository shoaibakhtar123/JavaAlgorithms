public class BinaryTree <E extends Comparable<E>>{
    private BinaryTreeNode<E> rootNode;

    public void addNode(BinaryTreeNode<E> node){

        if (rootNode == null){
            rootNode = node;
            rootNode.setLeftNode(null);
            rootNode.setRightNode(null);
        } else if (rootNode.getData().compareTo(node.getData()) > 1){
            addLeftNode(rootNode, node);

        } else if (rootNode.getData().compareTo(node.getData()) < 1){
            addRightNode(rootNode, node);
        }
    }

    private void addRightNode(BinaryTreeNode<E> parentNode, BinaryTreeNode<E> node) {
        if (parentNode.getLeftNode() == null){
            parentNode.setLeftNode(node);
        } else if (parentNode.getData().compareTo(node.getData()) > 1){
            addRightNode(parentNode, node);

        } else if (parentNode.getData().compareTo(node.getData()) < 1){
            addLeftNode(parentNode, node);
        }
    }

    private void addLeftNode(BinaryTreeNode<E> parentNode, BinaryTreeNode<E> node) {
        if (parentNode.getRightNode() == null){
            parentNode.setRightNode(node);
        } else if (parentNode.getData().compareTo(node.getData()) > 1){
            addRightNode(parentNode, node);

        } else if (parentNode.getData().compareTo(node.getData()) < 1){
            addLeftNode(parentNode, node);
        }
    }

}
