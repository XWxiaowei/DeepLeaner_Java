package leetcode;

public class candySoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int  []  rattings={2,1};
      int res=new  candySoluction().candy(rattings);
      System.out.println("vvvv");
	}
	/**
	 * n��С����  ���ǣ�
	 * ÿ��С���� ����һ������
	 * ȷ��ÿ��С�������ٶ���һ���ǹ���ǰ����
	 * 
	 *   ���� �����ߵ�С���ѵ��ǹ���ĿҪ�����ڵ�С���ѵ��ǹ���Ŀ�ࡣ
	 *   ��������Ҫ�����ǹ�
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
		 //�������ұ߽���ɨ�� ����ı�ǰ��Ĵ�
		 for(int i=1;i<ratings.length;i++){
			 if(ratings[i-1]<ratings[i]){
				 sum[i]=sum[i-1]+1;
			 }
		 }
		 //���ұ�����߽���ɨ��
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
