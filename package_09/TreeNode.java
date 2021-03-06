package package_09;

import java.util.List;

public class TreeNode<E> {
    public E data ;
    public TreeNode<E> parent ;
    public List<TreeNode<E>> children ;

    public TreeNode(E data , TreeNode<E> parent){
        this.data = data ;
        this.parent = parent ;
    }
    public TreeNode(E data){this.data = data ;}

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
