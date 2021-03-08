package package_09;

public class Hnode<K , V>{
    public K key ;
    public V value;
    public Hnode<K, V>next = null;
    public Hnode(K key , V value){
        this.key = key ;
        this.value = value ;
    }

    @Override
    public String toString() {
        return "Hnode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}