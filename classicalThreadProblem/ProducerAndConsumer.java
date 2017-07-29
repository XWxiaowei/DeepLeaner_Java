package classicalThreadProblem;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer<T> {
    private LinkedList<T> lists=new LinkedList<>();
    private int MAX=10;
    private int count=0;
    
	private Lock lock=new ReentrantLock();
	private Condition  producer=lock.newCondition();
	private Condition  consumer=lock.newCondition();
	
	public void Put(T t){
		try {
			lock.lock();
			while(lists.size()==MAX){
				producer.await();
			}
			lists.add(t);
			++count;
			consumer.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public T  get(){
		T t=null;
		try {
			lock.lock();
			while(lists.isEmpty()){
				consumer.await();
			}
			t=lists.removeFirst();
			count--;
			producer.signalAll();//通知生产者进行生产
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return t;
	}
	public static void main(String [] args){
		ProducerAndConsumer<String> producerAndConsumer=new ProducerAndConsumer<>();
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"  "+producerAndConsumer.get());
				}
			}, "c"+i).start();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
			for(int i=0;i<10;i++){
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						producerAndConsumer.Put("cc"+new Random());
						System.out.println(Thread.currentThread().getName()+" put ");
					}
				}, "p"+i).start();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
