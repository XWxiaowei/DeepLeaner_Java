package learnibf;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] test={1,2,3,2,4,2,5,2,3};
    int rs=  new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution2(test);
    System.out.println("vvvv");
	}
    
	/**
	 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
	 *                     
	 *                    超过数组长度的一半，那么该数不可能全部在数组的一半进行分布
	 *                    肯定会跨越 整个的数组区域进行分布
	 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
	 * 如果不存在则输出0。  
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
		int len=array.length;
		if(len==0||len==1){
			return 0;
		}
        Map<Integer, Integer> hashMap=new HashMap<>();
        for(int i=0;i<array.length;i++){
        	if(hashMap.containsKey(array[i])){
        		int count=hashMap.get(array[i]);
        		hashMap.put(array[i], count+1);
        		if((count+1)>len/2){
        			return array[i];
        		}
        	}else
        	{
        		hashMap.put(array[i],1);
        	}
        }
		return 0;    
	    }
	/**
	 *  换一种思路
	 *  1.如果下一个数字和之前的选定数相同则 nTimes++;
	 *  2.else ,nTimes--
	 *  3.如果当出现nTimes=0后，用target替换当前的数，nTimes重新设置为1
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution2(int [] array){
		if(array==null){
			return 0;
		}
		int len=array.length;
		int target=array[0];
		if(len==1) return array[0];
		int nTimes=1;
		for(int i=1;i<len;i++){
			if(nTimes==0){
				target=array[i];
				nTimes=1;
			}else{
				if(array[i]==target){
					nTimes++;	
				}else
				{ 
					//旨在同时消除掉两个不同的数字
					nTimes--;
				}
				
			}
			
		}
		int count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==target){
				count++;
			}
		}
		if(count*2>len)  return target;
		return 0;
	}
}
