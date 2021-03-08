package package_09;
import java.util.Stack;

import static package_09.Test_寻找单链表中倒数第k的元素.CreatLinklist;//此方法产生链表首节点为娅元
public class Test_判断回文链表 {
    public static void main(String[] args) {
        int []arr ={1,2,3,4,5};
        SNode head = CreatLinklist(arr);
        //System.out.print(isPalindrome(head.next));
//        reverse(head.next);
//        SNode pp = Head.next ;
//        while (pp != null){
//            System.out.print(pp.data + " ");
//            pp = pp.next ;
//        }
        SNode temp = head.next ;
        while(temp.next != null)temp = temp.next ;
        reverse2(head.next);

        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next ;
        }
    }

    static SNode Head = new SNode(null) ;
    static SNode p = Head ;

    /**
     * 翻转链表内容，反转后的内容存入一个新的链表
     * @param head
     */
    public static void reverse(SNode head){//首节点非娅元
        if(head== null){
            return;
        }
        reverse(head.next);
        SNode node = new SNode(head.data);
        p.next = node ;
        p =node;

    }
    public static SNode reverse2(SNode head){//
        if(head.next == null){
            return head;
        }
        SNode p = reverse2(head.next) ;
        p.next = head ;
        head.next = null ;
        return head ;
    }

    public static boolean isPalindrome(SNode head){//首节点非娅元
        if(head.next == null)return false ;
        Stack<SNode> stack = new Stack<>();
        SNode p1 = head ;
        SNode p2 = head ;
        SNode p3 = head ;
        int F = 0 ;
        while(p2!= null && p2.next != null){
            p1 = p1.next ;
            p2 = p2.next.next ;
        }
        if(p2 != null)F = 1 ;
        while(p3 != p1){
            stack.push(p3);
            p3 = p3.next ;
        }
        while (p3 != null){
            if(F == 1){
                p3 = p3.next;
                F = 0 ;
                continue;
            }

            if(!stack.pop().data.equals(p3.data))return false;
            p3 = p3.next;
        }
        return true ;
    }

}
