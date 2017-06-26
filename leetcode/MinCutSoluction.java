package leetcode;
/**
 * 
 *    ���⣺���ַ�������С�ָ�����ʹ�÷ָ����Ӵ����ǻ��Ĵ���
               ��̬�滮�Ĺؼ����ҳ����淽�̣�cutNum[i] = min(cutNum[i], cutNum[j + 1] + 1)
      cuntNum[i] ��ʾ�ַ��� s �� i ��ĩβ���Ӵ�����Ҫ����С����������� i �� j ���Ӵ�Ϊ���Ĵ��Ļ���
               ��ô��С�����Ϳ���Ϊ j + 1�Ժ���Ӵ�����С�������� j �� j + 1 ֮���һ�
 *    1. http://blog.csdn.net/ljiabin/article/details/41173417
 *    2.http://blog.csdn.net/jingsuwen1/article/details/51934277
 *    3.leetCode�Ķ�̬�滮�����ܽ᣺http://blog.csdn.net/jingsuwen1/article/details/51934277
 *    4.http://blog.csdn.net/trochiluses/article/details/38017655
 *    5.http://www.cnblogs.com/grandyang/p/4271456.html
 *    6.http://www.cnblogs.com/springfor/p/3891896.html
 *    7.http://blog.csdn.net/yutianzuijin/article/details/16850031  �ص�
 *    8.��Ϊ���� �ϳ��ӣ�http://blog.csdn.net/jingsuwen1/article/details/52164335
 * @author Administrator
 *
 */
public class MinCutSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int minCut(String s) {  
	        int min = 0;  
	        int len = s.length();  
	        boolean[][] matrix = new boolean[len][len];  
	        int cuts[] = new int[len+1];  
	          
	        if (s == null || s.length() == 0)  
	            return min;  
	         
	        for (int i=0; i<len; ++i){  
	            cuts[i] = len - i;  //cut nums from i to len [i,len]
	        }  
	          
	        for (int i=len-1; i>=0; --i){  
	            for (int j=i; j<len; ++j){  
	                if ((s.charAt(i) == s.charAt(j) && (j-i<2))  
	                        || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))  
	                {  
	                    matrix[i][j] = true;  
	                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);  
	                }  
	            }  
	        }  
	        min = cuts[0]-1;  
	        return min;  
	    }
	
    
}
