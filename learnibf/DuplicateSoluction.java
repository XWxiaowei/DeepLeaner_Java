package learnibf;


import java.util.HashSet;
import java.util.Set;

public class DuplicateSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]={2,1,3,1,4};
       int ss[]=new int[5];
       boolean flag=new DuplicateSoluction().duplicate(arr, 5, ss);
	}
	/**
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
	 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
	 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
	 * 那么对应的输出是重复的数字2或者3。
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(length==0||numbers==null)  return false;
		Set<Integer>  hashMap=new HashSet();
		for(int i=0;i<length;i++){
			if(hashMap.contains(numbers[i]))
			{
			  duplication[0]=numbers[i];
			  return true;
			}
			else
			{
				hashMap.add(numbers[i]);
			}
		}
		return false;
    }
}
