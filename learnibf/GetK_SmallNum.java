package learnibf;

import java.util.Scanner;

public class GetK_SmallNum {
   
	public static void main(String [] args){
		//int [] arr={3,2,7,5,1};
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			int [] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
			}
			soluction(arr,k);
			//scanner.close();
		}
		
	}
	public static  void soluction(int []arr,int k){
		int s=arr.length;
		if(s==0||s==1){
			return;
		}
		int index=Paration(arr,0,s-1);
		if(index==k){
			System.out.println(index);
			return;
		}
	    if(index<k){
	    	Paration(arr,index,s-1);
	    }
	    if(index>k){
	    	Paration(arr,0,index);
	    }
	    
	}
	
	private static int Paration(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
	    int base=start;
	  //  swap(arr[start], arr[end]);
	    int i=end,j=end;
	    //j总是指向比基准数小的数字
	    //如果当前的数比基准数小 那么i,j都是同步进行减小的，否则j不变
	    for(;i>=start;i--){
	    	if(arr[i]>=arr[base]){
	    		if(i!=j)
	    		{
	    			//j已经指向比基准的数字大的数字了
	    			//如果当前的数字比基准数子小
	    			swap(arr,i,j);
	    		}
	    	  j--;
	    	}
	    }
	    swap(arr,base, arr[j]);
		return j;
	}
	private static void swap(int arr[],int base, int i) {
		// TODO Auto-generated method stub
		int temp=arr[base];
		arr[base]=arr[i];
		arr[i]=temp;
	}
}
