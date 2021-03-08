package package_09;
import static package_09.Test_寻找单链表中倒数第k的元素.CreatLinklist;

public class Test_链表加法_数值正向 {//可实现超长数字数字的相加，但空间占用较高，存在较高的爆栈风险
    public static void main(String[] args) {
        int [] arr1 = {8,9,7};
        int [] arr2 = {9};
        SNode head1 = CreatLinklist(arr1);
        SNode head2 = CreatLinklist(arr2);
        head1.data = head2.data = 0 ;
        Compietion(head1 , head2);

//        SNode p1 = head1 ;
//        SNode p2 = head2 ;
//        while (p1 != null){
//            System.out.print(p1.data + " ");
//            p1 = p1.next;
//        }
        addition(head1 , head2);
        SNode p = S.next ;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next ;
        }
    }
    static SNode S = new SNode(null);
    private static int addition(SNode A , SNode B ){//传入娅元
        if(A == null)return 0 ;
        int carrying = addition(A.next , B.next);
        SNode node = new SNode(0);
        node.data = (carrying + (int)A.data + (int)B.data)%10;

        SNode temp = S.next ;
        S.next = node ;
        node.next = temp;

        return (carrying + (int)A.data + (int)B.data)/10;

    }

    private static void Compietion(SNode Ahead , SNode Bhead ){//传入两个娅元
        SNode p1 , p2 ;
        p1 = Ahead.next ;
        p2 = Bhead.next ;
        int cnt1 = 0;
        int cnt2 = 0;
        while(p1 != null){
            cnt1++;
            p1 = p1.next;
        }
        while (p2 != null){
            cnt2++;
            p2 = p2.next ;
        }
        if(cnt1 == cnt2)return;
        while(cnt1 < cnt2){
            SNode temp = Ahead.next;
            Ahead.next = new SNode(0);
            Ahead.next.next = temp ;
            cnt1++;
        }
        while(cnt2 < cnt1){
            SNode temp = Bhead.next;
            Bhead.next = new SNode(0);
            Bhead.next.next = temp ;
            cnt2++;
        }
    }

}
