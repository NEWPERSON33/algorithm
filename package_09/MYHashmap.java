package package_09;

import package2.IMap;

import java.util.Arrays;

public class MYHashmap<K , V> implements IMap<K , V> {

    public static void main(String[] args) {
        MYHashmap<String , String> map = new MYHashmap<>();
        map.put("one","bu");
        map.put("two","er");
        map.put("three","san");
        map.put("one","yi");
        map.put("onefdgj","yi");
        map.put("onefddsfgj","yi");
        map.put("Zdrfds" , "dsa");
        //System.out.println(map.remove("one"));
        //System.out.println(map.containsKey("one"));
        //System.out.println(map);
        while (map.hasNext()){
            System.out.println(map.next());
        }
    }

    private int size = 0 ;
    private int N = 16 ;
    private Hnode<K , V>  [] hashseq;
    private Hnode<K,V>p;
    public MYHashmap(){
        hashseq = new Hnode[N];
        p = hashseq[0];
    }

    public MYHashmap(int N){
        this.N = N ;
        hashseq = new Hnode[N];
        p = hashseq[0];
    }

    public int hashposition(K key){
        int temp = key.hashCode()%N;
        return temp > 0 ? temp : -temp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < N; i++) {
            if(hashseq[i] == null)continue;
            hashseq[i] = null ;
        }
        size = 0 ;
    }

    @Override
    public boolean containsKey(K key) {
        int index = hashposition(key);
        if(hashseq[index] == null){
            return false ;
        }else {
            Hnode<K,V> p = hashseq[index];
            while(p!= null){
                if(p.key.equals(key))return true;
                p = p.next ;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < N; i++) {
            if(hashseq[i] != null){
                Hnode<K,V> p = hashseq[i];
                while (p != null){
                    if(p.value.equals(value))return true;
                    p = p.next;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = hashposition(key);
        if (hashseq[index] == null) {
            return null;
        } else {
            Hnode<K, V> p = hashseq[index];
            while (p != null) {
                if (p.key.equals(key)) return p.value;
                p = p.next;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MyHashSet<K> keySet() {
//        int in = 0;
//        K [] arr = (K[])new Object[size];
//        for (int i = 0; i < N; i++) {
//            if(hashseq[i] != null){
//                Hnode<K, V> p = hashseq[i];
//                while (p != null){
//                    arr[in++] = p.key;
//                    p = p.next;
//                }
//            }
//        }
//        return arr;
        MyHashSet<K> set = new MyHashSet<>();
        for (int i = 0; i < N; i++) {
            if(hashseq[i] != null){
                Hnode<K,V> p = hashseq[i];
                while (p != null){
                    set.add(p.key);
                    p = p.next;
                }
            }
        }
        return set ;
    }

    @Override
    public void put(K key, V value) {
        int index = hashposition(key);
        Hnode<K,V>temp = new Hnode<>(key , value);
        if(hashseq[index] == null){
            hashseq[index] = temp;
            size++;
        }else {
            Hnode<K, V> p = hashseq[index];
            while (p != null) {
                if (p.key.equals(key)){
                    p.value = value ;
                    break;
                }
                if(p.next == null){
                    p.next = temp;
                    size++;
                }
                p = p.next;
            }
        }
    }

    @Override
    public void putAll(IMap<? extends K, ? extends V> map) {

    }

    @Override
    public V remove(K key) {
        int index = hashposition(key);
        V re = null ;
        if(hashseq[index] == null){
            return re ;
        }else {
            Hnode<K,V> p = hashseq[index];
            Hnode<K,V>pre = p ;
            while(p!= null){
                if(p.key.equals(key)) {
                    if(pre == p) {
                        re = p.value;
                        hashseq[index] = p.next;
                        size--;
                        break;
                    }else {
                        re = p.value;
                        pre.next = p.next ;
                        size--;
                        break;
                    }

                }
                pre = p ;
                p = p.next ;
            }
        }
        return re;
    }

    @Override
    public int GetSize() {
        return size;
    }

    @Override
    public V[] ValueSet() {
        int in = 0;
        V [] arr = (V[])new Object[size];
        for (int i = 0; i < N; i++) {
            if(hashseq[i] != null){
                Hnode<K, V> p = hashseq[i];
                while (p != null){
                    arr[in++] = p.value;
                    p = p.next;
                }
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Hnode<K, V> p = hashseq[i];
            while (p != null){
                sb.append("("+p.key +":" + p.value+")");
                p = p.next;
            }
        }
        return "MYHashmap{" +
                "hashseq=" + sb.toString() +
                '}';
    }

    /**
     * i记录下当前位置以完成遍历
     */
    private int i = 0 ;
    @Override
    public boolean hasNext() {

        while (i < N && p == null){
            i++;
            if(i == N)return false;
            p = hashseq[i];
        }
        return p != null ;
    }

    @Override
    public Hnode<K , V> next() {
        Hnode<K , V> res = p ;
        p = p.next ;
        return res ;
    }
}

