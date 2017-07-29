package learnibf;

import java.util.ArrayList;
import java.util.Arrays;

public class TheFullPaiStringSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
     ArrayList<String> str=  new TheFullPaiStringSoluction().getFullPariditionString("12,13,14,15,16,17,");
	  System.out.println(str);
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public  ArrayList<String>  getFullPariditionString(String s){
		ArrayList<String> result=new ArrayList<>();
		if(s==null||s.length()==0)  return  result;
		int len=s.length();
		if(len==1)  {
			result.add(s);
			return result;
		};
	    char [] strArray=s.toCharArray();
	    result=getFullPariditionString(strArray,0,len-1,result);
		return  result;
	}
	/**
	 * abc
	 * acb
	 * bac
	 * bca
	 * cab
	 * cba
	 * @param strArray
	 * @param start
	 * @param end
	 * @return
	 */
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
	/**
	 * 去重交换
	 * @param str
	 * @param begin
	 * @param end
	 * @return
	 */
	int  is_swap(char [] str,int  begin,int end){
		 int i,flag;
		 for( i=begin,flag=1;i<end;i++){
			 if(str[i]==str[end]){
				 flag=0;
				 break;
			 }
		 }
		 return   flag;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String next_premutation(String s){
		if(s==null||s.length()==0){
			return  null;
		}
		int len=s.length();
		if(len==1)  return s;
        int pos=len-1;
        while(pos>=0){
        	if(pos>0&&s.charAt(pos)-s.charAt(pos-1)>0){
        		break;
        	}
        	pos--;
        }
        if(pos<0)  return  null;//不存在下一个全排列
        
        int  changIndex=0;
        char strArray[]=s.toCharArray();
        for(int i=len-1;i>=pos;i--){
        	if(s.charAt(i)-s.charAt(pos-1)>0){
        		changIndex=i;
        		swap(strArray,changIndex,pos-1);
        		break;
        	}
        }
        //然后对strArray的pos到结尾的进行降序排列
        Arrays.sort(strArray, pos, len);
        StringBuilder  stringBuilder=new  StringBuilder();
        for(int i=0;i<len;i++){
        	stringBuilder.append(strArray[i]);
        }
		return stringBuilder.toString();
		
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public ArrayList<String>  getFullParationS(String s){
		if(s==null||s.length()==0)  return  null;
		ArrayList<String> res=new ArrayList<>();
		int len=s.length();
		if(len==1)  {
			res.add(s);
			return res;
		}
		while(hasNext_nextMutation(s)){
			res.add(next_premutation(s));
		}
		return res;
	}
	private boolean hasNext_nextMutation(String s) {
		// TODO Auto-generated method stub
		if(s==null||s.length()==0||s.length()==1)  return  false;
		int  pos=s.length()-1;
		while(pos>=0){
			if(pos>0&&s.charAt(pos)-s.charAt(pos-1)>0){
        		break;
        	}
        	pos--;
		}
		return pos>0?true:false;
	}

}
