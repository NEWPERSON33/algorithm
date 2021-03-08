package package_09;

public interface IQueue<T> {
    public void enqueue(T e);
    public T dequeue();
    public T peek() ;
    public int GetSize();
    public boolean empty();
}
