package learnibf;

import java.util.ArrayList;

public class printListFromTailToHeadSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
     ArrayList<Integer> res=   new printListFromTailToHeadSoluction().printListFromTailToHead(listNode1);
        System.out.println("vvbbb");
	}
	/**
	 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ
	 * 1-3-5-7
	 * 7-3-5-7
	 * @param listNode
	 * @return
	 */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> reslut=new ArrayList<>();
    	ListNode pListNode=listNode;
    	ListNode pHead=null;
    	ListNode previous=null;
    	//ʵ�ֵ�����ķ�ת����
    	while(listNode!=null){
    		//��������͵�����
    	ListNode next=listNode.next;
    	 if(next==null){
    		 listNode.next=previous;
    		 pHead=listNode;
    		 break;
    	 }
    	 listNode.next=previous;
    	 previous=listNode;
    	 listNode=next;
    	}
    	while(pHead!=null){
    		reslut.add(pHead.val);
    		pHead=pHead.next;	
    	}
		return reslut;
        
    }
}
