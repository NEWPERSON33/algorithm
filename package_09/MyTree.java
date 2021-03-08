package package_09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTree<E> implements ITree<E> {
    private int size = 0 ;
    private TreeNode<E> root;

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("root");
        MyTree<String> mtree = new MyTree<>(root);
        TreeNode<String>node1 = new TreeNode<>("1");
        TreeNode<String>node2 = new TreeNode<>("2");
        TreeNode<String>node11 = new TreeNode<>("11");
        TreeNode<String>node12 = new TreeNode<>("12");
        TreeNode<String>node13 = new TreeNode<>("13");
        TreeNode<String>node14 = new TreeNode<>("14");
        TreeNode<String>node21 = new TreeNode<>("21");
        TreeNode<String>node22 = new TreeNode<>("22");
//        mtree.insertChild(root , node1);
//        mtree.insertChild(root , node2);
//        mtree.insertChild(node1 , node11);
//        mtree.insertChild(node1 , node12);
//        mtree.insertChild(node2 , node13);
//        mtree.insertChild(node2 , node14);
//        mtree.insertChild(node11 , node21);
//        mtree.insertChild(node12 , node22);
//        int height = mtree.getHeight(root);
        System.out.println(mtree.levelOrder());
    }

    public MyTree(TreeNode<E>root){
        this.root = root ;
        size++;
    }
    private int max(int a , int b){
        return a > b ? a : b ;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public TreeNode<E> getParent(TreeNode<E> x) {
        return x.parent;
    }

    @Override
    public TreeNode<E> getFirstChild(TreeNode<E> x) {
        if(x.children != null){
            return x.children.get(0);
        }
        return null;
    }

    @Override
    public TreeNode<E> getNextSibling(TreeNode<E> x) {
        TreeNode<E>pre = x.parent ;
        for (int i = 0; i < pre.children.size(); i++) {
            if(pre.children.get(i) == x){
                if(i+1 == pre.children.size()){
                    return null;
                }
                return pre.children.get(i+1);
            }
        }
        return null;
    }

    @Override
    public int getHeight(TreeNode<E> x) {
        if(x.children == null)return 1 ;
        int h = 0 ;
        for (int i = 0; i < x.children.size(); i++) {
            h = max(h , getHeight(x.children.get(i)));
        }
        return h + 1 ;
    }

    @Override
    public void insertChild(TreeNode<E> x, TreeNode<E> child) {
        if(x.children == null) {
            x.children = new ArrayList<>();
        }
        x.children.add(child);
        child.parent = x ;
        size++;
    }

    @Override
    public void deleteChild(TreeNode<E> x, int i) {
        x.children.remove(i);
        size--;
    }

    @Override
    public List<TreeNode<E>> preOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> postOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<List<TreeNode<E>>> levelOrder(TreeNode<E> x) {
        List<List<TreeNode<E>>> re =new ArrayList<>() ;
        List<TreeNode<E>>templist = new ArrayList<>() ;
        Queue<TreeNode<E>> queue = new LinkedList<>() ;
        queue.add(x) ;
        TreeNode<E> last = x ;
        TreeNode<E> p = null ;

        while (!queue.isEmpty()){
            TreeNode<E> temp = queue.poll();
            templist.add(temp);
            if(temp.children != null){
                queue.addAll(temp.children);
                p = temp.children.get(temp.children.size() - 1);
            }
            if(last == temp){
                last = p ;
                re.add(templist);
                templist= new ArrayList<>();
            }
        }
        return re ;
    }

    @Override
    public List<List<TreeNode<E>>> levelOrder() {
        return levelOrder(root);
    }
}
