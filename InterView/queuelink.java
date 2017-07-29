package InterView;

public class queuelink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queuelink test = new queuelink("aaaa");
		test.offer("bbbb");
		test.offer("cccc");
		System.out.println(test);
		 //删除一个元素后  
		test.poll();  
	    System.out.println("删除一个元素后的队列：" + test);  
	    //再次添加一个元素  
	    test.offer("dddd");  
	    System.out.println("再次添加元素后的队列：" + test);  
	    //删除一个元素后，队列可以再多加一个元素  
	    test.poll();  
	    //再次加入一个元素  
	    test.offer("eeee");  
	    System.out.println(test);  

	}
	//定义一个内部类Node,Node实例代表链队列的节点
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
	private Node front;//保存链队列的头结点
	private Node rear;//尾节点
	private int size;//队列中包含的节点数
	//创建空队列
	public queuelink(){
		front = null;
		rear = null;
	}
	public queuelink(Object element){
		front = new Node(element,null);
		rear = front;
		size++;
	}
	//获取队列的大小
	public int size(){
		return size;
	}
	//入队
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
	//出队
	public Object poll(){
		Node oldFront = front;
		front = front.next;
		oldFront.next = null;
		size--;
		return oldFront.data;
	}
	//返回队列顶元素
	public Object peek(){
		return rear.data;
	}
	//判断是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	//清空队列
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
