package package_09;

import java.util.function.Consumer;

//丢弃节点自带的height属性，维护起来太麻烦
public class AVLTree<K,V> extends MyBinarySearchTree<K,V>implements IBinarySearchTree<K,V> {

    public static void main(String[] args) {
        AVLTree<Integer,String > test = new AVLTree<>();
        test.insert(1,"null");
        test.insert(5,null);
        test.insert(2,null);
        test.insert(3,"three");
        test.insert(8,null);
        test.insert(6,null);
        test.insert(7,null);
        test.insert(10,null);
        test.insert(30,null);
        test.insert(11,null);
        //test.insert(-2,null);
        //test.insert(-1,null);
        test.remove(11);
        test.remove(6);
        test.remove(7);
        test.remove(5);
        boolean C = test.isBalance();
        test.inorder(test.GetRoot(), new Consumer<BSTNode<Integer,String>>() {
            @Override
            public void accept(BSTNode<Integer , String> obj) {
                System.out.println(obj + " ");
            }
        });
        System.out.println(test.levelOrder());
        test.sum_special("" , test.GetRoot());
        System.out.println(test.SUM);
    }

    public BSTNode<K,V> insert(K key , V value){
        BSTNode<K,V> p = super.insert(key , value);
        //System.out.println(super.GetRoot());
        BSTNode<K,V> [] objs = firstUnBalance(p);
        if(objs != null){
            reBalance(objs);
        }
        return p;
    }

    private BSTNode<K,V>[] firstUnBalance(BSTNode<K,V> p) {
        if(p == null)return null;
        BSTNode<K,V> q = p.parent ;
        if(q == null)return null;
        BSTNode<K,V>s = q.parent ;
        if(s == null)return null;
        if(UnBalance(s)){
            return new BSTNode[]{s,q,p};
        }else {
            return firstUnBalance(q);
        }
    }

    private boolean UnBalance(BSTNode<K,V> p) {
        int a = getHeight(p.right);
        int b = getHeight(p.left);
        return Math.abs(a-b) > 1;
    }

    @Override
    public void remove(K key) {
        BSTNode<K,V> node = lookNode(key);
        BSTNode<K,V> parent = node.parent ;
        //BSTNode<K,V> left = node.left ;
        //BSTNode<K,V> right = node.right ;
        if(node.left == null && node.right == null){//说明要删除的是叶子节点
            super.remove(key);
            if(parent == null){
                super.SetRoot(null);
            }
            reBalance(parent);
        }else if(node.right == null){
            BSTNode<K,V> temp = node.left ;
            while (temp.right != null){
                temp = temp.right ;
            }
            BSTNode<K , V>predecessor = temp.parent ;
            super.remove(temp.key);
            node.key = temp.key ;
            node.value = temp.value ;

            reBalance(predecessor);
        }else {
            BSTNode<K,V>temp = node.right ;
            while (temp.left != null){
                temp = temp.left ;
            }
            BSTNode<K , V> predecessor = temp.parent ;
            super.remove(temp.key);
            node.key = temp.key ;
            node.value = temp.value ;
            reBalance(predecessor);

        }
    }

    @Override
    public boolean isBalance() {
        return !UnBalance(super.GetRoot());
    }

    public void reBalance(BSTNode<K,V> p){
        if(p == null)return;
        int left = getHeight(p.left);
        int right = getHeight(p.right);
        if(right - left > 1){
            LeftRotate(p , p.right);
            reBalance(p.right);
        }else if(left - right > 1){
            RightRotate(p , p.left);
            reBalance(p.left);
        }else {
            reBalance(p.parent);
        }
    }

