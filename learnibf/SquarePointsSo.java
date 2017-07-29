package learnibf;

import java.util.ArrayList;

public class SquarePointsSo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] strArray={1,2,3,4,5,6,7,8};//12,13,14,15,14,16,15
		char[] test = new char[8];
		boolean flag = false;
		for(int i=0;i<strArray.length;i++){
			test[i] = (char) (strArray[i]+48);
		}
		flag = new SquarePointsSo().is_can(test);
		System.out.println(flag);
	}
    
	public boolean is_can(char [] strArray){
		ArrayList<String> result=new ArrayList<>();
		if(strArray==null||strArray.length<8)  return  false;
		ArrayList<String> quanpailie=getFullPariditionString(strArray,0,strArray.length-1,result);
		//System.out.println(quanpailie);
		for(String s:quanpailie){
			if((s.charAt(0)+s.charAt(1)+s.charAt(2)+s.charAt(3)==s.charAt(4)+s.charAt(5)+s.charAt(6)+s.charAt(7))
					&&(s.charAt(0)+s.charAt(2)+s.charAt(4)+s.charAt(6)==s.charAt(1)+s.charAt(3)+s.charAt(5)+s.charAt(7))
					&&(s.charAt(0)+s.charAt(1)+s.charAt(4)+s.charAt(5)==s.charAt(2)+s.charAt(3)+s.charAt(6)+s.charAt(7))){
			//	System.out.println(s);
				return true;
			}
			//System.out.println(quanpailie.size());
		}
		return false;
	}

	private ArrayList<String> getFullPariditionString(char[] strArray, int start, int end,ArrayList<String> result) {
		if(start>=end){
		   result.add(String.valueOf(strArray));
		   return result;
		}
		for(int i=start;i<=end;++i){
			swap(strArray, i, start);
 			getFullPariditionString(strArray,start+1,end,result);
			swap(strArray, i, start);
//			int flag=is_swap(strArray,start,i);
//			if(flag!=0)]
//				swap(strArray, i, start);
//	 			getFullPariditionString(strArray,start+1,end,result);
//				swap(strArray, i, start);
//			}
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
	private void swap(char[] strArray, int start, int end) {
		// TODO Auto-generated method stub
		char c=strArray[start];
		strArray[start]=strArray[end];
		strArray[end]=c;
	}
}
