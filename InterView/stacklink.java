package InterView;
//栈的链式存储
public class stacklink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stacklink test = new stacklink();
		test.push(3);
		System.out.println(test.peek());
		
	}
	private SLNode top;
	private int size;
	public stacklink(){
		top = null;
		size = 0;
	}
	//返回栈中元素的大小
	public int getSize(){
		return size;
	}
	//判断栈是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	//在栈顶插入元素
	public void push(Object obj){
		SLNode tmp = new SLNode(obj);
		tmp.next = top;
		top = tmp;
		size++;
	}
	//弹出栈顶元素
	public Object pop(){
		if(size<1){
			System.out.println("cuole");
		}
		Object tmp= top.data;
		top = top.next;
		size--;
		return tmp;
	}
	//输出栈顶元素
	public Object peek(){
		if(size<1){
			System.out.println("cuole");
		}
		return top.data;
	}
	
	

}
class SLNode{
	Object data;
	SLNode next;
	public SLNode(Object e){
		data = e;
		next = null;
	}
}
