package classicalThreadProblem;

import java.util.ArrayList;
import java.util.List;

public class Demo {
  
	public static  void  main(String [] args){
	
		 List<String> arrsyStr=new ArrayList<>();
		 List arrsy=new ArrayList<>();
		 Class class1=arrsyStr.getClass();
		 Class class2=arrsy.getClass();
		 System.out.println(class1==class2);
		 
	}
}
