package package_09;

/**
 * 两个链表数据轮换实现先进先出，后进后出。
 * @param <T>
 */

public class MyQueue_DStack<T> {
    public MyStack<T> stack1 = new MyStack<>();
    public MyStack<T> stack2 = new MyStack<>();

    public static void main(String[] args) {
        MyQueue_DStack<Integer> DD = new MyQueue_DStack<>();
        DD.enqueue(1);
        DD.enqueue(2);
        DD.dequeue();
        DD.enqueue(3);
    }

    public void enqueue(T e){
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(e);
    }
    public T dequeue(){
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        T temp = stack2.peek();
        stack2.pop();
//        while (!stack2.empty()){
//            stack1.push(stack2.pop());
//        }
        return temp;
    }


}
