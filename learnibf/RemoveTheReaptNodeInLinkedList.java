package learnibf;

public class RemoveTheReaptNodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 删除单链表里面的重复节点，
	 * 法1：用散列表，迭代访问整个链表，将每个节点加入到散列表里面，如果发现有重复元素则将该节点从链表里面进行
	 * 删除，然后继续迭代
	 * 该方法的时间复杂度为O(n),
	 * 法2：如果不允许使用额外的缓冲区，可以考虑利用两个指针进行迭代访问
	 * curret迭代访问整个链表，runnner用于检查后续的节点是否有重复
	 * @param phead
	 * @return
	 */
	public ListNode deleteNodes(ListNode phead){
		
		if(phead==null){
			return  null;
		}
		ListNode  currentNode=phead;
		//ListNode  runnner=phead;
		while(currentNode!=null){
			
			ListNode  runnner=currentNode;
			 while(runnner.next!=null){
				 if(runnner.next.val==currentNode.val){
					 runnner.next=runnner.next.next;//去重
				 }else
				 {
					 
				 }
			 }
			
		}
		return phead;
		
	}

}
