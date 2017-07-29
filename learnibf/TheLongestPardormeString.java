package learnibf;

public class TheLongestPardormeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s="";
    String v=   new  TheLongestPardormeString().getTheLongestParaDormeString("abc");
    System.out.println("vvvv-----------"+v);
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public  String  getTheLongestParaDormeString(String s){
		if(s==null||s.length()==0)  return  null;
		int len=s.length();
		if(len==1) return  s;
		int MaxLen=0;
		int startIndex=0;
		boolean[][]  f=new  boolean[len+1][len+1];
		//初始化操作--
		for(int i=0;i<len;i++){
			f[i][i]=true;
			if(i<len-1&&s.charAt(i)==s.charAt(i+1)){
				f[i][i+1]=true;
				MaxLen=2;
				startIndex=i;
			}
		}
		for(int subLen=3;subLen<len;subLen++){//子串长度
			for(int i=0;i<=len-subLen;i++){//子串起始地址
				int end=i+subLen-1;
				if(f[i+1][end-1]&&s.charAt(i)==s.charAt(end)){
					f[i][end]=true;
				    if(MaxLen<subLen){
				    	MaxLen=subLen;
				    	startIndex=i;
				    }
				}
			}
		}
		return MaxLen>2?s.substring(startIndex, startIndex+MaxLen):null;
		
	}

}
