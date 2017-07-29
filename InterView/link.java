package InterView;
//线性表的链式存储
public class link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		link test = new link();
		test.addFirstNode(20);//20
		test.addFirstNode(21);//21,20
		test.addFirstNode(19);//19,21,20
		test.add(1, 22);//19,22,21,20
		test.add(2, 23);//19,22,23,21,20
		test.add(3, 99);//19,22,23,99,21,20
		test.deleteFirstNode();//22,23,99,21,20
		test.deleteByPos(3);//22,23,99,20
		test.deleteByData(23);//22,99,20
		System.out.println(test.findByPos(2).data);
		System.out.println(test.findByData(99).data);
		test.displayAllNodes();

	}
	public Node first;//定义一个头结点
	public link(){
		this.first = null;
	}
	//插入一个头结点
	public void addFirstNode(int data){
		Node node = new Node(data);
		node.next = first;
		first = node;
	}
	//删除一个头结点
	public Node deleteFirstNode(){
		Node tempNode = first;
		first= tempNode.next;
		return tempNode;	
	}
	//在任意位置插入节点 在index的后面插入
	public void add(int index,int data){
		int pos = 0;//节点的位置
		Node node = new Node(data);
		Node current = first;
		Node previous = first;
		//System.out.println(pos);
		while(pos != index){
			previous = current;
			current = current.next;
			pos++;
		}
		node.next = current;
		previous.next = node;
		
	}
	//删除任意位置的节点
	public Node deleteByPos(int index){
		int pos = 0;//节点的位置
		Node current = first;
		Node provoius = first;
		while(pos != index){
			provoius=current;
			current = current.next;
			pos ++;
		}
		if(current==first){
			first = first.next;
		}else{
			provoius.next = current.next;
		}
		return current;
	}
	//根据节点的data删除节点
	public Node deleteByData(int data){
		Node current = first;
		Node previous = first;
		while(current.data!=data){
			if(current.next==null){
				return null;
			}
			previous = current;
			current = current.next;
		}
		if(current==first){
			first = first.next;
		}else{
			previous.next = current.next;
		}
		return current;
		
	}
	//显示出所有的节点信息
	public void displayAllNodes(){
		Node current = first;
		while(current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	//根据位置查找节点信息
	public Node findByPos(int index){
		int pos = 0;//节点的位置
		Node current = first;
		if(pos!=index){
			pos++;
			current = current.next;
			
		}
		return current;
	}
	//根据数据查找节点信息
	public Node findByData(int data){
		Node current = first;
		while(current.data!=data){
			if(current.next==null){
				return null;
			}
			current = current.next;
		}
		return current;
	}

}
class Node{
	protected Node next;//指针域
	protected int data;//数据域
	public Node(int data){
		this.data = data;
	}
	//显示此节点
	public void display(){
		System.out.println(data+" ");
	}
}
