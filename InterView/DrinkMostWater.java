package InterView;

import java.util.Scanner;

public class DrinkMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextInt()){
			int temp=scanner.nextInt();
			if(temp!=0){
				getWaters(temp);
			}
			else{
				continue;
			}
		}
           
	}
	/**
	 * 10%3=3----1 -----4 
	 * 9---5  4--2
	 * 9--3
	 * 4%3=1--1 
	 * 81%3=27-------27
	 * 27/3=9--------9
	 * 9/3=3----------3
	 * 3/3--1          1   
	 * 10--3...1
	 * 
	 * 
	 */
	public static void getWaters(int n){
		
		if(n<=0) return;
		int count=0;
		if(n==1){
			System.out.println(0);
			return;
		}
		if(n==2||n==3){
			System.out.println(1);
			return;
		}
		int leave,times=0;
		while(n!=0){
			if(n<=3){
				break;
			}
			leave=n%3;
			times=n/3;
			count+=times;
			n=leave+times;
		}
		if(n==2||n==3){
			count+=1;
		}
		System.out.println(count);
	}
}
