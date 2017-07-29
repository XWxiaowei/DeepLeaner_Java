package learnibf;

public class ReverTheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(7);
		ListNode node5=new ListNode(9);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=null;
		new ReverTheLinkedList().soluction(node1);
		
	}
	/**
	 * 实现单链表的就地逆置
	 * 为了正确的调整一个链表，需要调整指针的指向，
	 * 比如对于链表 1，3，5而言，
	 * 假设经过若干步操作之后，
	 * 已经把节点1之前的指针调整完毕了，
	 * 这些节点的next指针都指向了前一个节点
	 * 现在遍历到节点3的时候，当然需要调整节点的next指针
	 * 让他始终指向节点1，但是这里需要注意的是，一旦调整了指针的指向，链表就断开了，
	 * 因为没有指针指向5了，没有办法再次遍历到节点5 了，因此为了避免链表断开，，需要在调整
	 * m的m_next之前把n保存下来，接着试着找到反转后的链表的头节点，不难分析出
	 * 反转后的链表的头结点是原始的链表的尾巴节点。
	 * @param pHead
	 * @return
	 */
	public ListNode soluction(ListNode pHead){
		if(pHead==null||pHead.next==null){
			return pHead;
		}
		ListNode  current=pHead,pRecerHead=null,previous=null;
		
		while(current!=null){
			ListNode next=current.next;
			if(next==null){
				//current.next=previous;
				pRecerHead=current;
			}
			current.next=previous;
			previous=current;
			current=next;
		}
		return pRecerHead;	
	}
}
