package leetcode;

public class candySoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int  []  rattings={2,1};
      int res=new  candySoluction().candy(rattings);
      System.out.println("vvvv");
	}
	/**
	 * n个小朋友  分糖，
	 * 每个小朋友 都有一个分数
	 * 确保每个小朋友至少都有一颗糖果的前提下
	 * 
	 *   并且 分数高的小朋友的糖果数目要比相邻的小朋友的糖果数目多。
	 *   求最少需要多少糖果
	 *   
	 * @param ratings
	 * @return
	 */
	 public int candy(int[] ratings) {
		 if(ratings==null||ratings.length==0){
			 return 0;
		 }
		 int  sum[]=new  int[ratings.length];
		 for(int i=0;i<sum.length;i++){
			 sum[i]=1;
		 } 
		 //从左往右边进行扫描 后面的比前面的大
		 for(int i=1;i<ratings.length;i++){
			 if(ratings[i-1]<ratings[i]){
				 sum[i]=sum[i-1]+1;
			 }
		 }
		 //从右边往左边进行扫描
		 for(int j=ratings.length-2;j>=0;j--){
			 if(ratings[j]>ratings[j+1]&&sum[j+1]>=sum[j]){
				 sum[j]=sum[j+1]+1;
			 }
		 }
		 int  res=0;
		 for(int i=0;i<sum.length;i++){
			 res+=sum[i];
		 }
		 return  res;
	    }
}
