package learnibf;

import java.util.ArrayList;

public class GetLeastNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]={4,2,8,3};
  int res=new GetLeastNumbers().anOtherParationFunction(arr,0,3);
   System.out.println();
      
	}
	/**
	 * 输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，
	 * 则最小的4个数字是1,2,3,4,。
	 * @param input
	 * @param k
	 * @return
	 */
   public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
	  int len=input.length;
	  ArrayList<Integer> result=new ArrayList<>();
	  if(input==null||len<k||k<=0){
		  return result;
	  }
	  int index=Paration(input,0,len-1);
//	  if(index==k-1){
//		  for(int i=0;i<=index;i++){
//			  result.add(input[i]);
//		  }
//		  return result;
//	  }
	  //如果小于 3 5
	  int start=0,end=len-1;
	  while(index!=k-1){
		  if(index<k-1){
			     start=index+1;
				 index= Paration(input,start,end);
			  }
			  if(index>k-1){
				  end=index-1;
				 index= Paration(input,start,end);
			  }
	  }
	  if(index==k-1){
		  for(int i=0;i<=index;i++){
			  result.add(input[i]);
		  }
		  return result;
	  }
	   return result;
    }
    /*
     * 快速排序的分区函数
     * @param input
     * @param i
     * @param j
     * @return
     */
	private int Paration(int[] input, int start, int end) {
		// TODO Auto-generated method stub
		int base=input[start];//基准数保存到start里面
		int i=start;
		int j=end;
        while(i!=j){
        	while(input[j]>=base&&i<j){
        		j--;
        	}
        	while(input[i]<=base&&i<j){
        		i++;
        	}
        	if(i<j){
        		swap(input,i,j);
        	}
        }
        //基准数进行归位处理
        swap(input,start,j);
		return j;
	}
	/**
	 * 4,2,8,3
	 * 基准选择4
	 * 2,1,8,4
	 * i=1,j=1  --1  ----2,1,8,4
	 * i=2,j=1  ---  ----2,1,8,4
	 * i=3,j=1 ---------- 
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int anOtherParationFunction(int [] arr,int start,int end){
		int base=arr[0];
		swap(arr, start, end);//目的在选择第一个数作为基准
		int j=0;//其中j始终指向大于基准的数字
		for(int i=0;i<end;i++){
			if(arr[i]<base){
				 if(i>j){
					 swap(arr, i, j);
				 }
				j++;//如果j始终小于最后的基准数字那么i,和j都是同步进行增加的
			}
		}
		swap(arr, j, end);
		return j;
		
	}
	private void swap(int[] input, int j, int i) {
		// TODO Auto-generated method stub
		int temp=input[i];
		input[i]=input[j];
		input[j]=temp;
	}
}
