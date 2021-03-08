package package_09;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
/*
红黑树的性质
1.所有节点都是红色或者黑色
2.根节点为黑色
3.所有的 NULL 叶子节点都是黑色
4.如果该节点是红色的，那么该节点的子节点一定都是黑色
5.所有的 NULL 节点到根节点的路径上的黑色节点数量一定是相同的

 */

/**
 * 注意，在向上递归调整的过程中，有些在单个case中的孩子为空的情况，也有可能为黑
 * @param <K>
 * @param <V>
 */
public class RedBlackTree<K , V> extends MyBinarySearchTree<K,V> {


    public static void main(String[] args) {
        RedBlackTree<Integer , String > test = new RedBlackTree<>();
        test.insert(1,"null");
        test.insert(5,null);
        test.insert(2,null);
        test.insert(3,"three");
        test.insert(8,null);
        test.insert(6,null);
        //test.insert(7,null);
        //test.insert(10,null);
        //test.insert(30,null);
        //test.insert(11,null);
        //test.insert(-2,null);
        //test.insert(-1,null);
        test.remove(11);
        test.remove(-2);
        test.remove(1);
        test.remove(-1);
        List<List<BSTNode<Integer , String >>> p = test.levelOrder();
        test.inorder(test.GetRoot(), new Consumer<BSTNode<Integer,String>>() {
            @Override
            public void accept(BSTNode<Integer , String> obj) {
                System.out.println(obj + " ");
            }
        });
        System.out.println("-----------------");
        for (List<BSTNode<Integer , String >> l: p) {
            System.out.println(l);
        }
        System.out.println("---------------------");
        System.out.println(test.getleaves());
    }

    public BSTNode<K,V> insert(K key , V value){
        BSTNode<K, V> p = super.insert(key , value) ;
        maintain(p);
        return p ;
    }

    private void maintain(BSTNode<K,V> p) {
        if(p.parent == null){
            p.isRed = false ;
        }else if(p.parent.isRed){
            BSTNode<K,V> parent = p.parent ;
            BSTNode<K,V> grand = parent.parent ;
            BSTNode<K,V> uncle = parent.isLeftChild ? grand.right : grand.left ;
            if(uncle != null && uncle.isRed && parent.isRed){//父亲和叔叔均为红色节点
                parent.isRed = false ;
                uncle.isRed = false ;
                grand.isRed = true ;
                maintain(grand);
            }else  {//uncle为空等价于为黑
                if(parent.isLeftChild && p.isLeftChild) {//左左型
                    parent.isRed = !parent.isRed ;
                    grand.isRed = !grand.isRed ;
                    RightRotate(grand , parent);
                    maintain(parent);
                }else if(!parent.isLeftChild && !p.isLeftChild) {//右右型
                    parent.isRed = !parent.isRed ;
                    grand.isRed = !grand.isRed ;
                    LeftRotate(grand , parent);
                    maintain(parent);
                }else if(parent.isLeftChild && !p.isLeftChild){//左右型
                    LeftRotate(parent , p);
                    p.isRed = !p.isRed ;
                    grand.isRed = !grand.isRed ;
                    RightRotate(grand , p);
                    maintain(p);
                }else if(!parent.isLeftChild && p.isLeftChild){//右左型
                    RightRotate(parent , p);
                    p.isRed = !p.isRed ;
                    grand.isRed = !grand.isRed ;
                    LeftRotate(grand , p);
                    maintain(p);
                }
            }
        }
    }



    @Override
    public void remove(K key) {
        BSTNode<K,V>node = lookNode(key) ;
        if(node == null)return;
        if(node.left != null && node.right != null){
            BSTNode<K, V> DeleteNode = node.right ;
            while (DeleteNode.left != null){
                DeleteNode = DeleteNode.left ;
            }
            node.key = DeleteNode.key ;
            node.value = DeleteNode.value ;
            if(DeleteNode.isRed){//删除节点为红色
                if(DeleteNode.isLeftChild){
                    DeleteNode.parent.left = null ;
                }else {
                    DeleteNode.parent.right = null ;
                }
                return;
            }else {//删除节点为黑色
                if(DeleteNode.right != null){//有一个孩子
                    BSTNode<K,V>hischild = DeleteNode.right ;
                    DeleteNode.right.isRed = DeleteNode.isRed ;
                    DeleteNode.isRed = !DeleteNode.isRed ;
                    LeftRotate(DeleteNode , hischild);
                    hischild.left = null ;
                    return;
                }else {//为叶子节点
                    DeleteBlack(DeleteNode);
                }
            }

        }else if(node.left == null && node.right == null){
            if(node.parent == null){//是根节点，直接删除
                super.SetRoot(null);
            }else {
                if(node.isRed){//节点为红色直接删除
                    if(node.isLeftChild){
                        node.parent.left = null ;
                    }else{
                        node.parent.right = null ;
                    }
                }else {//节点为黑色则为黑色叶子情况
                    DeleteBlack(node);
                }
            }
        }else {//只有一边此节点必定为黑,孩子必定为红，且仅有一个
            BSTNode<K,V>child = node.left == null ? node.right : node.left ;
             if (node.parent == null){//此节点为根节点
                 child.parent = null ;
                 super.SetRoot(child);
             }else {
                 BSTNode<K,V>parent = node.parent ;
                 if(node.isLeftChild){
                     parent.left = child ;
                     child.parent = parent ;
                     child.isLeftChild = true ;
                     child.isRed = false ;
                 }else {
                     parent.right = child ;
                     child.parent = parent ;
                     child.isLeftChild = false ;
                     child.isRed = false ;
                 }
             }
        }
    }

