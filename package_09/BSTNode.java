package package_09;

public class BSTNode<K,V> {
    public K key ;
    public V value ;
    public BSTNode<K,V> left ;
    public BSTNode<K,V> right ;
    public BSTNode<K,V> parent ;
    public boolean isLeftChild ;
    public int height ;
    public  int num ;
    public boolean isRed = true ;

    public BSTNode(){

    }
     public BSTNode(K key , V value , BSTNode<K,V>left , BSTNode<K,V>right , BSTNode<K,V>parent){
         this.key = key ;
         this.value = value ;
         this.left = left ;
         this.right = right ;
         this.parent = parent ;
     }

     public BSTNode(K key , V value){
         this.key = key;
         this.value = value ;
     }

     public boolean isLeft(){
         return isLeftChild;
     }

     public boolean isRight(){
         return !isLeftChild;
     }

    @Override
    public String toString() {
        return this.key + ">>"+(parent == null ? null : parent.key) + (isRed ? " Red" : " Black");
    }
}
