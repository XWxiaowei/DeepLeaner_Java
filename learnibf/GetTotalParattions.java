package learnibf;

import java.util.ArrayList;
import java.util.Stack;

public class GetTotalParattions {

	public static void main(String[] args) {
		char[] test = {'a','b','c'};
		
		System.out.println(combine2(test));
	}
	
	public static ArrayList<String> combine(char chs[]){   
		ArrayList<String> arrayList = new ArrayList<String>();
	    if(chs.length == 0) return arrayList;    
	        
	    Stack<Character> stack = new Stack<Character>();    
	    for(int i = 1; i <= chs.length; i++){    
	    	arrayList = combine(chs, 0, i, stack,arrayList);    
	    }  
	    return arrayList;
	} 
	public static ArrayList<String> combine2(char chs[]){   
		ArrayList<String> arrayList = new ArrayList<String>();
	    if(chs.length == 0) return arrayList;      
	    for(int i = 1; i <= chs.length; i++){    
	    	arrayList = combine(chs, 0, i,arrayList);    
	    }  
	    return arrayList;
	} 
	//从字符数组中第begin个字符开始挑选number个字符加入stack中    
	public static ArrayList<String> combine(char []chs, int begin, int number, Stack<Character> stack,ArrayList<String> arrayList){    
	       if(number == 0){   
	    	   StringBuilder stringBuilder=new StringBuilder();
	    	   for(char c:stack){
	    		   stringBuilder.append(c);
	    	   }
	    	  
//	        System.out.println(stringBuilder.toString());    
//	    	System.out.println(stack.toString()); 
	    	arrayList.add(stringBuilder.toString());
	        return arrayList;    
	       }    
	       if(begin == chs.length){    
	        return arrayList;    
	       }    
	       stack.push(chs[begin]);    
	       combine(chs, begin + 1, number - 1, stack,arrayList);    
	       stack.pop();    
	       combine(chs, begin + 1, number, stack,arrayList);   
	       return arrayList;
	}    
	public static ArrayList<String> combine(char []chs, int begin, int number, ArrayList<String> arrayList){
		if(number==0){
			arrayList.add(String.valueOf(arrayList));
			return  arrayList;
		}
		if(begin==chs.length){
			return  arrayList;
		}
		arrayList.add(chs[begin]+"");
		combine(chs, begin + 1, number - 1,arrayList);
		arrayList.remove(arrayList.size()-1);
		combine(chs, begin + 1, number,arrayList);
		return arrayList;
		
	}
    
    
}
