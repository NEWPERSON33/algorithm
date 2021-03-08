package package_09;

/**
 * 空间换时间，动态维护两个栈同时进出
 *
 */

public class Test_实现stack常数阶查找min {
    public static void main(String[] args) {
        MyStack<Integer> stack1 = new MyStack<>();
        MyStack<Integer> stack2 = new MyStack<>();
        int [] arr = {2,5,3,7,5};
        for (int i = 0; i < arr.length; i++) {
            stack1.push(arr[i]);
            if(stack2.empty()){
                stack2.push(arr[i]);
            }else{
                if(arr[i] < stack2.peek()){
                    stack2.push(arr[i]);
                }else
                    stack2.push(stack2.peek());
            }
        }
        System.out.println(stack2.peek());
    }
}
