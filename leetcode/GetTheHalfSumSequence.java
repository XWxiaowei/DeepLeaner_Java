package leetcode;

import java.util.Arrays;

public class GetTheHalfSumSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int  [] arr={2,4,5,6,7};
       new GetTheHalfSumSequence().soluction(arr);
	}
	/**
	 * 将数组分成两组，使两组的和的差的绝对值最小
	 * 仔细想想，问题可以转换成，从数组中找出一组数据，使之尽可能等于数组和的一半。
	 * 条件：数组中的数就是背包问题的weight值，数组中的数也是背包问题的value值，
	 * 即二者一样。
     假设V[i][j]表示从i件物品中选出重量为j的物品的最大价值,weight[i],value[i]分别代表第i件物品的重量和价值（在题目中，weight、value属于同一数组）。

动态转移方程为:

   V[i][j]=V[i-1][j]  if j<weight[i]

   V[i][j]=max(V[i-1][j],V[i-1][j-weight[i]]+value[i]) if j>weight[i]

    另外，如果想知道是由那几件物品组成的最大价值，可以从后往前回溯，当V[i][j]>V[i-1][j],说明第i件物品被加入（路径不唯一）。
          问题：背包里装哪些物品，使得其价值之和最接近总价值的一半
	 * @param arr
	 */
	public  void  soluction(int arr[]){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		int f[][]=new  int[arr.length+1][sum/2+1];
		for(int i=0;i<f.length;i++){
			f[i][0]=0;
		}
		for(int i=0;i<f[0].length;i++){
			f[0][i]=0;
		}
		for(int i=1;i<f.length;i++){
			//其中 j表示 背包的容量
			for(int j=1;j<=sum/2;j++){
				if(j<arr[i-1]){
					f[i][j]=f[i-1][j];
				}
				else
				{
					f[i][j]=Math.max(f[i-1][j-arr[i-1]]+arr[i-1], f[i-1][j]);
				}
			}
		}
		int j=sum/2;
		//回溯法 找到合理的位置
		System.out.println("符合要求的数组为：");
		for(int i=f.length-1;i>=1;i--){
			if(f[i][j]>f[i-1][j]){
				System.out.print(arr[i-1]+" ");
				j=j-arr[i-1];
			}
		}
	}

}
