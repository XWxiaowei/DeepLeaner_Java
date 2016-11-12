package Tree;

/**
 * Created by Administrator on 2016/11/12.
 */
public class ThreeLinkBinTree<T> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        TreeNode  parent;
        public TreeNode(){

        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    private TreeNode root;
    public ThreeLinkBinTree(){
        this.root=new TreeNode();
    }
    public ThreeLinkBinTree(T data){
        this.root=new TreeNode(data);
    }
    public TreeNode addTreeNode(TreeNode parent,T data,boolean isLeft){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        if(!isLeft&&parent.right!=null){
            throw new RuntimeException(parent+"节点已经有啦右边节点");
        }
        if(isLeft&&parent.left!=null){
            throw new RuntimeException(parent+"节点已经有啦左边节点");
        }
        TreeNode newNode=new TreeNode(data);
        if(isLeft){
            parent.left=newNode;
        }
        else {
            parent.right=newNode;
        }
        newNode.parent=parent;
        return newNode;
    }
    public boolean isEmpty(){
        return root.data==null;
    }
    public TreeNode root(){
        if(isEmpty()){
            throw new RuntimeException("树为空");
        }
        return root;
    }
    public T parent(TreeNode treeNode){
        if(treeNode==null){
            throw new RuntimeException(treeNode+"为空");
        }
        return (T) treeNode.parent.data;
    }
    public T leftChild(TwoLinkBinTree.TreeNode parent){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        return parent.left==null?null:(T)parent.left.data;
    }
    public T rightChild(TwoLinkBinTree.TreeNode parent){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        return parent.right==null?null:(T)parent.right.data;
    }

}
