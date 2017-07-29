package learnibf;

public class Apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * n只熊 
	 * 1--将苹果分成n份，多出一个扔掉 ，拿走自己的哪一个  n*x1+1=X--->x1=(X-1)/n
	 * 2--将剩下的苹果 分成n份，多出来一个扔掉，拿走自己的一份  n*x2+1+x1+1=X--->x2=(X-2-(X-1)/n)/n
	 * ....
	 * 
	 * n 将剩下的苹果分成n份，多出来一个，扔掉，拿走自己的一份
	 * 注意自己的一份可以是0个
	 * 
	 * @param n 熊的个数
	 * @return
	 */
	 public int getInitial(int n) {
		 //保证第一个熊至少可以分到一个苹果
		 int initial=n+1;
		 int bear=n;
		 int i=0;
		 for(i=initial;;i++)
		 {
			 //然后通过i作为迭代变量去穷举满足的情况
			 int temp=i;
			 while(temp>=0&&bear>0){
				 if(temp%n==1){
					 temp=temp-temp/n-1;
					 bear--;
				 }else{
					 break;
				 }
			 } 
			 if(bear==0){
				 return i;
			 }
		 }    // write code here
	    }
}
