package learnibf;

import java.util.Scanner;

public class GussesNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
        	int n=scanner.nextInt();
        	soluction(n);
        }
	}
	/**
	 * 5
	 * 1
	 * 1,5
	 * 1,3
	 * 1,3,5
	 * 1,2
	 * 1,2,5
	 * 1,2,4
	 * 1,2,4,5
	 * 1,2,3
	 * 1,2,3,5
	 * 1,2,3,4
	 * 1,2,3,4,5
	 * @param n
	 */
	public static void soluction(int n){
		int count=1;
		int tmp=2;
		int i=1;
		for(int j=1;j<n;j++)
		{
			//把相关倍数的相加
			if(tmp*j<=n){
				count++;
			}
		}
		System.out.println(count%1000000007);
	}

}
