package package_09;

import java.util.Iterator;

public interface MyList2<T> extends Iterator<T> {
    public void add(T element);
    public void Delete(T element);
    public void Delete(int index);
    public void update(int index , T element);
    public int ElementAt(T element);
    public T indexAt(int index);
    public boolean contains(T element);
}
