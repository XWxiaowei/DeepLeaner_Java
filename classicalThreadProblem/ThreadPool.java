package classicalThreadProblem;

import java.util.LinkedList;
import java.util.List;

/**
 * ���̼߳�����Ҫ�����������Ԫ�ڶ���߳�ִ�е����⣬�������������ٴ�������Ԫ������ʱ�䣬���Ӵ�������Ԫ������������    
    ����һ�����������һ����������ʱ��Ϊ��T1 �����߳�ʱ�䣬T2 ���߳���ִ�������ʱ�䣬T3 �����߳�ʱ�䡣

    �����T1 + T3 Զ���� T2������Բ����̳߳أ�����߷��������ܡ�
                һ���̳߳ذ��������ĸ�������ɲ��֣�
                1���̳߳ع�������ThreadPool�������ڴ����������̳߳أ����� �����̳߳أ������̳߳أ����������
                2�������̣߳�PoolWorker�����̳߳����̣߳���û������ʱ���ڵȴ�״̬������ѭ����ִ������
                3������ӿڣ�Task����ÿ���������ʵ�ֵĽӿڣ��Թ������̵߳��������ִ�У�����Ҫ�涨���������ڣ�
                ����ִ��������β�����������ִ��״̬�ȣ�
                4��������У�taskQueue�������ڴ��û�д���������ṩһ�ֻ�����ơ�
                
    �̳߳ؼ������ǹ�ע������̻����T1,T3ʱ��ļ������Ӷ���߷������������ܵġ�����T1��T3�ֱ����ڷ���������������ͽ�����ʱ��λ�
    ��һЩ���е�ʱ��Σ������ڷ�����������ͻ�����ʱ��������T1��T3�Ŀ����ˡ�
    �̳߳ز�������T1,T3������ʱ��Σ������������������˴����̵߳���Ŀ����һ�����ӣ�
    ����һ��������һ��Ҫ����50000�����󣬲���ÿ��������Ҫһ���������߳���ɡ����̳߳��У��߳���һ���ǹ̶��ģ����Բ����߳���������
    �����̳߳����̵߳���Ŀ��������������������̳߳���������Щ�������߳�����Ϊ50000��
    һ���̳߳ش�С��ԶС��50000�����������̳߳صķ��������򲻻�Ϊ�˴���50000���ڴ�������ʱ�˷�ʱ�䣬�Ӷ����Ч�ʡ�

    ����ʵ���в�û��ʵ������ӿڣ����ǰ�Runnable������뵽�̳߳ع�������ThreadPool����
    Ȼ��ʣ�µ���������̳߳ع�������ThreadPool���������
 * @author Administrator
 * �̳߳ع������������̳߳صĴ��������٣���ȡ�̻߳�����Ϣ�����������
 */
public class ThreadPool {
	 // �̳߳���Ĭ���̵߳ĸ���Ϊ5  
    private static int worker_num = 5;  
    // �����߳�  
    private WorkThread[] workThrads;  
    // δ���������  
    private static volatile int finished_task = 0;  
    // ������У���Ϊһ������,List�̲߳���ȫ  
    private List<Runnable> taskQueue = new LinkedList<Runnable>();  
    private static ThreadPool threadPool;  
 // ��������Ĭ���̸߳������̳߳�  
    private ThreadPool() {  
        this(5);  
    }  
  
    // �����̳߳�,worker_numΪ�̳߳��й����̵߳ĸ���  
    private ThreadPool(int worker_num) {  
        ThreadPool.worker_num = worker_num;  
        workThrads = new WorkThread[worker_num];  
        for (int i = 0; i < worker_num; i++) {  
            workThrads[i] = new WorkThread();  
            workThrads[i].start();// �����̳߳��е��߳�  
        }  
    }  
 // ��̬ģʽ�����һ��Ĭ���̸߳������̳߳�  
    public static ThreadPool getThreadPool() {  
        return getThreadPool(ThreadPool.worker_num);  
    }  
 // ��̬ģʽ�����һ��ָ���̸߳������̳߳�,worker_num(>0)Ϊ�̳߳��й����̵߳ĸ���  
    // worker_num<=0����Ĭ�ϵĹ����̸߳���  
    public static ThreadPool getThreadPool(int worker_num1) {  
        if (worker_num1 <= 0)  
            worker_num1 = ThreadPool.worker_num;  
        if (threadPool == null)  
            threadPool = new ThreadPool(worker_num1);  
        return threadPool;  
    }  
  
    // ִ������,��ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ع���������  
    public void execute(Runnable task) {  
        synchronized (taskQueue) {  
            taskQueue.add(task);  
            taskQueue.notify();  
        }  
    }  
 // ����ִ������,��ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ع���������  
    public void execute(Runnable[] task) {  
        synchronized (taskQueue) {  
            for (Runnable t : task)  
                taskQueue.add(t);  
            taskQueue.notify();  
        }  
        
    }
   
        // �����̳߳�,�÷�����֤������������ɵ�����²����������̣߳�����ȴ�������ɲ�����  
        public void destroy() {  
            while (!taskQueue.isEmpty()) {// �����������ûִ����ɣ�����˯���  
                try {  
                    Thread.sleep(10);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
            // �����߳�ֹͣ����������Ϊnull  
            for (int i = 0; i < worker_num; i++) {  
                workThrads[i].stopWorker();  
                workThrads[i] = null;  
            }  
            threadPool=null;  
            taskQueue.clear();// ����������  
        }  
     // ���ع����̵߳ĸ���  
        public int getWorkThreadNumber() {  
            return worker_num;  
        }  
        // �������������ĸ���,������������ֻ����������е�������������ܸ�����û��ʵ��ִ�����  
        public int getFinishedTasknumber() {  
            return finished_task;  
        }  
      
        // ����������еĳ��ȣ�����û������������  
        public int getWaitTasknumber() {  
            return taskQueue.size();  
        }  
      
        // ����toString�����������̳߳���Ϣ�������̸߳�����������������  
        @Override  
        public String toString() {  
            return "WorkThread number:" + worker_num + "  finished task number:"  
                    + finished_task + "  wait task number:" + getWaitTasknumber();  
        }  
        /** 
         * �ڲ��࣬�����߳� 
         */  
        private class WorkThread extends Thread {  
            // �ù����߳��Ƿ���Ч�����ڽ����ù����߳�  
            private boolean isRunning = true;  
      
            /* 
             * �ؼ����ڰ������������в��գ���ȡ������ִ�У���������пգ���ȴ� 
             */  
            @Override  
            public void run() {  
                Runnable r = null;  
                while (isRunning) {// ע�⣬���߳���Ч����Ȼ����run���������߳̾�û����  
                    synchronized (taskQueue) {  
                        while (isRunning && taskQueue.isEmpty()) {// ����Ϊ��  
                            try {  
                                taskQueue.wait(20);  
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                        if (!taskQueue.isEmpty())  
                            r = taskQueue.remove(0);// ȡ������  
                    }  
                    if (r != null) {  
                        r.run();// ִ������  
                    }  
                    finished_task++;  
                    r = null;  
                }  
            }  
         // ֹͣ�������ø��߳���Ȼִ����run��������Ȼ����  
            public void stopWorker() {  
                isRunning = false;  
            }  
    }  
    
}
