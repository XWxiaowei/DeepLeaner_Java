package learnibf;

public class ReverseListSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode  listNode1=new  ListNode(1);
		ListNode  listNode2=new  ListNode(2);
		ListNode  listNode3=new  ListNode(3);
		ListNode  listNode4=new  ListNode(4);
		ListNode  listNode5=new  ListNode(5);
		ListNode  listNode6=new  ListNode(6);
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		listNode5.next=listNode6;
        ListNode  ss= new  ReverseListSoluction().ReverseList(listNode1);
        System.out.println(" vv");
	}
    public ListNode ReverseList(ListNode head) {
    	if(head==null||head.next==null) return  head;
    	ListNode  pHead=head;
    	ListNode  previous=null;
        ListNode  NewHead=null;
    	while(pHead!=null){
    		ListNode  next=pHead.next;
    		if(next==null){
    			NewHead=pHead;
    			NewHead.next=previous;
    			
    			break;
    		}
    		pHead.next=previous;
    		previous=pHead;
    		pHead=next;
    	}
		return NewHead;
        
    }
}
