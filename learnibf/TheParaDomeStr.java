package learnibf;

import java.util.Scanner;

public class TheParaDomeStr {
	
	public static void main(String[] args){
		Scanner  scanner=new Scanner(System.in);
		
		while(scanner.hasNext()){
			String s=scanner.next();
			int f=minCut(s);
			System.out.println(f+1);	
		}
	}
    public static int minCut(String s) {
        if(s == null||s.length() == 0)
            return 0;
        int[] dp=new int[s.length()];
        //dp[i]存放(0,i)即以i的字符结束的子串的最小切割数，则所求为dp[s.length()-1];
        dp[0]=0;//一个字符，不需要切割
        for(int i=1;i<s.length();i++)
            {
            //dp[i]赋初值
            dp[i]=is_palindrome(s.substring(0,i+1))?0:i+1;
            //  1=<j<=i的子串回文判定
            for(int j=i;j>=1;j--)
                {
                if(is_palindrome(s.substring(j,i+1)))
                    {
                  dp[i]=Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
    //判断回文串例程
    public static boolean is_palindrome(String s)
        {
        int begin=0;
        int end=s.length()-1;
        while(begin<end)
            {
            if(s.charAt(begin)!=s.charAt(end))
                return false;
            begin++;
            end--;            
        }
        return true;
    }
}
