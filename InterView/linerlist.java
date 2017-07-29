package InterView;
//线性表的顺序存储
import javax.swing.table.TableColumn;

public class linerlist {
	static int []arr={3,5,6};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		linerlist test = new linerlist();
		
		
		System.out.println("------插入前：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("------插入后：");
		test.insertElem(2, 17);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("------删除后：");
		test.delete(1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}
	//获得线性表中第i个元素
	public int getElem(int[] arr,int i){
		if(arr.length<=0||i<=0||i>arr.length){
			return -1;
		}
		return arr[i];	
	}
	//在第i个元素之后插入元素
	public boolean insertElem(int i,int t){
		if(i<0||i>arr.length||arr==null||arr.length==0){
			return  false;
		}
		//不在末尾
		int  [] newArray=new int[arr.length+1];
		if(i<=arr.length-1){
			
			for(int j=0;j<arr.length;j++){
				newArray[j]=arr[j]; 
			}
			for(int k=arr.length;k>i;k--){
				newArray[k]=newArray[k-1];
			}
		}
		newArray[i]=t;
		arr=newArray;
		return true;
		
	}
	//删除第i个元素
	public void delete(int i){
		if(i<0||i>arr.length||arr==null||arr.length==0){
			return ;
		}
		int [] newarr=new int[arr.length-1];
		for(int k=0;k<i-1;k++){
			newarr[k]=arr[k];
		}
		for(int k=i-1;k<arr.length-1;k++){
			newarr[k]=arr[k+1];
		}
		arr=newarr;
	}

}
