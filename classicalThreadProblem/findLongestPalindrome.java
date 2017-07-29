package classicalThreadProblem;

public class findLongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "yyyccyyyeewgabjbavvdds";
		
		System.out.println(makeString(S));
		
		
		System.out.print(findLongestPalind1(S));
	}
	public static String findLongestPalind(String S){
		int Max=0;
		int index=0;
		for(int i=0;i<S.length();i++){
			for(int j=i+1;j<S.length();j++){
				
				String subS = S.substring(i, j+1);
				if(ishuiwen(subS)){
					if(Max<subS.length()){;
						Max=subS.length();
						index=i;
					}
				}
			}
			
		}
		return S.substring(index, index+Max);
	}
	public static String findLongestPalind1(String S1){
		String S = makeString(S1);
		int index=0;
		int Max=0;
		for(int i=0;i<S.length();i++){
			int k=i-1;
			int n=i+1;
			while(k>=0&&n<S.length()){
				if(S.charAt(k)==S.charAt(n)){
					if(Max<(n-k+1)){
						Max=n-k+1;
						index=k;
					}	
					k--;
					n++;
				}else{
					break;
				}
					
			}
			
		}
		
		return removeString(S.substring(index, index+Max));
	}
	public static boolean ishuiwen(String S){
		int j = S.length()-1;
		int i = 0;
		while(j-i>=1){
			if(S.charAt(i)!=S.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	public static String makeString(String S){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<S.length();i++){
			sb.append(S.charAt(i)).append('#');
		}	
		return sb.toString().substring(0, sb.length()-1);	
	}
	public static String removeString(String S){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<S.length();i+=2){
			sb.append(S.charAt(i));
		}	
		return sb.toString();	
	}

}
