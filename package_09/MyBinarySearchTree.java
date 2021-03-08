package package_09;

import javax.swing.text.html.InlineView;
import java.util.*;
import java.util.function.Consumer;
/*
概念补充：
1.完全二叉树：
一棵深度为k的有n个结点的二叉树，对树中的结点按从上至下、从左到右的顺序进行编号，
如果编号为i（1≤i≤n）的结点与满二叉树中编号为i的结点在二叉树中的位置相同，则这棵二叉树称为完全二叉树。
 */
public class MyBinarySearchTree<K,V> implements IBinarySearchTree<K,V> {

    public static void main(String[] args) {
        MyBinarySearchTree<Integer , String>test = new MyBinarySearchTree<>() ;


        test.insert(10,null);
        test.insert(30,null);
        test.insert(11,null);
        test.insert(-2,null);
        BSTNode<Integer , String> node = test.insert(-1,null);
        //node.key = 300 ;
        test.Check(test.GetRoot());
        System.out.println(test.flag);
        //test.reverse(test.root);
//        Integer [] arr = {1,2,3,4,5,6,7} ;
//        BSTNode<Integer , String> node = test.CreatMinHeight(arr , 0 , arr.length - 1);
//        test.SetRoot(node);
        test.inorder(test.GetRoot(), new Consumer<BSTNode<Integer,String>>() {
            @Override
            public void accept(BSTNode<Integer , String> obj) {
                System.out.println(obj + " ");
            }
        });

//        BST.remove(2);
//        BST.remove(1);

//        BST.remove(5);
//        BST.remove(8);
//        BST.remove(7);

        System.out.println("-----------------------");
        System.out.println(test.levelOrder());
//        System.out.println(BST.successor(1));
//        System.out.println(BST.successor(2));
//        System.out.println(BST.successor(3));
//        System.out.println(BST.successor(5));
//        System.out.println(BST.successor(6));
//        System.out.println(BST.successor(7));
//        System.out.println(BST.successor(8));
        //System.out.println(BST.getHeight(BST.GetRoot()));
        //System.out.println(BST.lookupValue(3));
    }

    private int size = 0 ;
    private int height = -1 ;
    private BSTNode<K,V>root = null ;
    private Comparator comparator;

