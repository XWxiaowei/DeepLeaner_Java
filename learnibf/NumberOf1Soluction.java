package learnibf;

public class NumberOf1Soluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int s=    new  NumberOf1Soluction().NumberOf1(5);
     System.out.println(s);
	}
	public int NumberOf1(int n) {
		if(n==0) return  0;
		int count2=0;
		int  count=0;
		int flag=1;
		while(flag!=0){
			if((n&flag)!=0){;
			count++;
			}
			flag<<=1;
			++count2;
		}
		System.out.println(count2);
		return count;
		

    }

}
