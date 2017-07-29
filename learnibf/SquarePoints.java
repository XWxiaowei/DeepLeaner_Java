package learnibf;

import java.util.ArrayList;
import java.util.Arrays;

public class SquarePoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] strArray={11,12,13,14,15,16,17,18};
       System.out.println( new SquarePoints().is_can(strArray));
	}
    
	public boolean is_can(int [] strArray){
		ArrayList<int[]> result=new ArrayList<>();
		if(strArray==null||strArray.length<8)  return  false;
		result =getFullPariditionString(strArray,0,strArray.length-1,result);
		for(int i=0;i<result.size();i++){
			int [] s=result.get(i);
			if((s[0]+s[1]+s[2]+s[3]==s[4]+s[5]+s[6]+s[7])
					&&(s[0]+s[2]+s[4]+s[6]==s[1]+s[3]+s[5]+s[7])
					&&(s[0]+s[1]+s[4]+s[5]==s[2]+s[3]+s[6]+s[7])){
				return true;
			}
		}
		return false;
	}

	private ArrayList<int[]> getFullPariditionString(int[] strArray, int start, int end,ArrayList<int[]> result) {
		if(start>=end){
			int [] temp=new int[strArray.length];
			for(int i=0;i<strArray.length;i++){
				temp[i]=strArray[i];
			}
		   result.add(temp);
		   return result;
		}
		for(int i=start;i<=end;++i){
			swap(strArray, i, start);
 			getFullPariditionString(strArray,start+1,end,result);
			swap(strArray, i, start);
		}
		// TODO Auto-generated method stub
		return result;
	}
	/**
	 * 
	 * @param strArray
	 * @param i
	 * @param i2
	 */
	private void swap(int[] strArray, int start, int end) {
		// TODO Auto-generated method stub
		int c=strArray[start];
		strArray[start]=strArray[end];
		strArray[end]=c;
	}
}
