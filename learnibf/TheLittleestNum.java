package learnibf;

public class TheLittleestNum {
  
	public static  void main(String [] args){
		
		int [] arr={5,6,3,9,4};
		int res=MaxDivide(arr,5);
		System.out.println(res+"cccccccccccccc");
	}
	/**
	 * 给定数组 arr求 使得
	 * 0<=a<b<n
	 * 使得A[b]-A[a]的差值最大
	 * 5,6,3,9,4
	 * [5]---0    leftMin=5    res=0
	 * [5,6]---1  leftMin=5   res=1
	 * [5,6,3]-   leftMin=3   res=1
	 * [5,6,3,9]  leftMin=3  res=6
	 * [5,6,3,9,4]  leftMin=3 res=6
 	 * 
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int MaxDivide(int [] arr,int n){
		if(n==0||n==1){
			return 0;
		}
		int res[]=new int[n];
		int leftMin=arr[0];
		//int maxLen=0;
		for(int i=1;i<n;i++){
			if(leftMin<arr[i]){
				int currSum=arr[i]-leftMin;
				res[i]=Math.max(currSum, res[i-1]);
			}
			else
			{
				//不存在更新的可能性
				leftMin=arr[i];
				res[i]=res[i-1];
			}
		}
		return res[n-1];
	}
}
