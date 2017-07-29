package classicalThreadProblem;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
  private AtomicReference<Thread> ower=new AtomicReference<Thread>();
  public void lock(){
	  Thread currentThread=Thread.currentThread();
	  while(!ower.compareAndSet(null, currentThread)){
		  
	  }
  }
  public void unlock(){
	  Thread current = Thread.currentThread();
	  ower.compareAndSet(current, null);
  }
  public static void main(String [] args){
	  SpinLock spinLock=new SpinLock();
	  spinLock.lock();
	  spinLock.lock();
	  System.out.println("hshshs");
	  
  }
}
