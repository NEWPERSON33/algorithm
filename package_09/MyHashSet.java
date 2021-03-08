package package_09;

public class MyHashSet<E> implements IHashSet<E> {

    public static void main(String[] args) {
        MyHashSet<String>set = new MyHashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        while (set.hasNext()){
            System.out.println(set.next());
        }
    }

    MYHashmap<E,E>map = new MYHashmap<>();

    @Override
    public void add(E key) {
        map.put(key,null);
    }

    @Override
    public void remove(E key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(E key) {
        return map.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return GetSize() == 0;
    }

    @Override
    public int GetSize() {
        return map.GetSize();
    }

    @Override
    public boolean hasNext() {
        return map.hasNext();
    }

    @Override
    public E next() {
        return map.next().key;
    }
}
