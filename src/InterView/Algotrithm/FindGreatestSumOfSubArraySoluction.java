package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/4/20.
 */
public class FindGreatestSumOfSubArraySoluction {
    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
     * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,
     * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 你会不会被他忽悠住？(子向量的长度至少是1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max=array[0];
        int s=array.length;
        if(s==1){
            return array[0];
        }

        int sum=array[0];
        for (int i = 1; i <array.length ; i++) {
            //max+=array[i];

            sum+=array[i];

            if(sum<array[i]){
                if(sum<max){
                    sum=max;
                }
                else {
                    max=array[i];//之前的累积的和都被尽数抛弃
                    sum=max;
                }
                continue;
            }
            if(array[i]>0)
            {
                if(sum>max){
                    max=sum;
                    continue;
                }
            }
            //否则max不做任何的更新操作
        }
        return max;
    }
    public static void main(String [] args){
        int [] arr={1,-2,3,10,-4,7,2,-5};
        new FindGreatestSumOfSubArraySoluction().FindGreatestSumOfSubArray(arr);
        System.out.println("vvvvv");
    }
}
