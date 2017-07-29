package learnibf;

public class ReverseSentenceSoluction {

	public static void main(String [] args){
	
		String test=" ";
	String ss=	new ReverseSentenceSoluction().ReverseSentence(test);
	System.out.println(ss);
	}
	/**
	 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
	 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
	 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
	 * I ma a .tneduts
	 * I am a student.
	 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
	 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
	 * @param str
	 * @return
	 */
     public String ReverseSentence(String str) {
		
		StringBuilder result=new StringBuilder();
		int  len=str.length();
		if(str==null){
			return null;
		}
		if(len==1||len==0){
			return str;
		}
		String temp= ReverStr(str,0,len-1);
		 String [] strArray=temp.split(" ");
		 for(int i=0;i<strArray.length-1;i++){
			 result.append(ReverStr(strArray[i],0,strArray[i].length()-1));
			 result.append(" ");
		 }
		 result.append(ReverStr(strArray[strArray.length-1],0,strArray[strArray.length-1].length()-1));
	     return result.toString();
	  }
     /**
      * 
      * @param str
      * @param start
      * @param end
     * @return 
      */
	private String ReverStr(String str, int start, int end) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=end;i>=start;i--){
			stringBuilder.append(str.charAt(i));
		}
		return stringBuilder.toString();
	}
}
