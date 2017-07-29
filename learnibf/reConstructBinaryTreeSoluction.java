package learnibf;

public class reConstructBinaryTreeSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] pre={1,2,3,4,5,6,7};
       int [] in={3,2,4,1,6,5,7};
       TreeNode  res=new reConstructBinaryTreeSoluction().reConstructBinaryTree(pre, in);
	}
	/**
	 * 前序遍历{1,2,4,7,3,5,6,8}和  根左右
	 * 中序遍历序列{4,7,2,1,5,3,8,6}，左根右
	 * 则重建二叉树并返回。
	 * @param pre
	 * @param in
	 * @return
	 * 分析 ;
	 * 1.在前序里面 找到第一个数x之后 ，
	 * 2.然后按照x将中序序列分成两部分  左半部分 和 右半部分
	 * 3.然后对左半部分和右边半部分进行递归处理
	 * 
	 * 
	 */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	//递归处理 重建立二叉树
    	if(pre.length!=in.length||pre==null||in==null){
    		return  null;
    	}
//    	TreeNode  root=new  TreeNode(pre[0]);//根节点
//    	//按照pre[0]将 中序序列分成左右两部分。递归进行处理
//    	
    	
		return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        
    }
    /**
     * 
     * @param pre
     * @param preStartIndex
     * @param preEndIndex
     * @param in
     * @param inStartIndex
     * @param inEndIndex
     * @return
     */
	private TreeNode reConstructBinaryTree(int[] pre, int preStartIndex, int preEndIndex,
			int[] in, int inStartIndex, int inEndIndex) {
		// TODO Auto-generated method stub
		int rootValue=pre[preStartIndex];
		TreeNode  rootNode=new TreeNode(pre[preStartIndex]);
		if(preStartIndex==preEndIndex){
			if(inEndIndex==inStartIndex&&pre[preStartIndex]==in[inStartIndex]){
				return  rootNode;
			}
		}
		int rootIndexOfIn=inStartIndex;
		while(rootIndexOfIn<inEndIndex&&in[rootIndexOfIn]!=rootValue){
			++rootIndexOfIn;
		}
		int leftLength=rootIndexOfIn-inStartIndex;
		if(leftLength>0){
			rootNode.left=reConstructBinaryTree(pre, preStartIndex+1, preStartIndex+leftLength+1, in, inStartIndex, rootIndexOfIn-1);
		}
		if(leftLength<preEndIndex-preStartIndex){
			rootNode.right=reConstructBinaryTree(pre, preStartIndex+leftLength+1, preEndIndex, in, rootIndexOfIn+1, inEndIndex);
		}
		return rootNode;
	}
    
}
