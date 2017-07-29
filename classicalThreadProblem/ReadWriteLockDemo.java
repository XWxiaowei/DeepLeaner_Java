package classicalThreadProblem;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
   
	private static Lock lock=new  ReentrantLock();
	private static  ReentrantReadWriteLock  readWriteLock=new ReentrantReadWriteLock();
	private static Lock  readlock=readWriteLock.readLock();
	private static Lock  writelock=readWriteLock.writeLock();
	private  int  value;
	
	public  Object  handleRead(Lock lock) throws InterruptedException{
		try {
			lock.lock();//模拟读操作
			Thread.sleep(1000);//读取操作的耗时越多  读写锁的优势就越明显
			return value;
		} finally{
			lock.unlock();
		}
	}
	public void  handWrite(Lock lock,int  index) throws InterruptedException{
		try {
			lock.lock();//模拟写操作
			Thread.sleep(1000);//
			 value=index;
		} finally{
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ReadWriteLockDemo  readWriteLockDemo=new  ReadWriteLockDemo();
        Runnable  readRunnable=new  Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					//readWriteLockDemo.handleRead(readlock);
					readWriteLockDemo.handleRead(lock);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		 Runnable  writeRunnable=new  Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						//readWriteLockDemo.handWrite(writelock, new Random().nextInt());
						readWriteLockDemo.handWrite(lock, new Random().nextInt());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			long  startTime=System.currentTimeMillis();
		   for(int i=0;i<18;i++){
			   new Thread(readRunnable).start();
		   }
		   for(int i=18;i<20;i++){
			   new  Thread(writeRunnable).start();
		   }
		   
		   long endTime=System.currentTimeMillis();
		   System.out.println(endTime-startTime);
	}
	

}
