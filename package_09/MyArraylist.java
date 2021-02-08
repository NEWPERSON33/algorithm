package package_09;

import java.util.Arrays;

public class MyArraylist  implements MyList{//数组实现
    private int size = 0 ;
    private int capacity = 10 ;
    private Object [] elements;
    public MyArraylist(int capacity){
        this.capacity = capacity ;
        elements = new Object[capacity] ;
    }
    public MyArraylist(){
        elements = new Object[capacity] ;
    }

    @Override
    public void add(Object element) {
        if(size == capacity){
            capacity*=2 ;
            Object [] newArray = new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray ;
        }
        elements[size++] = element ;
    }

    @Override
    public void Delete(Object element) {
        int index = ElementAt(element);
        Delete(index);
    }

    @Override
    public void Delete(int index) {
        if(index < 0 || index >=capacity)
            return;
        for (int i = index; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        size--;
    }

    @Override
    public void update(int index, Object element) {
        if(index < 0 || index >=capacity)
            return;
        elements[index] = element ;
    }

    @Override
    public int ElementAt(Object element) {
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object indexAt(int index) {
        if(index < 0 || index >=capacity)
            return null;
        return elements[index];
    }

    @Override
    public boolean contains(Object element) {
        if (ElementAt(element) == -1)
            return false;
        return true ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i] + " ");
        }
        sb.append("]");
        return "MyArraylist{" +
                "elements=" + sb.toString() +
                '}';
    }
}