    private void DeleteBlack(BSTNode<K,V> node){//删除黑色叶子节点
        BSTNode<K,V>DeleteNode = node ;
        while (DeleteNode!=super.GetRoot()){
            BSTNode<K,V>parent = DeleteNode.parent ;
            BSTNode<K,V>brother = DeleteNode.isLeftChild ? parent.right : parent.left ;
           if(DeleteNode.isLeftChild){//为左孩子
               if(brother.isRed){//兄弟为红色
                   case5(DeleteNode) ;
                   break;
               }else {
                   if((brother.left == null && brother.right == null) ||(brother.left != null && brother.right != null
                           && !brother.left.isRed && !brother.right.isRed)){//兄弟节点的子节点全为黑(包括全为空以及全为黑两种)
                       if(parent.isRed){//父节点为红色
                           case4(DeleteNode) ;
                           break;
                       }else {
                           DeleteNode = case4_1(DeleteNode) ;
                           continue;
                       }
                   } else if(brother.right != null && brother.right.isRed){//兄弟有一个同边的红孩子
                       if(brother.left != null && brother.left.isRed){
                           case3(DeleteNode);
                           break;
                       }
                       case1(DeleteNode);
                       break;
                   }else if (brother.left != null && brother.left.isRed ){//兄弟有一个异边的红孩子
                       case2(DeleteNode) ;
                       break;
                   }
               }
           }else {//DeleteNode为右孩子
               if(brother.isRed){//兄弟为红
                   case5(DeleteNode) ;
                   break;
               }else {
                   if((brother.left == null && brother.right == null) ||(brother.left != null && brother.right != null
                           && !brother.left.isRed && !brother.right.isRed)){//兄弟节点的子节点全为黑(包括全为空以及全为黑两种)
                       if(parent.isRed){//父节点为红色
                           case4(DeleteNode) ;
                           break;
                       }else {
                           DeleteNode = case4_1(DeleteNode) ;
                           continue;
                       }
                   }else if(brother.left != null && brother.left.isRed){//兄弟有一个同边的红孩子
                       if(brother.right != null && brother.right.isRed){
                           case3(DeleteNode) ;
                           break;
                       }
                       case1(DeleteNode) ;
                       break;
                   }else if(brother.right != null && brother.right.isRed){//兄弟有一个异边的红孩子
                       case2(DeleteNode) ;
                       break;
                   }
               }
           }
        }
        //循环退出后删除节点
        if(node.isLeftChild){
            node.parent.left = null ;
        }else {
            node.parent.right = null ;
        }
    }

    private BSTNode<K,V> case1(BSTNode<K,V>node){//父亲节点为黑或者红，兄弟为黑，兄弟有一个与其同边的孩子
        BSTNode<K,V>parent = node.parent ;
        BSTNode<K,V>brother = node.isLeftChild ? parent.right : parent.left ;
        BSTNode<K,V>brother_SSide = brother.isLeftChild? brother.left : brother.right ;
        if(node.isLeftChild){//是左孩子
            //将parent的颜色赋给brother并将brother的右孩子和parent染黑
            brother.isRed = parent.isRed ;
            parent.isRed = false ;
            brother_SSide.isRed = false ;
            LeftRotate(parent , brother);
            return brother ;
        }else {//是右孩子
            brother.isRed = parent.isRed ;
            parent.isRed = false ;
            brother_SSide.isRed = false ;
            RightRotate(parent , brother);
            return brother ;
        }
    }

    private  BSTNode<K, V> case2(BSTNode<K,V>node){//兄弟为黑，兄弟有一个与其异边的孩子
        BSTNode<K,V>parent = node.parent ;
        BSTNode<K,V>brother = node.isLeftChild ? parent.right : parent.left ;
        BSTNode<K,V>brother_NSide = brother.isLeftChild? brother.right : brother.left ;
        if(node.isLeftChild){//是左孩子
            //将兄弟与其孩子反色并右旋
            brother.isRed = !brother.isRed ;
            brother_NSide.isRed = !brother_NSide.isRed ;
            RightRotate(brother , brother_NSide);
            return case1(node);
        }else {
            brother.isRed = !brother.isRed ;
            brother_NSide.isRed = !brother_NSide.isRed ;
            LeftRotate(brother , brother_NSide);
            return case1(node) ;
        }
    }

