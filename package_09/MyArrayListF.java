package package_09;

import java.util.Arrays;

public class MyArrayListF<T> implements MyList2<T> {

    private int size = 0 ;
    private int capacity = 10 ;
    private T [] elements;
    int now ;

    public static void main(String[] args) {
        MyArrayListF<String> my = new MyArrayListF<>() ;
        my.add("1");
        my.add("2");
        my.add("3");
        my.Delete(1);
        System.out.println(my);
    }

    public MyArrayListF(int capacity){
        this.capacity = capacity ;
        elements = (T[]) new Object[capacity] ;
        now = -1 ;
    }
    public MyArrayListF(){
        elements = (T[]) new Object[capacity] ;
        now = -1 ;
    }

    @Override
    public void add(T element) {
        if(size == capacity){
            capacity*=2 ;
            T [] newArray =  (T[])new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray ;
        }
        elements[size++] = element ;
    }

    @Override
    public void Delete(T element) {
        Delete(ElementAt(element));
    }

    @Override
    public void Delete(int index) {
        if(index < 0 || index >=capacity) return;
        for (int i = index; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        size--;
    }

    @Override
    public void update(int index, T element) {
        if(index < 0 || index >=capacity)
            return;
        elements[index] = element ;
    }

    @Override
    public int ElementAt(T element) {
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T indexAt(int index) {
        if(index < 0 || index >=capacity)
            return null;
        return elements[index];
    }

    @Override
    public boolean contains(T element) {
        return ElementAt(element) > -1;
    }

    @Override
    public boolean hasNext() {
        return now + 1 < size;
    }

    @Override
    public T next() {
        now++;
        return elements[now];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]+" ");
        }
        return "MyArrayListF{" +
                "elements=" + sb.toString() +
                '}';
    }
}
