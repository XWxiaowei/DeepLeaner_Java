package InterView;
//栈的顺序存储
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
	//构造函数
	public stack(){
		stack = new Object[MaxSize];
		top = -1;
	}
	//获取栈中元素的个数
	public int getSize(){
		return top+1;
	}
	//判断栈是否为空
	public boolean isEmpty(){
		return top == -1;
	}
	//在栈顶插入一个元素
	public void push(Object obj){
		if(getSize()>=stack.length){
			resizeSpace();
		}
		stack[++top] = obj;
	}
	//重置栈的大小
	public void resizeSpace(){
		Object[] resizeArray = new Object[stack.length*2];
		for(int i = 0;i<stack.length;++i){
			resizeArray[i] = stack[i];
		}
		stack = resizeArray;
	}
	//弹出栈顶元素
	public Object pop(){
		if(getSize()<1){
			System.out.println("cuole");
		}
		Object tmp = stack[top];
		stack[top--]=null;
		return tmp;
	}
	//输出栈顶元素
	public Object peek(){
		if(getSize()<1){
			System.out.println("cuole");
		}
		return stack[top];
	}
	

}
 
