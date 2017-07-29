package InterView;

import java.util.Scanner;

public class ReverseTheNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner  scanner=new Scanner(System.in);
       while(scanner.hasNextInt()){
    	   int num=scanner.nextInt();
    	  String res= getTheReverString(num);
    	  System.out.println(res);
       }
	}
	/**
	 * 1516000---->"0006151"
	 * @param num
	 * @return
	 */
    public static String getTheReverString(int num){
    	StringBuilder sb=new StringBuilder();
    	if(num==0){
    		return "0";
    	}
    	while(num!=0){
    		sb.append(num%10);
    		num/=10;
    	}
		return sb.toString();
    }
}