    /**
     * 插入节点是，对其包括自身在内的祖孙三代进行形态的具体分析如驼峰型和一致型
     * @param p
     */
    public void reBalance(BSTNode<K,V> [] p){
        if(p == null)return;
        BSTNode<K,V>flag1 = p[0];
        BSTNode<K,V>flag2 = p[1];
        BSTNode<K,V>flag3 = p[2];
        if(flag2.isLeftChild && flag3.isLeftChild){//两左
            RightRotate(flag1 , flag2);
        }else if(!flag2.isLeftChild && !flag3.isLeftChild){//两右
            LeftRotate(flag1 , flag2);
        }else if(flag2.isLeftChild && !flag3.isLeftChild){//左右
            LeftRotate(flag2 , flag3);
            RightRotate(flag1 , flag3);
        }else if(!flag2.isLeftChild && flag3.isLeftChild){//右左
            RightRotate(flag2 , flag3);
            LeftRotate(flag1 , flag3);
        }
    }




    private void LeftRotate(BSTNode<K,V> p1, BSTNode<K,V> p2) {



        BSTNode<K,V> parent_p1 = p1.parent;//未变形前p1的父节点
        BSTNode<K,V> p2_left = p2.left ;
        if(p2_left != null){
            p2_left.parent = null ;
        }
        //断开需要更改的节点的所有链接
        p1.right = null ;
        p1.parent = null ;
        if(parent_p1 != null){
            if (p1.isLeftChild) {
                parent_p1.left = null;
            } else {
                parent_p1.right = null;
            }
        }

        p2.parent = null ;
        p2.left = null ;

        //此时，所有需更改节点的相关链接已断开

        p2.left = p1 ;
        p1.parent = p2 ;
        p1.right = p2_left;
        if(p2_left != null){
            p2_left.parent = p1 ;
        }
        //自此，反转完成，即将与首节点建立连接
        if(parent_p1 != null){
            p2.parent = parent_p1 ;
            if(p1.isLeftChild){
                parent_p1.left = p2 ;
                p2.isLeftChild = true ;
            }else {
                parent_p1.right = p2 ;
                p2.isLeftChild = false ;
            }
            //开始确定位置
            //p2.isLeftChild = true ;
            p1.isLeftChild = true ;
            if(p2_left != null){
                p2_left.isLeftChild = false ;
            }
        }else {
            p1.isLeftChild = true ;
            p2.isLeftChild = false ;
            if(p2_left != null)
                p2_left.isLeftChild = false ;
            super.SetRoot(p2);
        }

    }

    private void RightRotate(BSTNode<K,V> p1, BSTNode<K,V> p2)  {

        BSTNode<K,V> parent_p1 = p1.parent;
        BSTNode<K,V> p2_right = p2.right ;
        if(p2_right != null){
            p2_right.parent = null ;
        }
        p1.left = null ;
        p1.parent = null ;
        if(parent_p1 != null){
            if (p1.isLeftChild) {
                parent_p1.left = null;
            } else {
                parent_p1.right = null;
            }
        }
        p2.parent = null ;
        p2.right = null ;

        p2.right = p1 ;
        p1.parent = p2 ;
        p1.left = p2_right;
        if(p2_right != null){
            p2_right.parent = p1 ;
        }

        if(parent_p1 != null) {
            p2.parent = parent_p1;
            if (p1.isLeftChild) {
                parent_p1.left = p2;
                p2.isLeftChild = true ;
            } else {
                parent_p1.right = p2;
                p2.isLeftChild = false ;
            }
            //开始确定位置
            p1.isLeftChild = false;
            //p2.isLeftChild = false;
            if (p2_right != null) {
                p2_right.isLeftChild = true;
            }
        }else {
            p1.isLeftChild = false ;
            p2.isLeftChild = false ;
            if(p2_right != null)
                p2_right.isLeftChild = true ;
            super.SetRoot(p2);
        }

    }

    public int SUM = 0 ;
    public void sum_special(String  str  , BSTNode<K , V> node){
        if(node == null)return;
        if(node.left == null && node.right == null){
            str+=node.key.toString() ;
            int temp = Integer.parseInt(str) ;
            SUM+=temp ;
            return;

        }
        sum_special(str + node.key.toString() , node.left);
        sum_special(str + node.key.toString() , node.right);
    }

}
/**
 * 注意，翻转以后作为头的节点是左还是右取决于翻转之前的头节点是左孩子还是右孩子
 */
