package learnibf;

import java.util.Scanner;

public class huawei01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		huawei01 test = new huawei01();
		Scanner scanner=new Scanner(System.in);
		
		while(true){
			System.out.println("学生的数目和操作的数目:");
			int  num=scanner.nextInt();
			int operationNUms=scanner.nextInt();
			System.out.println("数组:");
			int[] arr=new int[num];
			for(int i=0;i<num;i++){
				arr[i]=scanner.nextInt();
			}
			//开始操作
			for(int i=0;i<operationNUms;i++){
				System.out.println("输入:falg, start, end：");
				char falg=scanner.next().charAt(0);
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				test.controll(falg, arr, start, end);
			}
		}
	}
	public int max(int[] array,int start,int end){
		if(start>end){
			int temp = start;
			start = end;
			end = temp;
		}
		int maxnumber = array[start-1];
		for(int i=start;i<end;i++){
			if(array[i]>maxnumber){
				maxnumber = array[i];
			}
		}
		return maxnumber;
	}
	
	public void unpdate(int[] array,int index,int value){
		array[index-1] = value;
	}

	public void controll(char flag,int[] array,int start,int end){
		if(flag=='Q'){
			System.out.println(max(array,start,end));
		}else if(flag=='U'){
			unpdate(array,start,end);
		}else{
			return;
		}
	}
}
