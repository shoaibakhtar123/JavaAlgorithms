public class Node<E> {
    private E data;
    private Node<E> nextNode;

    public Node(E data, Node<E> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("data=").append(data);
        sb.append(", nextNode=").append(nextNode);
        sb.append('}');
        return sb.toString();
    }
}
