package package_09;

import java.util.Iterator;

public interface IHashSet<E> extends Iterator<E> {
    void add(E key);
    void remove(E key);
    void clear();
    boolean contains(E key);
    boolean isEmpty();
    int GetSize();
}
