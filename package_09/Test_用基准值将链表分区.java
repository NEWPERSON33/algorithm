package package_09;
import static package_09.Test_寻找单链表中倒数第k的元素.CreatLinklist;
/**
 *不能使用额外存储空间，且不能改变同一区间元素的相对顺序
 * 分区规则：大于等于指定元素的在右边，小于指定元素的在右边
 */
public class Test_用基准值将链表分区 {
    public static void main(String[] args) {
        int k = 5 ;
        int [] arr = {7,1 ,5,4,3,9,0};
        SNode head = CreatLinklist(arr);//head为娅元
        Partition(head , k);
    }

    private static void Partition(SNode head, int k) {
        SNode moreHead,lessHead,more , less ;
        more = less = moreHead = lessHead = head ;
        SNode p = head.next;
        //if(p == null)return;
        while (p != null){
            if((int)p.data < k){
                if(less == head){
                    less = lessHead = p ;
                }
                else{
                    less.next = p ;
                    less = p ;
                }
            }else{
                if(more == head){
                    more = moreHead = p ;
                }else {
                    more.next = p ;
                    more = p ;
                }
            }
            p = p.next ;
        }
        if(moreHead == head || lessHead == head){
            SNode it = head.next;
            while (it != null){
                System.out.print(it.data+ " ");
                it = it.next ;
            }
        }else {
            less.next = moreHead;
            SNode ii = lessHead;
            while (ii != more){
                System.out.print(ii.data + " ");
                ii = ii.next ;
            }
            System.out.print(ii.data + " ");
        }
    }


}
