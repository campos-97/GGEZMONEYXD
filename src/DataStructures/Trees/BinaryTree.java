package DataStructures.Trees;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(TreeNode newNode){
        root = newNode;
    }

    public boolean isEmpty(){
        if(root == null){
            return true;
        }
        return false;
    }

    public void addNode(TreeNode newNode){
        if(isEmpty()){
            this.root =  newNode;
        }else{
            this.addNode(this.root,newNode);
        }
    }

    private void addNode(TreeNode current, TreeNode newNode){
        
    }
}
