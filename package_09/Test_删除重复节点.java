package package_09;

import java.util.HashSet;
import java.util.Set;

public class Test_删除重复节点 {
    public static void main(String[] args) {
        int [] arr = {3,8,4,1,8,5,8,8 };
        rr(arr);
    }

    private static void rr(int[] arr) {
        SNode head = new SNode(null);
        SNode p = head ;
        for (int i = 0; i < arr.length; i++) {
            p.next = new SNode(arr[i]);
            p = p.next ;
        }

        Set<Integer>set = new HashSet<>() ;
        SNode pre = head ;
        SNode flag = pre.next ;
        while (flag != null){
            if(set.contains(flag.data)){
                pre.next = flag.next ;
                flag = pre.next;
            }else {
                set.add((Integer) flag.data);
                pre = flag ;
                flag = flag.next;
            }
            //pre = pre.next ;
            //flag = pre.next.next ;
        }

        p = head.next;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }

    }
}

class SNode{
    public Object data ;
    public SNode next = null ;
    public SNode(Object data){
        this.data = data ;
    }
}
