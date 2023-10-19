package algorithm.BinaryTree;

//二叉树的单个节点类
public class BinaryTreeNode<T> {
    //private必须通过setter getter来访问
    private T val;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    /**
     * Creates a binary node as a leaf node.
     * */
    public BinaryTreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * Creates a binary node with a left child and a right child (nullable).
     * */
    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
