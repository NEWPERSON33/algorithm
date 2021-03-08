package package_09;

import java.util.HashSet;

public class Test_有环链表的环起点 {
    public static void main(String[] args) {

    }

    //解法一：hashset查重
    public static SNode begin(SNode head){//首节点非娅元
        HashSet set =new HashSet() ;
        SNode p = head ;
        while(p != null){
            if(set.contains(p)){
                return p ;
            }else{
                set.add(p);
            }
            p = p.next ;
        }
        return null;
    }
    //解法2：利用环路重合的数学性质
    public static SNode Fbegin(SNode head){//首节点非娅元
        SNode p1 = head ;
        SNode p2 = head ;
        SNode p3 = head ;
        if(hasloop(head)){
            while(true){
                p1 = p1.next ;
                p2 = p2.next.next;
                if( p1 == p2)break;
            }
            while(p3 != p2){
                p3 = p3.next ;
                p2 = p2.next ;
            }
            return p3 ;
        }
        return null;
    }

    //判断链表是否存在环路
    public static boolean hasloop(SNode head){//首节点非娅元
        SNode p1 = head ;
        SNode p2 = head ;
        while (p2 != null && p2.next != null){
            p1 = p1.next ;
            p2 = p2.next.next;
            if(p1 == p2)return true ;
        }
        return false;
    }

    //解法优化，hasloop与Fbegin的整合
    public static SNode FindLoopB(SNode head){//首节点非娅元
        SNode p1 = head ;
        SNode p2 = head ;
        SNode p3 = head ;
        while (p2 != null && p2.next != null){
            p1 = p1.next ;
            p2 = p2.next.next;
            if(p1 == p2){
                while (p1 != p3){
                    p1 = p1.next ;
                    p3 = p3.next ;
                }
                return p3;
            }
        }
        return null;
    }

}
