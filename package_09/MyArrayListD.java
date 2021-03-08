package package_09;

public class MyArrayListD<T> implements MyList2<T> {//泛型，双链表以及迭代器

    private int size = 0 ;
    private Node<T> head ;
    private Node<T> rear ;
    private Node<T> now ;//迭代器变量

    public static void main(String[] args) {
        MyArrayListD<String>my = new MyArrayListD<>();
        my.add("1");
        my.add("2");
        my.add("3");
        my.Delete(1);
        while (my.hasNext()){
            System.out.print(my.next()+ "  ");
        }

        //System.out.println(my);
    }

    public MyArrayListD(){
        head = new Node<T>(null);
        rear = new Node<T>(null);
        head.next = rear;
        rear.pre = head ;
        now = head ;
    }

    @Override
    public void add(T element) {
        Node<T> temp = new Node<T>(element) ;
        Node<T> p = rear.pre ;
        p.next = temp ;
        temp.pre = p ;
        temp.next = rear ;
        rear.pre = temp ;
        size++ ;
    }

    @Override
    public void Delete(T element) {
        Delete(ElementAt(element));
    }

    @Override
    public void Delete(int index) {
        if(index < 0 || index >= size)return;
        Node<T> p = head.next ;
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
    public void update(int index, T element) {
        if(index < 0 || index >= size)return;
        Node<T> p = head.next ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        p.data = element ;
    }

    @Override
    public int ElementAt(T element) {
        Node<T> p = head.next ;
        int nowIndex = 0 ;
        while (p != rear) {
            if (p.data.equals(element)) return nowIndex;
            p = p.next;
            nowIndex++;
        }
        return -1 ;
    }

    @Override
    public T indexAt(int index) {
        if(index < 0 || index >= size)return null;
        Node<T> p = head.next ;
        int nowIndex = 0 ;
        while (nowIndex < index){
            p = p.next ;
            nowIndex++;
        }
        return p.data;
    }

    @Override
    public boolean contains(T element) {
        return ElementAt(element) > -1 ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("") ;
        Node<T> p = head.next ;
        while(p != rear){
            sb.append(" "+p.data+" ");
            p = p.next ;
        }
        return "MyArrayListD{" +
                sb.toString() +
                '}';
    }

    //private Node<T> now = head ;

    @Override
    public boolean hasNext() {
//        boolean p =   now.next == rear ? false : true;
//        now = p == false ? head : now ;
            return now.next != rear;
    }

    @Override
    public T next() {
        now = now.next ;
        return now.data ;
    }

    public int GetSize(){return size;}
    public Node<T> Getrear(){return rear;}//head和rear均为娅元
    public Node<T> Gethead(){return head;}
    public void abtractSize(){size-- ;}

}

class Node<T>{
    public T data ;
    public Node<T> pre = null ;
    public Node<T> next = null;
    public Node(T data){
        this.data = data ;
    }
}