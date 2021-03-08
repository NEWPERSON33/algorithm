package package_09;

public class Test_寻找单链表中倒数第k的元素 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8 };
        int k = 3 ;
        SNode head = CreatLinklist(arr);//head为娅元
        SNode p1 , p2 ;
        p1 = p2 = head.next ;
        int position = 1 ;
        while( position < k){
            p2 = p2.next ;
            position++;
            if(p2 == null)return;
        }
        while ( p2.next != null){
            p1 = p1.next;
            p2 = p2.next ;
        }
        System.out.println(p1.data);
    }

    public static SNode CreatLinklist(int[] arr) {
        SNode head = new SNode(null);
        SNode p = head ;
        for (int i = 0; i < arr.length; i++) {
            SNode newnode = new SNode(arr[i]);
            p.next = newnode ;
            p = newnode;
        }
        return head ;
    }

}
