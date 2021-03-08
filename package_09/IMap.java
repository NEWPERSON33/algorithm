package package2;

import package_09.Hnode;
import package_09.MyHashSet;

import java.util.Iterator;

public interface IMap<K, V> extends Iterator<Hnode<K , V>> {
    void clear();
    boolean containsKey(K key);
    boolean containsValue(V value);
    V get(K key);
    boolean isEmpty();
    MyHashSet<K> keySet();
    void put(K key , V value);
    void putAll(IMap<? extends K , ? extends V> map);
    V remove(K key);
    int GetSize();
    V[] ValueSet();
}
