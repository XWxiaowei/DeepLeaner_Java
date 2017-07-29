package learnibf;

public class EntryNodeOfLoopSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ListNode Node1=new ListNode(1);
       ListNode Node2=new ListNode(3);
       ListNode Node3=new ListNode(5);
       ListNode Node4=new ListNode(7);
       ListNode Node5=new ListNode(6);
       ListNode Node6=new ListNode(8);
       ListNode Node7=new ListNode(10);
       Node1.next=Node2;
       Node2.next=Node3;
       Node3.next=Node4;
       Node4.next=Node5;
       Node5.next=Node6;
       Node6.next=Node7;
       Node7.next=Node4;
     ListNode listNode=  new EntryNodeOfLoopSoluction().EntryNodeOfLoop(Node1);
	}
	/**
	 * 检测链表是否具有环结构
	 * @param phead
	 * @return
	 */
	static boolean  isExitsCircle(ListNode phead){
		if(phead==null){
			return false;
		}
		ListNode  quick=phead,slow=phead;
		while(quick!=null&&quick.next!=null){
			slow=slow.next;
			quick=quick.next.next;
			if(quick==slow) {
				break;
			}
		}
		return !(quick!=null||quick.next==null);
		
	}
    /**
     * 一个链表中包含环，请找出该链表的环的入口结点。
     * @param pHead
     * @return
     */
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)  return  null;
        ListNode  slow=pHead;
        ListNode  quick=pHead;
        //暴力 是 n^2
         //找到p1和p2的第一次相遇碰撞点,,此时候碰撞点
        //和环路起点均相距k个位置，
        while(slow.next!=null&&quick.next!=null){
        	slow=slow.next;
        	if(quick.next.next==null){
        		return null;
        	}
        	quick=quick.next.next;
        	if(slow==quick){
        		break;
        	}
        }
        //错误检查，观察两者是否有碰撞处位置，也就是有没有环路
        if(quick==null||quick.next==null){
        	return null;
        }
        if(quick==pHead){
        	return  quick;
        }
        slow=pHead;
        //两者开始一起走
        while(slow.next!=null&&quick.next!=null){
        	slow=slow.next;
        	quick=quick.next;
        	if(slow==quick){
        		break;
        	}
        }
        //还要坚测 
		return slow;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}