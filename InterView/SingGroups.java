package InterView;

import java.util.Arrays;
import java.util.Scanner;

public class SingGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n=scanner.nextInt();
			int [] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
			}
			soluction(arr);
		}
	}
	
	public static void  soluction(int[] arr){
		//对于数组里面的每一个元素进行考查它左边的和右边的最长序列和
	   int max=0;
	   for(int i=1;i<arr.length-1;i++){
           int leftIndex=LIS_current(getSubArr(arr, 0, i));
           int rightIndex=LIS_current(reverseArr(getSubArr(arr, i, arr.length-1)));
           if(max<leftIndex+rightIndex){
        	   max=leftIndex-1+rightIndex-1+1;
           }
          // System.out.println(arr.length-max-1);
	   }
	   System.out.println(arr.length-max);
	}
	public static int [] reverseArr(int[] arr){
		int [] rev=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			rev[i]=arr[arr.length-1-i];
		}
		return rev;
	}
 	public static int[] getSubArr(int arr[],int start,int end){
		int [] newArr=new int[end-start+1];
		for(int i=start;i<=end;i++){
			newArr[i-start]=arr[i];
		}
		return newArr;
		//Thread
	}
	/**
	 * 最少出队人数，使得队伍成为合唱队形状
	 * 最长递增子序列。。。
	 * @param arr
	 * @return
	 */
    public static int LIS_current(int [] arr){
    	if(arr==null||arr.length==0){
    		return 0;
    	}
    	//记f[i]以a[i]结尾的元素的最长递增子序列的长度
    	/**
    	 * 5,1,2,0,4,3
    	 */
    	int [] f=new int[arr.length];
    	f[0]=1;
    	int maxLen=0;
		for(int i=1;i<arr.length;i++){
			f[i]=1;
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]&&f[i]<f[j]+1){
			       		f[i]=f[j]+1;
				}
			}
			
		}
//		for(int i=0;i<arr.length;i++){
//		  if(maxLen<f[i]){
//			  maxLen=f[i];
//		  }
		return  f[arr.length-1];
		}
}
