package package_09;

public class MyArrayList2 implements MyList{

    private ListNode head  = null;
    private ListNode rear = null;
    private int size = 0 ;

    @Override
    public void add(Object element) {
        ListNode temp = new ListNode(element);
        if(head == null){
            head = rear = temp ;
        }else{
            rear.next = temp ;
            rear = rear.next;
        }
        size++;
    }

    @Override
    public void Delete(Object element) {
        int index = ElementAt(element);
        Delete(index);
    }

    @Override
    public void Delete(int index) {
        if(index >=size || index < 0)return;
        if(index == 0){
            head = head.next;
            size--;
        }else {
            ListNode pre = null;
            ListNode p = head;
            int indexNow = 0 ;
            while(indexNow < index){
                pre = p ;
                p = p.next ;
                indexNow++;
            }
            pre.next = p.next ;
            if(pre.next == null)rear = pre ;
            size--;
        }
    }

    @Override
    public void update(int index, Object element) {
        if(index >=size || index < 0)return;
        ListNode p = head ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        p.data = element ;
    }

    @Override
    public int ElementAt(Object element) {
        ListNode p = head ;
        int indexofNow = 0 ;
        while(p != null){
            if( p.data.equals(element)){
                return indexofNow;
            }
            p = p.next ;
            indexofNow++;
        }
        return -1 ;
    }

    @Override
    public Object indexAt(int index) {
        if(index >=size || index < 0)return null;
        ListNode p = head ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        return p.data;
    }

    @Override
    public boolean contains(Object element) {
        return ElementAt(element) > -1;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        ListNode p = head ;
        while(p != null){
            sb.append(p.data+" ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String [] args){//测试函数
        MyArrayList2 my = new MyArrayList2() ;
        my.add("1");
        my.add("2");
        my.add("3");
        my.Delete(2);
        System.out.println(my);
    }
}


class ListNode{
    public Object data ;
    public ListNode next = null;
    public ListNode(Object data){
        this.data = data ;
    }
}
