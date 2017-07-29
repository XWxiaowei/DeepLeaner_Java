package learnibf;

public class reConstructBinaryTreeSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] pre={1,2,3,4,5,6,7};
       int [] in={3,2,4,1,6,5,7};
       TreeNode  res=new reConstructBinaryTreeSoluction().reConstructBinaryTree(pre, in);
	}
	/**
	 * ǰ�����{1,2,4,7,3,5,6,8}��  ������
	 * �����������{4,7,2,1,5,3,8,6}�������
	 * ���ؽ������������ء�
	 * @param pre
	 * @param in
	 * @return
	 * ���� ;
	 * 1.��ǰ������ �ҵ���һ����x֮�� ��
	 * 2.Ȼ����x���������зֳ�������  ��벿�� �� �Ұ벿��
	 * 3.Ȼ�����벿�ֺ��ұ߰벿�ֽ��еݹ鴦��
	 * 
	 * 
	 */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	//�ݹ鴦�� �ؽ���������
    	if(pre.length!=in.length||pre==null||in==null){
    		return  null;
    	}
//    	TreeNode  root=new  TreeNode(pre[0]);//���ڵ�
//    	//����pre[0]�� �������зֳ����������֡��ݹ���д���
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
