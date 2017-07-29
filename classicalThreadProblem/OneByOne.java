package classicalThreadProblem;

public class OneByOne {
  
	public static void main(String [] args){
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"kaiaiaiia");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t1");
Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					t1.join();
					
					
					System.out.println(Thread.currentThread().getName()+"kaiaiaiia");
				    Thread.sleep(10000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		},"t2");
     Thread t3=new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				t2.join();
				
				System.out.println("t3..."+"begin");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}, "t3");
		
     
     t1.start();
     t2.start();
     t3.start();
     System.out.println("i am  main  function"+"the play is begining");
	}
	
}
