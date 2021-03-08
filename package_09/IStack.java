package package_09;

public interface IStack<T> extends MyList2<T> {
    public T pop();
    public void push(T e);
    public boolean empty();
    public int GetSize();
    public T peek();
}
