package learnibf;

public class LastRemaining_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 /**
	  * 递推公式
	  * f(i)=
	  * 
	  *   0  --i=0
	  *   (f(i-1)+m)/i --->   当i>1
	  *   0,1,2,3,4,5,6  n=7
	  *   m=3
	  *   1:  0,1,3,4,5,6  2出队
	  *   2：   3,4,6,0,1  5出队
	  *   3.  6,0,3,4      1出队
	  *   
	  *   
	  *   
	  *   0,1,2,.....n-1   m-1
	  *   0,1,2,3...m-2,m-1,m,m+1,....n-1  ---》n个人 实际  m-1出队
	  *   0,1,2,3,....m-2,m,m+1,....n-2,n-1   --->  
	  *   ^^^^^^^^^^^^^^^^^^^^^^
	  *    考虑从 n-1后延长这个序列
	  *
	  *   $$$$$$$$$$$$$$$$$$$$$$$$
	  *   m,m+1,...n-1,0,1,2,3....m-2  
	  *   ?
	  * 真实   m,m+1,...n-1,n,n+1,n+2,,,n+m-2
	  *   
	  * 虚拟： 0,1,......................n-2  ---n-1个人
	  * @param n
	  * @param m
	  * @return
	  */
	 public int LastRemaining_Solution(int n, int m) {
		 if(n==0||m==0){
			 return 0;
		 }
		 int f[]=new int[n+1];
		 f[0]=0;f[1]=0;
		 for(int i=1;i<=n;i++){
	       f[i]=(f[i-1]+m)%i;
	       System.out.println(i+" 要出队了....");
		 }
		return f[n];
	 }

}
