package classicalThreadProblem;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch是一个非常实用的多线程控制工具类
 * Latch是个门闩的意思，这个工具通常用于控制线程进行等待，它可以让一个线程一直等待
 * 直到倒计时结束为止，再开始执行
 * 
 * 对于倒计时而言，一种典型的场景就是发射火箭，在火箭发射前，为了确保万无一失，
 * 往往需要进行各项检测，只有等待各项的检测完毕之后，引擎才能够完成点火操作，
 * 这种场景就非常适合使用CountDownLatch
 * 
 * 主线程在CountDowunLatch上面进行等待，当所有的检查任务都完成以后，主线程方能继续执行
 * 
 * 倒计时计数器
 * @author Administrator
 *
 */
public class CountDownLuntchDemo implements Runnable{
   static final  CountDownLatch end=new CountDownLatch(10);
   static final  CountDownLuntchDemo demo=new  CountDownLuntchDemo();
	public void run() {
		// TODO Auto-generated method stub
	   try {
		Thread.sleep(new  Random().nextInt(10)*1000);//模拟检查任务
		System.out.println(Thread.currentThread().getName()+"  check complete");
		end.countDown();
	 } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }	
	}
	public static  void  main(String[] args) throws InterruptedException{
		   ExecutorService exec=Executors.newFixedThreadPool(10);
		   for(int i=0;i<10;i++){
			   exec.submit(demo);
		   }
		   //调用countDownLatch的await()方法，
		   //要求主线程可以等待所有的检查任务全部执行完毕
		   end.await();
		   //发射火箭
		   System.out.println("Fire! ....");
		   exec.shutdown();
	   }

}
