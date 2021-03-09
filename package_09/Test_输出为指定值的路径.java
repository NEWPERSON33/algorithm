package package_09;


import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * 初始化BSTNode为<Integer , String>
 */
public class Test_输出为指定值的路径 {
    public static void main(String[] args) {
        AVLTree<Integer , String> tree = new AVLTree<>() ;
        for (int i = 0; i < 10; i++) {
            tree.insert(i , null) ;
        }
//        tree.inorder(tree.GetRoot(), new Consumer<BSTNode<Integer, String>>() {
//            @Override
//            public void accept(BSTNode<Integer, String> node) {
//                System.out.println(node);
//            }
//        });
        printPath(tree.GetRoot() , 19);
    }

    static public ArrayList<ArrayList<BSTNode<Integer , String>>>res = new ArrayList<>() ;
    private static void printPath(BSTNode<Integer , String> node , int target , ArrayList<BSTNode<Integer , String>>arr){
        if(node == null)return;
        if(node.left == null && node.right == null){
            if(target - node.key == 0){
                arr.add(node);
                res.add(arr) ;
            }
            return;
        }
        ArrayList<BSTNode<Integer , String>> temp = new ArrayList<>() ;
        temp.addAll(arr) ;
        temp.add(node) ;
        printPath(node.left , target - node.key , temp);
        printPath(node.right , target - node.key , temp);
    }

    private static void printPath(BSTNode<Integer , String > node , int target){
        res.clear();
        ArrayList<BSTNode<Integer , String >> arr = new ArrayList<>() ;
        printPath(node , target , arr);
        System.out.println(res);
    }

}
