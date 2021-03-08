package package_09;

import java.util.List;
import java.util.function.Consumer;

public interface IBinarySearchTree<K , V> {
    /**
     * 新增节点
     * @param k 关键字
     * @param v 值
     */
    BSTNode<K, V> insert(K k, V v);
    /**
     * 中序遍历
     *
     * @param con
     *          处理中序遍历的每个元素的函数
     */
    void inorder(Consumer<BSTNode<K,V>> con);
    /**
     * 查找元素
     * @param key
     * @return
     */
    V lookupValue(K key);
    /**
     * 获取最小关键字
     * @return
     */
    BSTNode<K,V> min();
    /**
     * 获取最大关键字
     * @return
     */
    BSTNode<K,V> max();

    /**
     * 移除关键字对应的节点
     * @param key
     */
    void remove(K key);

    /**
     * x的后继——比x大的第一个元素
     * 1、是其右子树的最小值
     * 2、没有右子树，则向上追溯，直到某个祖先节点是左孩子，返回这个祖先节点的父节点，它就是x的后继
     * @param x
     * @return
     */
    BSTNode<K,V> successor(K x);

    /**
     * 前驱
     * @param x 关键字
     * @return
     */
    BSTNode<K,V> predecessor(K x);

    boolean isBalance();

    /**
     * 返回节点数
     * @return
     */
    int getSize();

    /**
     * 高度
     * @return
     */
    int getHeight();
    int getHeight(BSTNode<K,V> p);

    List<List<BSTNode<K, V>>> levelOrder();
}