    public MyBinarySearchTree(){

    }
//    public  MyBinarySearchTree(K [] arr , V [] arr2){
//        root = new BSTNode<>(arr[(arr.length - 1)/2] , arr2[(arr.length - 1)/2]);
//        height++ ;
//        root.height = 0 ;
//    }
    public MyBinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }

    public int GetSize(){return size;}
    public BSTNode<K,V> GetRoot(){return root;}

    @Override
    public BSTNode<K, V> insert(K k, V v) {
        if(!(k instanceof Comparable)){
            throw new ClassCastException();
        }
        BSTNode<K,V>temp = new BSTNode<>(k , v);
        if(root == null){
           root = temp ;
           //height = 0 ;
           root.height = 0 ;
           size++;
           return root;
        }else{
           BSTNode<K,V> p = root ;
           while (true) {
               if (compare(p.key , k) > 0) {//新节点的key小于p
                   if (p.left == null) {
                       p.left = temp;
                       temp.parent = p;
                       temp.isLeftChild = true;
                       break;
                   }
                   p = p.left;
               } else if(compare(p.key , k) < 0){
                   if (p.right == null) {
                       p.right = temp;
                       temp.parent = p;
                       temp.isLeftChild = false;
                       break;
                   }
                   p = p.right;
               }else {
                   return p;
               }
           }
           size++;
           updateHeight(temp);
           return temp ;

       }
    }

    private void updateHeight(BSTNode<K,V> temp) {
        temp.height = temp.parent.height+1;
        //height = temp.height > height ? temp.height : height ;
    }

    @Override
    public void inorder(Consumer<BSTNode<K,V>> con) {
        if(root != null){
            inorder(root , con);
        }
    }

    public void inorder(BSTNode<K,V> p , Consumer<BSTNode<K,V>>con){
        if(p != null){
            inorder(p.left , con);
            con.accept(p);
            inorder(p.right , con);
        }
    }

    /**
     * 关于查找的性能优化方面，
     * 可添加一个参数为两个相对应的数组的构造函数
     * 应用三点中值法找出大致的中值并作为第一个节点创建
     * @param key
     * @return
     */
    @Override
    public V lookupValue(K key) {
        BSTNode<K,V> p = lookNode(key);
        return p == null ? null : p.value;
    }

    public BSTNode<K,V> lookNode(K key){
        BSTNode<K,V>p = root ;
        while (p != null){
            if(compare(p.key , key) == 0){
                return p ;
            }else if(compare(key , p.key) < 0){
                p = p.left ;
            }else {
                p = p.right ;
            }
        }
        return p;
    }

    @Override
    public BSTNode<K,V> min() {
        BSTNode<K,V>p = root ;
        if(p == null)return null;
        while (p.left !=null)p = p.left;
        return p;
    }

    @Override
    public BSTNode<K,V> max() {
        BSTNode<K,V>p = root ;
        if (p == null)return null;
        while (p.right != null)p = p.right ;
        return p;
    }

    @Override
    public void remove(K key) {
        BSTNode<K,V> p = lookNode(key);
        if(p != null){
            //叶子节点
            if(p.right == null && p.left == null){
                if(p.parent == null){
                    root = null ;
                    //height--;
                    size--;
                }else {
                    if(p.isLeftChild){
                        p.parent.left = null ;
                        size--;
                        //height的维护问题很大
                    }else {
                        p.parent.right = null ;
                        size--;
                    }
                }
            }else {
                if(p.parent == null){//p为根节点
                    if(p.left == null){
                        root = p.right ;
                        root.height = 0;
                        p.right.parent = null ;
                        size--;
                        updateNodePro(root.right);
                        updateNodePro(root.left);
                        //更新剩余节点的height值-1
                    }else if(p.right == null){
                        root = p.left ;
                        root.height = 0 ;
                        p.left.parent = null ;
                        size--;
                        updateNodePro(root.right);
                        updateNodePro(root.left);
                        //更新剩余节点的height值-1
                    }else {
                        BSTNode<K,V>temp = p.right;
                        root = temp ;
                        root.height = 0 ;
                        temp.parent = null ;
                        size--;
                        while (temp.left != null){
                            temp = temp.left;
                        }
                        temp.left = p.left;
                        p.left.parent = temp;
                        updateNodePro(root.right);
                        updateNodePro(root.left);
                        //更新所有节点的height值
                    }
                }else {
                    if(p.isLeftChild){
                        if(p.left == null){
                            //更新以p为根节点的所有节点的height值-1
                            BSTNode<K,V>temp = p.right ;
                            p.right.parent = p.parent;
                            p.parent.left = p.right;
                            size--;
                            updateNodePro(temp);
                        }else if(p.right == null){
                            //节点高度更新
                            BSTNode<K,V>temp = p.left ;
                            p.left.parent = p.parent ;
                            p.parent.left = p.left ;
                            size--;
                            updateNodePro(temp);
                        } else {
                            BSTNode<K,V>temp = p.left ;
                            BSTNode<K,V>tempu = p.left ;
                            while (temp.right != null){
                                temp = temp.right ;
                            }
                            temp.right = p.right ;
                            p.right.parent = temp ;
                            p.left.parent = p.parent;
                            p.parent.left = p.left;
                            size--;
                            //更新节点height值
                            updateNodePro(tempu);
                        }
                    }else {
                        if(p.left == null){
                            BSTNode<K,V>temp = p.right ;
                            p.right.parent = p.parent ;
                            p.parent.right = p.right ;
                            size--;
                            updateNodePro(temp);
                        }else if(p.right == null){
                            BSTNode<K,V>temp = p.left ;
                            p.left.parent = p.parent;
                            p.parent.right = p.left ;
                            size--;
                            updateNodePro(temp);
                        }else {
                            BSTNode<K,V>tempu = p.left ;
                            BSTNode<K,V>temp = p.left ;
                            while (temp.right != null){
                                temp = temp.right ;
                            }
                            temp.right = p.right ;
                            p.right.parent = temp ;
                            p.left.parent = p.parent;
                            p.parent.right = p.left;
                            size--;
                            updateNodePro(tempu);
                        }
                    }
                }
            }
        }
    }

    private void updateNodePro(BSTNode<K,V> node){
        if(node != null) {
            node.height = node.parent.height + 1;
            updateNodePro(node.left);
            updateNodePro(node.right);
        }
    }

    @Override
    public BSTNode<K,V> successor(K x) {
        BSTNode<K,V> p = lookNode(x) ;
        if(p != null){
            if(p.right == null){
                BSTNode<K,V>temp = p ;
                while (p != null){
                   if( p.isLeftChild){
                       return p.parent ;
                   }
                   p = p.parent ;
                }
            }else{
                BSTNode<K,V> temp = p.right ;
                while (temp.left != null){
                    temp = temp.left ;
                }
                return temp ;
            }
        }
        return null ;
    }

    @Override
    public BSTNode<K,V> predecessor(K x) {
        BSTNode<K,V> p = lookNode(x);
        if(p != null){
            if(p.left == null){
                BSTNode<K,V> temp = p ;
                while (temp != null){
                    if(!temp.isLeftChild){
                        return temp.parent ;
                    }
                    temp = temp.parent ;
                }
            }else {
                BSTNode<K,V> temp = p.left ;
                while (temp.right != null){
                    temp = temp.right ;
                }
                return temp ;
            }
        }
        return null ;
    }

    @Override
    public boolean isBalance() {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    @Override
    public int getHeight(BSTNode<K, V> p) {
        if(p == null)return 0;
        int h = 0 ;
        int max = max(getHeight(p.left) , getHeight(p.right));
        h = max(h , max);
        return h+1 ;
    }

    private int max(int h, int max) {
        return h > max ? h : max ;
    }

    public void SetRoot(BSTNode<K,V> p){
        root = p ;
        if(root != null){
            root.isRed = false ;
        }

    }

    @Override
    public List<List<BSTNode<K, V>>> levelOrder() {
        List<List<BSTNode<K,V>>> re = new ArrayList<>() ;
        List<BSTNode<K,V>> re_temp = new ArrayList<>() ;
        Queue<BSTNode<K,V>> queue = new LinkedList<>() ;

        if(root != null)
            queue.add(root);

        BSTNode<K,V> p , node ;
        p = node = root ;
        while (queue.size() != 0){
            BSTNode<K , V> temp = queue.poll();

            if(temp.left != null){
                queue.add(temp.left);
                node = temp.left ;
            }
            if(temp.right != null){
                queue.add(temp.right);
                node = temp.right ;
            }

            re_temp.add(temp) ;
            if(temp == p){
                re.add(re_temp);
                re_temp = new ArrayList<>() ;
                p = node ;
            }
        }
        return re ;
    }

    public int compare(K key1, K key2) {
        if (null == comparator) {
            return ((Comparable) key1).compareTo((Comparable) key2);
        } else {
            return comparator.compare(key1, key2);
        }
    }

    public void reverse( BSTNode<K,V> node){
        if(node == null)return;
        reverse(node.left);
        reverse(node.right);
        
        BSTNode<K,V>left = node.left ;
        BSTNode<K,V>right = node.right ;
        if(left == null && right == null){
            //什么都不用做
        }else if(left == null){
            node.left = right ;
            right.isLeftChild = true ;
            node.right = null ;
        }else if(right == null){
            node.right = left ;
            left.isLeftChild = false ;
            node.left = null ;
        }else {
            node.right = left ;
            left.isLeftChild = false ;
            node.left = right ;
            right.isLeftChild = true ;
        }
    }

    private BSTNode<K,V> CreatMinHeight(K [] arr  , int  left , int right){//数组传入之前请先进行排序
        if(right < left )return null ;
        int mid = left + ((right - left)>>1) ;
        BSTNode<K,V> leftNode = CreatMinHeight(arr , left , mid - 1) ;
        BSTNode<K ,V> rightNode = CreatMinHeight(arr , mid + 1 , right) ;
        BSTNode<K, V>node = new BSTNode<K,V>(arr[mid] , null) ;
        node.left = leftNode ;
        if(leftNode != null){
            leftNode.parent = node;
            leftNode.isLeftChild = true;
        }
        node.right = rightNode ;
        if(rightNode != null){
            rightNode.parent = node;
            rightNode.isLeftChild = false;
        }
        return node ;

    }

    private K tempvalue = null ;
    private boolean flag = true ;

    private void Check(BSTNode<K, V> node){
        if (node == null)return;
        if(flag){
            Check(node.left);
            if (tempvalue == null || compare(node.key, tempvalue) > 0) {
                tempvalue = node.key;
            } else {
                flag = false;
            }
            Check(node.right);
        }
    }

}

/***
 * 关于照原样输出的问题
 * n为树的高度（从1开始计算）,level为树的当前层数（从一开始）
 * 则在level层,左边第一个元素空的空数为2^(n - level) - 1 (满二叉树);
 * level层第一个元素为2^(level - 1)
 * level层元素间的空数为2^(n+1-level)-1
 * 每层元素2^(level-1)
 * 对其返回的集合遍历输出即可
 */
