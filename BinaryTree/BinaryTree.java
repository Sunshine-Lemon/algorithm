package algorithm.BinaryTree;

import java.util.*;

public class BinaryTree<T> {
    //数据域为一棵二叉树的根节点,一旦赋值便不可改动
    private final BinaryTreeNode<T> root;

    /**
     * Creates a binary tree with a binary node as its root.
     */
    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历(根左右)：提供树的根节点，递归进行
     *
     * @return Traverse result in a list.
     */
    public List<T> preOrder(BinaryTreeNode<T> rootNode) {
        List<T> result = new ArrayList<T>();
        if(rootNode == null){
            return result;
        }
        else{
            result.add(rootNode.getVal());
            result.addAll(preOrder(rootNode.getLeft()));
            result.addAll(preOrder(rootNode.getRight()));
            return result;
        }
    }

    /**
     * 中序遍历(左根右)：提供树的根节点，递归进行
     *
     * @return Traverse result in a list.
     */
    public List<T> inOrder(BinaryTreeNode<T> rootNode) {
        List<T> result = new ArrayList<T>();
        if(rootNode == null){
            return result;
        }
        else{
            result.addAll(inOrder(rootNode.getLeft()));
            result.add(rootNode.getVal());
            result.addAll(inOrder(rootNode.getRight()));
            return result;
        }
     }

     /**
     * 后序遍历(左右根)：提供树的根节点，递归进行
     *
     * @return Traverse result in a list.
     */
    public List<T> postOrder(BinaryTreeNode<T> rootNode) {
        List<T> result = new ArrayList<>();
        if(rootNode == null){
            return result;
        }
        else{
            result.addAll(postOrder(rootNode.getLeft()));
            result.addAll(postOrder(rootNode.getRight()));
            result.add(rootNode.getVal());
            return result;
        }
    }

    /**
     * 层序遍历：从上到下，每层从左到右，借助队列Queue实现
     *
     * @return Traverse result in a list.
     */
    public List<T> levelOrder(BinaryTreeNode<T> rootNode) {
        ArrayList<T> result = new ArrayList<T>();
        if (rootNode == null) {
            return result;
        }
        Queue<BinaryTreeNode<T>> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);  //首先根节点入队
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode<T> nowNode = nodeQueue.peek();
            nodeQueue.poll();
            result.add(nowNode.getVal());
            //因为每层从左到右，所以左孩子先入队，右孩子后入队
            if (nowNode.getLeft() != null) {
                nodeQueue.add(nowNode.getLeft());
            }
            if (nowNode.getRight() != null) {
                nodeQueue.add(nowNode.getRight());
            }
        }
        return result;
    }

    /**
     * 中序遍历(左根右)：提供树的根节点，用循环实现遍历，借助栈Stack结构
     *
     * @return Traverse result in a list.
     */
    public List<T> inOrderNonRecur(BinaryTreeNode<T> rootNode) {
        List<T> result = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (rootNode != null || !stack.isEmpty()) {
            while (rootNode != null) {
                stack.push(rootNode);
                rootNode = rootNode.getLeft();
            }
            if (!stack.isEmpty()) {
                rootNode = stack.pop();
                result.add(rootNode.getVal());
                rootNode = rootNode.getRight();
            }
        }
        return result;
    }
}
