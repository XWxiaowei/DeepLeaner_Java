package InterView;
//ջ��˳��洢
public class stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack test = new stack();
		test.push(3);
		System.out.println(test.peek());
		

	}
	private final int MaxSize = 10;
	private Object[] stack;
	private int top;
	//���캯��
	public stack(){
		stack = new Object[MaxSize];
		top = -1;
	}
	//��ȡջ��Ԫ�صĸ���
	public int getSize(){
		return top+1;
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return top == -1;
	}
	//��ջ������һ��Ԫ��
	public void push(Object obj){
		if(getSize()>=stack.length){
			resizeSpace();
		}
		stack[++top] = obj;
	}
	//����ջ�Ĵ�С
	public void resizeSpace(){
		Object[] resizeArray = new Object[stack.length*2];
		for(int i = 0;i<stack.length;++i){
			resizeArray[i] = stack[i];
		}
		stack = resizeArray;
	}
	//����ջ��Ԫ��
	public Object pop(){
		if(getSize()<1){
			System.out.println("cuole");
		}
		Object tmp = stack[top];
		stack[top--]=null;
		return tmp;
	}
	//���ջ��Ԫ��
	public Object peek(){
		if(getSize()<1){
			System.out.println("cuole");
		}
		return stack[top];
	}
	

}
 
