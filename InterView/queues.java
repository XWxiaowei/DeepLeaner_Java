package InterView;

import java.util.Arrays;

public class queues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private int DEFAULT_SIZE = 10;
	private int capacity;//��������ĳ���
	private Object[] elementData;//����һ���������ڱ���˳����е�Ԫ��
	private int front = 0;//��ͷ
	private int rear = 0;//��β
	//��Ĭ�����鳤�ȴ�����˳�����
	public queues(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//��һ����ʼ��Ԫ��������˳�����
	public queues(Object element){
		this();
		elementData[0] = element;
		rear++;
	}
	public queues(int initSize){
		elementData = new Object[initSize];
	}
	//��ȡ˳����еĴ�С
	public int size(){
		return rear - front;
	}
	//���
	public void offer(Object element){
		ensureCapacity(rear+1);
		elementData[rear++] = element;
	}
	private void ensureCapacity(int minCapacity){
		int oldCapacity = elementData.length;
		//��������ԭ�г���С��Ŀǰ����ĳ���
		if(minCapacity>oldCapacity){
			int newCapacity = (oldCapacity*3)/2+1;
			if(newCapacity<minCapacity){
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	//����
	public Object poll(){
		if(isEmpty()){
			return -1;
		}
		return elementData[front];
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return rear == front;
	}
	//��ն���
	public void clear(){
		//���ײ�����Ԫ�ظ�ֵΪ��
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
