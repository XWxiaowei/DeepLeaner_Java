package InterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class RemoveTheLeastChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner scanner=new Scanner(System.in);
         while(scanner.hasNext()){
        	String s=scanner.next();
        	System.out.println(RemoveTheStrings(s));
         }
	}
	/**
	 * 
	 * a-----z
	 * 0-----25
	 * abcdd
	 * 
	 * 
	 * ccccc---ccccc
	 * ddccfff---fff
	 * @param 
	 * @return
	 */
    public static String RemoveTheStrings(String s){
    	if(s==null||s.length()==0){
    		return  s;
    	}
        int [] map=new int[26];
    	//先进行统计
        for(int i=0;i<s.length();i++){
        	    System.out.println(s.charAt(i)-'a');
        	     map[s.charAt(i)-'a']++;
        }
        //Arrays.sort(map);
        //   a-3\  b--2 c--1 d--2
        //对字符串里面的进行统计
        Map<Integer,List<Character>>  tempMap=new HashMap<>();
        for(int i=0;i<map.length;i++){
        	if(map[i]!=0)
        	{
        		if(tempMap.containsKey(map[i])){
        			List<Character>  value=tempMap.get(map[i]);
        			value.add((char) (i+'a'));
        	}else{
        		List<Character>  list=new ArrayList<>();
        		list.add((char) (i+'a'));
        		tempMap.put(map[i], list);
        	}
        	}
        }
        StringBuilder stringBuilder=new StringBuilder();
        Set<Integer> set=tempMap.keySet();
        List<Integer> li=new  ArrayList<>();
        for(int f:set){
        	li.add(f);
        }
       Collections.sort(li);
        List<Character>  res=tempMap.get(li.get(0));
        for(int i=0;i<s.length();i++){
        	if(!res.contains(s.charAt(i))){
        		stringBuilder.append(s.charAt(i));
        	}
        }
		return stringBuilder.toString();
    }
}
