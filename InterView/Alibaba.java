package InterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Alibaba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    ArrayList<Integer> _ids = new ArrayList<Integer>();
	        ArrayList<Integer> _parents = new ArrayList<Integer>();
	        ArrayList<Integer> _costs = new ArrayList<Integer>();

	        Scanner in = new Scanner(System.in);
	        String line = in.nextLine();

	        while(line != null && !line.isEmpty()) {
	            if(line.trim().equals("0")) break;
	            String []values = line.trim().split(" ");
	            if(values.length != 3) {
	                break;
	            }
	            _ids.add(Integer.parseInt(values[0]));
	            _parents.add(Integer.parseInt(values[1]));
	            _costs.add(Integer.parseInt(values[2]));
	            line = in.nextLine();
	        }
	        int res = resolve(_ids, _parents, _costs);

	        System.out.println(String.valueOf(res));
	}
    // write your code here
 public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
      int res=0;
	 //先找到根节点
	 ArrayList<Integer> rootsIndex=new  ArrayList<>();
	 Map<Integer,Integer> path=new HashMap();
	 for(Integer s:parents){
		 if(s==0){
			 rootsIndex.add(ids.get(s));
		 }
	 }
	 if(rootsIndex.size()>=1){
		 //根据每个根节点找到一条路径
		 for(int index:rootsIndex){
			 path.put(ids.get(index), costs.get(index));
		 }		 
	 }
	 else
	 {
		 Collections.max(costs);
		 res=costs.get(costs.size()-1);
	 }
     return res;
 }
}
