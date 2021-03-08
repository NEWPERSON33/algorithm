package package_09;
import static package_09.Test_寻找单链表中倒数第k的元素.CreatLinklist;
public class Test_链表加法 {
    public static void main(String[] args) {
        int [] arr1 = {9,7};
        int [] arr2 = {1,2,9};
        SNode head1 = CreatLinklist(arr1);//首节点为娅元
        SNode head2 = CreatLinklist(arr2);//
        SNode head3 = addition(head1.next , head2.next , 0);
        SNode p = head3;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public static SNode addition(SNode A , SNode B , int carrying){//递归形式
        SNode node = new SNode(carrying);
        if(A == null && B == null)return node ;
        if(A == null){
            node.data = (carrying + (int)B.data)%10 ;
            node.next = addition(null , B.next , (carrying + (int)B.data)/10);
        }else if(B == null){
            node.data = (carrying + (int)A.data)%10 ;
            node.next = addition(A.next , null , (carrying + (int)A.data)/10);
        }else{
            node.data = (carrying + (int)B.data + (int)A.data)%10 ;
            node.next = addition(A.next , B.next , (carrying + (int)B.data + (int)A.data)/10);
        }
        return node ;
    }

}
