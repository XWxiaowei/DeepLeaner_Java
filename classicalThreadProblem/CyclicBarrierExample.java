package classicalThreadProblem;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ��һ�ֶ��̲߳������ƹ���
 * ��CountDownLatch�ǳ����ƣ�����ʵ���߳�֮��ļ����ȴ�
 * ������������Է���ʹ�ã����磺�������ǽ�����������Ϊ10��
 * ��ô�����һ����10���߳�֮�󣬼������ͻ��0��Ȼ����Ŵ�����һ����
 * 10���̣߳������ѭ��դ�������ں���
 * CyclicBarrier��ʹ�ó���Ҳ�Ƿǳ��ḻ������˾���´����Ҫ��10��ʿ��һ��
 * ȥ���һ���������ʱ�����Ҫ10��ʿ���ȼ�����������������һ����������������ȥִ������
 * ����10��ʿ�����Լ���ͷ������ִ�����֮����ô˾��Ż���������ս���������
 * CylicBarrier��CountLatch��΢ǿ�󣬿��Խ���һ��������ΪbarrierAction,��ν
 * barrierAction���Ǽ�����һ���Լ������֮��ϵͳ��ִ�еĶ��������¹��캯����parrties��ʾ
 * ����������Ҳ���ǲ�����߳�����
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
				cyclic.await();//�ȴ����е�ʿ��������  ---ÿ��ʿ��������������еȴ�
				//�� �������֮���ʾCyclicBarrier��һ�μ�������ˣ�����һ�ε���CyclicBarrier��awaitʱ��
				//�������һ�ֵļ���
				doWork();//�ȴ����е�ʿ����ɹ���
				cyclic.await();//cyclic������һ�ּ��� ��ҪĿ���Ǽ�����е�ʿ���Ƿ��Ѿ����������
				//һ������ȫ����� �ͻᴥ��barrirerRun����Ķ���
				//System.out.println(solider+" ����һ������");
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
			System.out.println(solider+"...�������");
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
				System.out.println("˾�[ʿ��] "+N+" �����������");
			}else{
				System.out.println("˾�[ʿ��] "+N+" �����������");
				flag=true;
			}
		}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-gednerated method stub
       final int N=10;
        Thread[] allSoliders=new Thread[N];
        boolean  flag=false;
        //�������ϵ�  -������CyclicBarrierʵ�������ҽ�����������Ϊ10������Ҫ���ڼ�������ָ���ʱ��
        //ִ��BarrierRun��run()������
        CyclicBarrier cyBarrier=new  CyclicBarrier(N,new BarrierRun(flag, N));
        System.out.println("������飡");
        for(int i=0;i<N;i++){
        	System.out.println("ʿ�� "+i+" ����");
        	allSoliders[i]=new Thread(new Solider("ʿ�� "+i, cyBarrier));
        	allSoliders[i].start();
        }
	}
	
	

}
