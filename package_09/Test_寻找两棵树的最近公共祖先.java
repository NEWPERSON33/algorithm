package package_09;

/**
 * 禁用parent且不使用额外的数据结构
 * 且假设这两个节点均存在于树上
 * 需要实例化BSTNode为<Integer , String>
 */
public class Test_寻找两棵树的最近公共祖先 {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer , String>test = new MyBinarySearchTree<>() ;
        test.insert(10,null);
        BSTNode<Integer , String> node1 = test.insert(30,null);
        test.insert(11,null);
        test.insert(-2,null);
        BSTNode<Integer , String> node2 = test.insert(-1,null);
        System.out.println(Findforebear(test.GetRoot() , node1 , node2));
    }

    private static BSTNode<Integer , String > Findforebear(BSTNode<Integer , String > root ,
                                                           BSTNode<Integer , String>S1 , BSTNode<Integer , String>S2){
        if(root == null)return null ;
        if(root.equals(S1) || root.equals(S2))return root ;
        boolean S1isinLeft = isForebear(root.left , S1) ;
        boolean S2isinRight = isForebear(root.right , S2) ;
        if(S1isinLeft == S2isinRight){
            return root ;
        }else if(S1isinLeft){
            return Findforebear(root.left , S1 , S2) ;
        }else {
            return Findforebear(root.right , S1 , S2) ;
        }
    }

    private static boolean isForebear(BSTNode<Integer , String>node , BSTNode<Integer , String>target){
        if(node == null)return false ;
        if(node.equals(target))return true ;
        return isForebear(node.left , target) || isForebear(node.right , target) ;
    }

    //特殊解法,尚未掌握
    private static BSTNode<Integer , String > Findforebearpro(BSTNode<Integer , String > root ,
                                                              BSTNode<Integer , String>S1 , BSTNode<Integer , String>S2){
        if(root == null)return null ;
        if(root.equals(S1) && root.equals(S2))return root ;

        BSTNode<Integer , String > x = Findforebearpro(root.left , S1 , S2) ;
        if(x != null && !x.equals(S1) && !x.equals(S2))return x ;

        BSTNode<Integer , String > y = Findforebearpro(root.right , S1 , S2) ;
        if(y != null && !y.equals(S1) && !y.equals(S2))return y ;

        if(x != null && y != null)return root ;
        else if(root.equals(S1) || root.equals(S2))return root;
        else {
            return x == null ? y : x ;
        }
    }

}
