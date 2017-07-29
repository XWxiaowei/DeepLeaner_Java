package InterView;

public class GetFullPailIe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s="abc";
        StringBuilder  sb=new StringBuilder();
        for(int i=1;i<s.length();i++){
        	Combine(sb,s,0,i);
        }
	}

	private static void Combine(StringBuilder sb, String s, int begin, int len) {
		// TODO Auto-generated method stub
		if(len==0){
			System.out.print(sb.toString()+" ");
			return;
		}
		if(begin==s.length()){
			return;
		}
		sb.append(s.charAt(begin));
		Combine(sb,s,begin+1,len-1);
		System.out.print(sb.length());
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
		Combine(sb,s,begin+1,len);
	}

	
}
