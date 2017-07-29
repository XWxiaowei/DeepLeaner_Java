package learnibf;

import java.util.ArrayList;

public class MultiplySoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	}
	/**
	 * 分析 如果直接暴力相乘依次求解的到B[i]的对应结果 
	 *  是得不偿失的事情  时间复杂度达到了O（N^2）的复杂度
	 *  B[i]=C[i]*D[i]=A[0]*A[1]*...A[i-1]*A[i+1]A[i+2]...A[n]
	 *  其中  C[i]=A[0]*A[1]*A[2]*...A[i-1]=C[i-1]*A[i-1]
	 *      D[i]=A[i+1]*A[i+2]....A[n]=D[i+1]*A[i+1]
	 * @param A
	 * @return
	 */
	     public int[] multiply(int[] A) 
	     {
	    	 int len=A.length;
	         int [] B=new int[len];
	         if(len!=0){
	        	 B[0]=1;
	        	 //计算下三角
	        	 for(int i=1;i<len;i++){
	        		 B[i]=B[i-1]*A[i-1];
	        	 }
	        	 int temp=1;
	        	 for(int j=len-2;j>=0;j--){
	        		 temp*=A[j+1];
	        		 B[j]*=temp;
	        	 }
	         }
		    return B;
	    }

}
