package DataStructures.Trees;

public class TreeNode <T>{

    private TreeNode right;
    private TreeNode left;
    private T data;

    public TreeNode(){
        right = null;
        left = null;
        data = null;
    }

    public TreeNode(T newData){
        this();
        data = newData;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
