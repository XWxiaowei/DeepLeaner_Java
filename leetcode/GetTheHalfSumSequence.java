package leetcode;

import java.util.Arrays;

public class GetTheHalfSumSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int  [] arr={2,4,5,6,7};
       new GetTheHalfSumSequence().soluction(arr);
	}
	/**
	 * ������ֳ����飬ʹ����ĺ͵Ĳ�ľ���ֵ��С
	 * ��ϸ���룬�������ת���ɣ����������ҳ�һ�����ݣ�ʹ֮�����ܵ�������͵�һ�롣
	 * �����������е������Ǳ��������weightֵ�������е���Ҳ�Ǳ��������valueֵ��
	 * ������һ����
     ����V[i][j]��ʾ��i����Ʒ��ѡ������Ϊj����Ʒ������ֵ,weight[i],value[i]�ֱ�����i����Ʒ�������ͼ�ֵ������Ŀ�У�weight��value����ͬһ���飩��

��̬ת�Ʒ���Ϊ:

   V[i][j]=V[i-1][j]  if j<weight[i]

   V[i][j]=max(V[i-1][j],V[i-1][j-weight[i]]+value[i]) if j>weight[i]

    ���⣬�����֪�������Ǽ�����Ʒ��ɵ�����ֵ�����ԴӺ���ǰ���ݣ���V[i][j]>V[i-1][j],˵����i����Ʒ�����루·����Ψһ����
          ���⣺������װ��Щ��Ʒ��ʹ�����ֵ֮����ӽ��ܼ�ֵ��һ��
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
			//���� j��ʾ ����������
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
		//���ݷ� �ҵ������λ��
		System.out.println("����Ҫ�������Ϊ��");
		for(int i=f.length-1;i>=1;i--){
			if(f[i][j]>f[i-1][j]){
				System.out.print(arr[i-1]+" ");
				j=j-arr[i-1];
			}
		}
	}

}
