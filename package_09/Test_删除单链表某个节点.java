package package_09;

/**
 * 不能访问其前置节点，若该节点为尾节点返回false,否则返回true
 */
public class Test_删除单链表某个节点 {
    public static void main(String[] args) {

    }
    public static boolean DeleteNode(SNode S){
        if(S.next == null)return false;
        S.data = S.next.data ;
        S.next = S.next.next;
        return true;
    }
}
