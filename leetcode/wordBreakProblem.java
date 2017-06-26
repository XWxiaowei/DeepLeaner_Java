package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 记s[j] 也就是字符串s的前j个可以在dict里面找到匹配的答案，
	 * s ="leetcode",
       dict =["leet", "code"].
       Return true because"leetcode"can be segmented as"leet code".
	 * @param s
	 * @param dict
	 * @return
	 */
	 public boolean wordBreak(String s, Set<String> dict) {
		 List<String> wordDict  =new  ArrayList<>();
		 Set<String>  myDict=new  HashSet<>(wordDict);
		 if(s==null||s.length()==0)  return  false;
		 boolean[] result=new boolean[s.length()+1];
		 result[0]=true;
		 for(int i=0;i<s.length();i++){
		    for(int j=0;j<=i;j++){
		     	if(dict.contains(s.substring(j, i+1))&&result[j]){
		     		result[i+1]=true;
		     		break;
		     	}
		    }
		 }
		 return result[s.length()]; 
	 }

}
