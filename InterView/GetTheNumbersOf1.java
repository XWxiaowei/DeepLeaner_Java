package InterView;

import java.util.Scanner;

public class GetTheNumbersOf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
        	int s=scanner.nextInt();
        	System.out.println(getTotalIofInt(s));
        }
	}
	/**
	 * 求给定的数字n里面在内存进行存储的时候1的个数
	 * 例如给定5 得到0101---》2
	 * 0100-->4  0100   0100--4
	 * 0101-->5  0011   0011--3
	 *                  0000--
	 * ----
	 * 0100             
	 * @param n
	 * @return
	 */
	public static int  getTotalIofInt(int n){
		int  count=0;
		int flag=1;
		while(flag!=0){
			if((n&flag)!=0){
				count++;
			}
			flag<<=1;
		}
		return count;
	}

}
