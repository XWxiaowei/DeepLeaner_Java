package learnibf;

public class hasPathSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] matrix={ 'a', 'b', 'c', 'c', 's','f', 'c', 's', 'a', 'd', 'e', 'e'};
		char[] str = {'b','c','c','e','d'};
		hasPathSoluction test = new hasPathSoluction();
		System.out.println(test.hasPath(matrix, 3, 4, str));
	}
	/**
	 * 
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 * @return
	 */
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    
	 {
		 boolean [] visited=new boolean[matrix.length];
		 for(int i=0;i<rows;i++){
			 for(int j=0;j<cols;j++){
				 if(hasPathInMartix(matrix,i,j,0,str,rows,cols,visited)){
					 return true;
				 }
			 }
		 }
		return false;
	 }
	
	private boolean hasPathInMartix(char[] matrix, int i, int j, int k, char[] str, int rows,
			int cols, boolean[] visited) {
		// TODO Auto-generated method stub
 		int  index=i*cols+j;
		if(i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||visited[index]){
			return  false;
		}
		visited[index]=true;
		if(k==str.length-1){
			return true;
		}
		if(hasPathInMartix(matrix, i-1, j, k+1, str, rows, cols, visited)||
		   hasPathInMartix(matrix, i, j-1, k+1, str,  rows, cols, visited)||
		   hasPathInMartix(matrix, i, j+1, k+1, str,  rows, cols, visited)||
		   hasPathInMartix(matrix, i+1, j, k+1, str,  rows, cols, visited))
		{
			return  true;
		}else
		{
		   k--;
		   visited[index]=false;
		}
		return false;
	}
	 
}
