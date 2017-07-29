package learnibf;

import java.util.Scanner;

public class TheLongestO extends Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new  Scanner(System.in);
        while(scanner.hasNext()){
        	String s=scanner.next();
        	getSolcuton(s);
        }
	}
	public static void getSolcuton(String s){
		if(s==null||s.trim().length()==0){
			return;
		}
		int len=s.length();
		//最长偶数串的长度必然大于2且是2的倍数
		int maxtLen=0;
		for(int i=len-1;i>=1;i--){
			String temp=s.substring(0, i);
			if(isTrue(temp)){
				if(temp.length()>maxtLen){
					maxtLen=temp.length();
				}
			}
		}
		System.out.println(maxtLen);
	}
	private static boolean isTrue(String temp) {
		// TODO Auto-generated method stub
		if(temp.length()%2!=0) return false;
		if(temp.substring(0, temp.length()/2).equals(temp.substring(temp.length()/2))){
			return true;
		}
		return false;
	}
}
