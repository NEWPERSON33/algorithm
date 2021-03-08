package package_09;

import java.util.EmptyStackException;

public class MyQueue<T> extends MyArrayListD<T> implements IQueue<T> {

    public static void main(String[] args) {
        MyQueue<Integer> Q = new MyQueue<>();
        Q.enqueue(1);
        Q.enqueue(2);
        System.out.println(Q.GetSize());
        System.out.println(Q.peek());
        Q.dequeue();
        System.out.println(Q.peek());
        Q.dequeue();
        System.out.println(Q.peek());
    }

    @Override
    public void enqueue(T e) {
        super.add(e);
    }

    @Override
    public T dequeue() {
        if(empty())throw new EmptyStackException();
        Node<T> tempH = Gethead();
        Node<T> renow = tempH.next;
        tempH.next.next.pre = tempH;
        tempH.next = tempH.next.next;
        super.abtractSize();
        return renow.data;
    }

    @Override
    public T peek() {
        if(empty())throw new EmptyStackException();
        Node<T> temp = Gethead();
        return temp.next.data;
    }

    @Override
    public boolean empty() {
        return GetSize() <= 0;
    }
    public int GetSize(){
        return super.GetSize();
    }
}
