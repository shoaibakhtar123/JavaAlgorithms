public class BinaryTreeNode <E extends Comparable<E>>{

    private E data;
    private BinaryTreeNode<E> rightNode;
    private BinaryTreeNode<E> leftNode;

    public BinaryTreeNode(E data, BinaryTreeNode<E> rightNode, BinaryTreeNode<E> leftNode) {
        this.data = data;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BinaryTreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTreeNode)) return false;

        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;

        if (!data.equals(that.data)) return false;
        if (rightNode != null ? !rightNode.equals(that.rightNode) : that.rightNode != null) return false;
        return leftNode != null ? leftNode.equals(that.leftNode) : that.leftNode == null;
    }

    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + (rightNode != null ? rightNode.hashCode() : 0);
        result = 31 * result + (leftNode != null ? leftNode.hashCode() : 0);
        return result;
    }

}
