package InterView;

import java.util.Arrays;

public class requeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		requeue test = new requeue("aaaa");
		test.add("bbbb");
		test.add("cccc");
		System.out.println(test);
		 //ɾ��һ��Ԫ�غ�  
		test.remove();  
	    System.out.println("ɾ��һ��Ԫ�غ�Ķ��У�" + test);  
	    //�ٴ����һ��Ԫ��  
	    test.add("dddd");  
	    System.out.println("�ٴ����Ԫ�غ�Ķ��У�" + test);  
	    //ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��  
	    test.remove();  
	    //�ٴμ���һ��Ԫ��  
	    test.add("eeee");  
	    System.out.println(test);  

	}
	 private int DEFAULT_SIZE = 10;  
	  
	 private int capacity;//��������ĳ���  
	  
	 private Object[] elementData;//����һ���������ڱ���ѭ�����е�Ԫ��  
	  
	 private int front = 0;//��ͷ  
	  
	 private int rear = 0;//��β  
	 //��Ĭ�����鳤�ȴ�����ѭ������  
	  public requeue() {  
	    capacity = DEFAULT_SIZE;  
	    elementData = new Object[capacity];  
	  }  
	//��һ����ʼ��Ԫ��������ѭ������  
	  public requeue(Object element) {  
	    this();  
	    elementData[0] = element;  
	    rear++;  
	  }  
	  /** 
	   * ��ָ�����ȵ�����������ѭ������ 
	   * @param element ָ��ѭ�������е�һ��Ԫ�� 
	   * @param initSize ָ��ѭ�����еײ�����ĳ��� 
	   */  
	  public requeue(Object element, int initSize) {  
	    this.capacity = initSize;  
	    elementData = new Object[capacity];  
	    elementData[0] = element;  
	    rear++;  
	  }  
	  //��ȡѭ�����еĴ�С  
	  public int size() {  
	    if (isEmpty()) {  
	      return 0;  
	    }  
	    return rear > front ? rear - front : capacity - (front - rear);  
	  }  
	  //�ж�ѭ�������Ƿ�Ϊ�ն���  
	  public boolean isEmpty() {  
	    //rear==front��rear����Ԫ��Ϊnull  
	    return rear == front && elementData[rear] == null;  
	  }  
	  //�������  
	  public void add(Object element) {  
	    if (rear == front && elementData[front] != null) {  
	      throw new IndexOutOfBoundsException("�����������쳣");  
	    }  
	    elementData[rear++] = element;  
	    //���rear�Ѿ���ͷ���Ǿ�תͷ  
	    rear = rear == capacity ? 0 : rear;  
	  }  
	  //�Ƴ�����  
	  public Object remove() {  
	    if (isEmpty()) {  
	      throw new IndexOutOfBoundsException("�ն����쳣");  
	    }  
	    //�������е�front�˵�Ԫ�ص�ֵ  
	    Object oldValue = (Object) elementData[front];  
	    //�ͷŶ��е�front�˵�Ԫ��  
	    elementData[front++] = null;  
	    //���front�Ѿ���ͷ���Ǿ�תͷ  
	    front = front == capacity ? 0 : front;  
	    return oldValue;  
	  }  
	  //���ض��ж�Ԫ�أ�����ɾ�����ж�Ԫ��  
	  public Object element() {  
	    if (isEmpty()) {  
	      throw new IndexOutOfBoundsException("�ն����쳣");  
	    }  
	    return (Object) elementData[front];  
	  } 
	//���ѭ������  
	  public void clear() {  
	    //���ײ���������Ԫ�ظ�Ϊnull  
	    Arrays.fill(elementData, null);  
	    front = 0;  
	    rear = 0;  
	  }  
	  public String toString() {  
		    if (isEmpty()) {  
		      return "[]";  
		    } else {  
		      //���front < rear����ЧԪ�ؾ���front��rear֮���Ԫ��  
		      if (front < rear) {  
		        StringBuilder sb = new StringBuilder("[");  
		        for (int i = front; i < rear; i++) {  
		          sb.append(elementData[i].toString() + ", ");  
		        }  
		        int len = sb.length();  
		        return sb.delete(len - 2, len).append("]").toString();  
		      }  
		      //���front >= rear����ЧԪ��Ϊfront->capacity֮�䡢0->front֮���  
		      else {  
		        StringBuilder sb = new StringBuilder("[");  
		        for (int i = front; i < capacity; i++) {  
		          sb.append(elementData[i].toString() + ", ");  
		        }  
		        for (int i = 0; i < rear; i++) {  
		          sb.append(elementData[i].toString() + ", ");  
		        }  
		        int len = sb.length();  
		        return sb.delete(len - 2, len).append("]").toString();  
		      }  
		    }  
	  }
	  

}
