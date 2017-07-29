package InterView;

public class queuelink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queuelink test = new queuelink("aaaa");
		test.offer("bbbb");
		test.offer("cccc");
		System.out.println(test);
		 //ɾ��һ��Ԫ�غ�  
		test.poll();  
	    System.out.println("ɾ��һ��Ԫ�غ�Ķ��У�" + test);  
	    //�ٴ����һ��Ԫ��  
	    test.offer("dddd");  
	    System.out.println("�ٴ����Ԫ�غ�Ķ��У�" + test);  
	    //ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��  
	    test.poll();  
	    //�ٴμ���һ��Ԫ��  
	    test.offer("eeee");  
	    System.out.println(test);  

	}
	//����һ���ڲ���Node,Nodeʵ�����������еĽڵ�
	private class Node{
		private Object data;
		private Node next;
		public Node(){
			
		}
		public Node(Object data,Node next){
			this.data = data;
			this.next = next;
		}
		
	}
	private Node front;//���������е�ͷ���
	private Node rear;//β�ڵ�
	private int size;//�����а����Ľڵ���
	//�����ն���
	public queuelink(){
		front = null;
		rear = null;
	}
	public queuelink(Object element){
		front = new Node(element,null);
		rear = front;
		size++;
	}
	//��ȡ���еĴ�С
	public int size(){
		return size;
	}
	//���
	public void offer(Object element){
		if(front == null){
			front = new Node(element,null);
			rear = front;
		}else{
			Node newNode = new Node(element,null);
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	//����
	public Object poll(){
		Node oldFront = front;
		front = front.next;
		oldFront.next = null;
		size--;
		return oldFront.data;
	}
	//���ض��ж�Ԫ��
	public Object peek(){
		return rear.data;
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	//��ն���
	public void clear(){
		front = null;
		rear = null;
		size = 0;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(Node current=front;current!=null;current=current.next){
				sb.append(current.data.toString()+",");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}

}