    private BSTNode<K, V> case3(BSTNode<K,V>node){//兄弟有两个孩子(这两个孩子必定为红)
        BSTNode<K,V>parent = node.parent ;
        BSTNode<K,V>brother = node.isLeftChild ? parent.right : parent.left ;
        BSTNode<K,V>Bleft = brother.left ;
        BSTNode<K,V>Bright = brother.right ;
        if(node.isLeftChild){//是左孩子
            brother.isRed = parent.isRed ;
            parent.isRed = false ;
            Bright.isRed = false ;
            LeftRotate(parent , brother);
            return brother ;
        }else {//是右孩子
            brother.isRed = parent.isRed ;
            parent.isRed = false ;
            Bleft.isRed = false ;
            RightRotate(parent , brother);
            return brother ;
        }
    }

    private BSTNode<K, V> case4(BSTNode<K,V>node){//brother无子节点,且其父亲为红色
        BSTNode<K,V>parent = node.parent ;
        BSTNode<K,V>brother = node.isLeftChild ? parent.right : parent.left ;

        parent.isRed = false ;
        brother.isRed = true ;
        return parent ;

    }

    private BSTNode<K,V> case4_1(BSTNode<K,V>node){//brother无子节点，且其父亲为黑色（改完需要递归）
        BSTNode<K,V>parent = node.parent ;
        BSTNode<K,V>brother = node.isLeftChild ? parent.right : parent.left ;
        parent.isRed = false ;
        brother.isRed = true ;
        return parent ;
    }



    private BSTNode<K, V> case5(BSTNode<K,V>node){//兄弟节点为红
        BSTNode<K,V>parent = node.parent ;
        BSTNode<K,V>brother = node.isLeftChild ? parent.right : parent.left ;
        BSTNode<K,V>Bleft = brother.left ;
        BSTNode<K,V>Bright = brother.right ;
        if(node.isLeftChild){//是左孩子

            brother.isRed = !brother.isRed ;
            parent.isRed = !parent.isRed ;
            LeftRotate(parent , brother);
            if(node.parent.right.left == null && node.parent.right.right == null){
                return case4(node);
            }
            if(node.parent.right.left == null){//有一个同边的孩子
                return case1(node);
            }
            if(node.parent.right.right == null) {//有一个异边的孩子
                return case2(node);
            }

            return case3(node) ;

        }else {
            brother.isRed = !brother.isRed ;
            parent.isRed = !parent.isRed ;
            RightRotate(parent , brother);
            if(node.parent.left.left == null && node.parent.left.right == null){
                return case4(node);
            }
            if(node.parent.left.right == null){
                return case1(node) ;
            }
            if(node.parent.left.left == null){
                return case2(node) ;
            }
            return case3(node) ;
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

    private void RightRotate(BSTNode<K,V> p1, BSTNode<K,V> p2) {

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

//    private int getleaves(){
//        if(super.GetRoot() == null){
//            return 0 ;
//        }
//        cnt = 0 ;
//        //return countOfleaves(super.GetRoot());
//        countOfleaves(super.GetRoot()) ;
//        return cnt ;
//    }

//    private int cnt = 0 ;
//    private void countOfleaves(BSTNode<K,V> node){
//        if(node == null)return;
//        if(node.left == null && node.right == null){
//            cnt++;
//            return;
//        }
//        countOfleaves(node.left);
//        countOfleaves(node.right);
//    }

    private int countOfleaves(BSTNode<K,V> node){
        if(node == null )return 0 ;
        if(node.left == null && node.right == null){
            return 1 ;
        }
        return countOfleaves(node.left) + countOfleaves(node.right) ;
    }

    private int getleaves(){//计算叶子结点的数目
        if(super.GetRoot() == null){
            return 0 ;
        }
        return countOfleaves(super.GetRoot()) ;
    }

    /**
     * 未完成工程
     * 反转二叉树，两棵二叉树是否相同是否互为镜像
     * @param lower
     * @param upper
     * @param set
     * @param node
     */
    private void getspan(K lower , K upper , Set<BSTNode<K,V>> set , BSTNode<K,V> node){
        if(node == null)return;
        if(compare(lower, node.key) < 0)getspan(lower , upper , set , node.left);
        if(compare(lower , node.key)<=0 && compare(node.key , upper) <= 0)set.add(node) ;
        if(compare(node.key , upper) < 0)getspan(lower , upper , set , node.right);

    }

}


