package learnibf;

public class PowerSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerSoluction test = new PowerSoluction();
		System.out.println(test.Power(2, -3));
	}
	  /**
	   * 5.0  3
	   * 5.0*5.0*5.0
	   * -2 3  =-8
	   * 2 -3  =0.125
	   * -2 -3 =-0.125
	   * @param base
	   * @param exponent
	   * @return
	   */
	  public double Power(double base, int exponent) {
		  if(exponent==0){return 1;}
		  if(base==0){return 0;}
		  double x=base;
		  double y = exponent;
		  double curent=Math.abs(base);
		  for(int i=0;i<Math.abs(exponent)-1;i++){
			
			  base=Math.abs(base)*curent;
		}
		  if(x>0&&y>0){
			  return base;
		  }else if(x>0&&y<0){
			  return 1/base;
		  }else if(x<0&&y>0){
			  return -base;
		  }else{
			  return -1/base;
		  }
        
	  }

}
