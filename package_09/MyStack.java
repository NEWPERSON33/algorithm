package package_09;

import java.util.EmptyStackException;

public class MyStack<T> extends MyArrayListD<T> implements IStack<T> {

    public static void main(String [] args){
        MyStack<Integer>st = new MyStack<>();
        st.push(1);
        st.push(2);
        System.out.println(st.GetSize());
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        //st.pop();
        //st.pop();
        //System.out.println(st.peek());
        //System.out.println(st.GetSize());

    }

    @Override
    public T pop() {
        if(empty())throw new EmptyStackException();
        T re = super.Getrear().pre.data;
        Node<T> p = super.Getrear() ;
        p.pre.pre.next = p ;
        p.pre = p.pre.pre ;
        super.abtractSize();
        return re;

    }

    @Override
    public void push(T e) {
        super.add(e);
    }

    @Override
    public boolean empty() {
        return super.GetSize() <= 0;
    }

    @Override
    public int GetSize() {
        return super.GetSize();
    }

    @Override
    public T peek() {
        if(empty())throw new EmptyStackException();
        return super.Getrear().pre.data;
    }
}

