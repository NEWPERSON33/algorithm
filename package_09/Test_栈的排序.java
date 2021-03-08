package package_09;

import java.util.Stack;

public class Test_栈的排序 {
    public static void main(String[] args) {
        int [] arr = {4,3,5,7,2,1};
        Stack<Integer> stack = Solution(arr);
    }

    private static Stack<Integer> Solution(int[] arr) {
        Stack<Integer>stack1 = new Stack<>();
        Stack<Integer>stack2 = new Stack<>();
        for (int x:arr) {
            stack1.push(x);
        }
        while(!stack1.empty()){
            int temp = stack1.pop();
            if(stack2.empty()|| temp >= stack2.peek()){
                stack2.push(temp);
            }else{
                while (!stack2.empty() && stack2.peek() > temp){
                    stack1.push(stack2.pop());
                }
                stack2.push(temp);
            }
        }
        return stack2;
    }
}
