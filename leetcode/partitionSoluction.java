package leetcode;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class partitionSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String  s="aa";
        ArrayList<ArrayList<String>>  res=  new  partitionSoluction().partition(s);
        System.out.println(res);
	}  
	
	
	   /**
	    * s ="aab",  res={{"a","a',"b"},{"aa","b"}
	    * @param s
	    * @return
	    */
	    public ArrayList<ArrayList<String>> partition(String s) {
	    	ArrayList<ArrayList<String>>  result=new  ArrayList<>();
	    	if(s==null||s.trim()==null)  return  result;
	    	if(s.trim().length()==1){
	    		ArrayList<String>  tempList=new ArrayList<>();
	    		tempList.add(s);
	    		result.add(tempList);
	    		return  result;
	    	}
	    	result=getAllImpossiblePaths(result,new Stack<String>(),s);
			return result;
	        
	    }
   
    /**
     * 在栈里面 保存一条可行的分割结果
     * @param result
     * @param stack
     * @param s
     * @return
     */
	private ArrayList<ArrayList<String>> getAllImpossiblePaths(ArrayList<ArrayList<String>> result, Stack<String> stack,
			String s) {
		// TODO Auto-generated method stub
		if(s.length()==1||s.length()==0){
			Iterator<String>  iterator=stack.iterator();
			ArrayList<String>  arrayList=new  ArrayList<>();
			while(iterator.hasNext()){
				arrayList.add(iterator.next());
			}
			if(s.length()!=0){
				arrayList.add(s);
			}
			result.add(arrayList);
			
			return result;
		}
		for(int i=0;i<s.length();i++){
			int  begin=0;
			int end=i;
			while(begin<end){
				if(s.charAt(begin)==s.charAt(end)){
					begin++;
					end--;
				}
				else{
					break;
				}
			}
			if(begin>=end){
				stack.push(s.substring(0,i+1));
				getAllImpossiblePaths(result,stack,s.substring(i+1));
				stack.pop();
			}
			
		}
		return result;
	}
}
