package classicalThreadProblem;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 是一种多线程并发控制工具
 * 和CountDownLatch非常类似，可以实现线程之间的计数等待
 * 这个计数器可以反复使用，比如：假设我们将计数器设置为10，
 * 那么凑齐第一批的10个线程之后，计数器就会归0，然后接着处理下一批的
 * 10个线程，这就是循环栅栏的内在含义
 * CyclicBarrier的使用场景也是非常丰富，比如司令下达命令，要求10个士兵一起
 * 去完成一项任务，这个时候就需要10个士兵先集合起来报道，接着一起雄赳赳气昂昂的去执行任务
 * ，当10个士兵把自己手头的任务都执行完成之后，那么司令才会对外进行宣战，任务完成
 * CylicBarrier比CountLatch略微强大，可以接受一个参数作为barrierAction,所谓
 * barrierAction就是计数器一次性计数完成之后，系统会执行的动作，如下构造函数，parrties表示
 * 计数总数，也就是参与的线程总数
 * 
 * @author Administrator
 *
 */
public class CyclicBarrierExample {
    public static class  Solider  implements  Runnable{
        private String  solider;
        private final CyclicBarrier cyclic;
        
		public Solider(String solider, CyclicBarrier cyclic) {
			//super();
			this.solider = solider;
			this.cyclic = cyclic;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				cyclic.await();//等待所有的士兵到齐了  ---每个士兵都会再这里进行等待
				//当 集合完毕之后表示CyclicBarrier的一次计数完成了，当再一次调用CyclicBarrier的await时候，
				//会进行下一轮的计数
				doWork();//等待所有的士兵完成工作
				cyclic.await();//cyclic进行下一轮计数 主要目的是监控所有的士兵是否都已经完成了任务
				//一旦任务全部完成 就会触发barrirerRun里面的动作
				//System.out.println(solider+" 的下一步动作");
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void doWork() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(Math.abs(new Random().nextInt()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(solider+"...任务完成");
		}
    	
    }
    public static class BarrierRun implements Runnable{
       boolean  flag;
       int N;
       
       
		public BarrierRun(boolean flag, int n) {
		//super();
		this.flag = flag;
		this.N = n;
	}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(flag)
			{
				System.out.println("司令：[士兵] "+N+" 个，任务完成");
			}else{
				System.out.println("司令：[士兵] "+N+" 个，集合完毕");
				flag=true;
			}
		}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-gednerated method stub
       final int N=10;
        Thread[] allSoliders=new Thread[N];
        boolean  flag=false;
        //设置屏障点  -创建了CyclicBarrier实例，并且将计数器设置为10，并且要求在计数到达指标的时候
        //执行BarrierRun的run()方法，
        CyclicBarrier cyBarrier=new  CyclicBarrier(N,new BarrierRun(flag, N));
        System.out.println("集结队伍！");
        for(int i=0;i<N;i++){
        	System.out.println("士兵 "+i+" 报道");
        	allSoliders[i]=new Thread(new Solider("士兵 "+i, cyBarrier));
        	allSoliders[i].start();
        }
	}
	
	

}
