package package_09;

public class MyArrayListDoubleLinkList implements MyList{//线性表双向链表实现
    int size = 0 ;
    DoubleLinkListNode head ;
    DoubleLinkListNode rear ;

    public static void main(String[] args) {
        MyArrayListDoubleLinkList L = new MyArrayListDoubleLinkList() ;
        L.add("1");
        L.add("2");
        L.add("3");
        System.out.println(L);
        L.Delete(1);
        System.out.println(L);
    }

    public MyArrayListDoubleLinkList(){
        head = new DoubleLinkListNode(null);
        rear = new DoubleLinkListNode(null);
        head.next = rear;
        rear.pre = head ;
    }


    @Override
    public void add(Object element) {
        DoubleLinkListNode temp = new DoubleLinkListNode(element) ;
        DoubleLinkListNode p = rear.pre ;
        p.next = temp ;
        temp.pre = p ;
        temp.next = rear ;
        rear.pre = temp ;
        size++ ;
    }

    @Override
    public void Delete(Object element) {
        Delete(ElementAt(element));
    }

    @Override
    public void Delete(int index) {
        if(index < 0 || index >= size)return;
        DoubleLinkListNode p = head.next ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        p.pre.next = p.next ;
        p.next.pre = p.pre ;
        size--;
    }

    @Override
    public void update(int index, Object element) {
        if(index < 0 || index >= size)return;
        DoubleLinkListNode p = head.next ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        p.data = element ;
    }

    @Override
    public int ElementAt(Object element) {
        DoubleLinkListNode p = head.next ;
        int nowIndex = 0 ;
        while (p != rear){
            if(p.data.equals(element))return nowIndex;
            p = p.next ;
            nowIndex++;
        }
        return -1;
    }

    @Override
    public Object indexAt(int index) {
        if(index < 0 || index >= size)return null;
        DoubleLinkListNode p = head.next ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        return p.data;
    }

    @Override
    public boolean contains(Object element) {
        return ElementAt(element) > -1 ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("") ;
        DoubleLinkListNode p = head.next ;
        while (p != rear){
            sb.append(" "+p.data+" ");
            p = p.next ;
        }
        return "MyArrayListDoubleLinkList{" +
                 sb.toString()+
                '}';
    }
}


class DoubleLinkListNode {
    public DoubleLinkListNode pre = null;
    public DoubleLinkListNode next = null;
    public Object data ;

    public DoubleLinkListNode(Object data){
        this.data = data ;
    }
}
