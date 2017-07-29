package learnibf;

import java.util.HashSet;
import java.util.Set;

public class deleteDuplicationSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            ListNode  listNode1=new  ListNode(1);
            ListNode  listNode2=new  ListNode(1);
            ListNode  listNode3=new  ListNode(1);
            ListNode  listNode4=new  ListNode(1);
            ListNode  listNode5=new  ListNode(1);
            ListNode  listNode6=new  ListNode(1);
            ListNode  listNode7=new  ListNode(1);
            listNode1.next=listNode2;
            listNode2.next=listNode3;
            listNode3.next=listNode4;
            listNode4.next=listNode5;
            listNode5.next=listNode6;
            listNode6.next=listNode7;
     ListNode  ls=       new deleteDuplicationSoluction().deleteDuplication2(listNode1);
     System.out.println("vvvvv");
            
	}   
	/**
	 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
	 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
	 * 1-2，-4--2--6-5
	 * @param pHead
	 * @return
	 */
	      public ListNode deleteDuplication(ListNode pHead)
	    {
	    	  
	    	  if(pHead==null)  return  null;
	    	  ListNode  temp=pHead;
	    	  ListNode  previous=null;
	    	  Set<Integer>  hashSet=new HashSet<>();
	    	  while(temp.next!=null){
	    		 if(hashSet.contains(temp.val)){
	    			 //去重当前的节点出现重复 删除当前的节点
	    			 previous.next=temp.next; 
	    		 }
	    		 else{
	    			 hashSet.add(temp.val);
	    			 previous=temp;
	    		 }
	    		 temp=temp.next; 
	    	  }
			return pHead;

	    }
	      public ListNode deleteDuplication2(ListNode pHead){
	    	  if(pHead==null){
	    		  return  null;
	    	  }
	    	  if(pHead.next==null){
	    		  return  pHead;
	    	  }
	    	  //增加一个虚拟的头结点
	    	  ListNode  vitureHead=new  ListNode(-1);
	    	  vitureHead.next=pHead;
	    	  ListNode  temp=pHead,
	    			  previous=vitureHead;
	    	  while(temp!=null&&temp.next!=null){
	    		  //如果重复节点
	    		  if(temp.next.val==temp.val){
	    			  int  tempValue=temp.val;
	    			  while(temp!=null&&temp.val==tempValue)
	    			  {
	    					 temp=temp.next;
	    			  }
	    			  previous.next=temp;
	    		  }
	    		  else
	    		  {
	    			  previous=temp;
	    			  temp=temp.next;
	    		  }
	    	  }
			return vitureHead.next;
	      }
}
