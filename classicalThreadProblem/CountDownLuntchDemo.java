package classicalThreadProblem;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch��һ���ǳ�ʵ�õĶ��߳̿��ƹ�����
 * Latch�Ǹ����ŵ���˼���������ͨ�����ڿ����߳̽��еȴ�����������һ���߳�һֱ�ȴ�
 * ֱ������ʱ����Ϊֹ���ٿ�ʼִ��
 * 
 * ���ڵ���ʱ���ԣ�һ�ֵ��͵ĳ������Ƿ��������ڻ������ǰ��Ϊ��ȷ������һʧ��
 * ������Ҫ���и����⣬ֻ�еȴ�����ļ�����֮��������ܹ���ɵ�������
 * ���ֳ����ͷǳ��ʺ�ʹ��CountDownLatch
 * 
 * ���߳���CountDowunLatch������еȴ��������еļ����������Ժ����̷߳��ܼ���ִ��
 * 
 * ����ʱ������
 * @author Administrator
 *
 */
public class CountDownLuntchDemo implements Runnable{
   static final  CountDownLatch end=new CountDownLatch(10);
   static final  CountDownLuntchDemo demo=new  CountDownLuntchDemo();
	public void run() {
		// TODO Auto-generated method stub
	   try {
		Thread.sleep(new  Random().nextInt(10)*1000);//ģ��������
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
		   //����countDownLatch��await()������
		   //Ҫ�����߳̿��Եȴ����еļ������ȫ��ִ�����
		   end.await();
		   //������
		   System.out.println("Fire! ....");
		   exec.shutdown();
	   }

}
