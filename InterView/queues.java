package InterView;

import java.util.Arrays;

public class queues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private int DEFAULT_SIZE = 10;
	private int capacity;//保存数组的长度
	private Object[] elementData;//定义一个数组用于保存顺序队列的元素
	private int front = 0;//对头
	private int rear = 0;//对尾
	//以默认数组长度创建空顺序队列
	public queues(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//以一个初始化元素来创建顺序队列
	public queues(Object element){
		this();
		elementData[0] = element;
		rear++;
	}
	public queues(int initSize){
		elementData = new Object[initSize];
	}
	//获取顺序队列的大小
	public int size(){
		return rear - front;
	}
	//入队
	public void offer(Object element){
		ensureCapacity(rear+1);
		elementData[rear++] = element;
	}
	private void ensureCapacity(int minCapacity){
		int oldCapacity = elementData.length;
		//如果数组的原有长度小于目前所需的长度
		if(minCapacity>oldCapacity){
			int newCapacity = (oldCapacity*3)/2+1;
			if(newCapacity<minCapacity){
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	//出队
	public Object poll(){
		if(isEmpty()){
			return -1;
		}
		return elementData[front];
	}
	//判断队列是否为空
	public boolean isEmpty(){
		return rear == front;
	}
	//清空队列
	public void clear(){
		//将底层所有元素赋值为空
		Arrays.fill(elementData, null);
		front = 0;
		rear = 0;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(int i=front;i<rear;i++){
				sb.append(elementData[i].toString()+",");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
}
