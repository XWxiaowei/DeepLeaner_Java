package InterView;
//ջ����ʽ�洢
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
	//����ջ��Ԫ�صĴ�С
	public int getSize(){
		return size;
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	//��ջ������Ԫ��
	public void push(Object obj){
		SLNode tmp = new SLNode(obj);
		tmp.next = top;
		top = tmp;
		size++;
	}
	//����ջ��Ԫ��
	public Object pop(){
		if(size<1){
			System.out.println("cuole");
		}
		Object tmp= top.data;
		top = top.next;
		size--;
		return tmp;
	}
	//���ջ��Ԫ��
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
