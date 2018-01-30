public interface IStack <T> extends Iterable<T> {
    public void add (T data);
    public boolean isEmpty();
    public T peek();
    public T pop();
    public int size();
    public boolean isMember(T member);
    public T[] toArray(T[] arrayToCopy);
    public String toString();
}
