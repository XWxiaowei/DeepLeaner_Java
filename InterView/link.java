package InterView;
//���Ա����ʽ�洢
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
	public Node first;//����һ��ͷ���
	public link(){
		this.first = null;
	}
	//����һ��ͷ���
	public void addFirstNode(int data){
		Node node = new Node(data);
		node.next = first;
		first = node;
	}
	//ɾ��һ��ͷ���
	public Node deleteFirstNode(){
		Node tempNode = first;
		first= tempNode.next;
		return tempNode;	
	}
	//������λ�ò���ڵ� ��index�ĺ������
	public void add(int index,int data){
		int pos = 0;//�ڵ��λ��
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
	//ɾ������λ�õĽڵ�
	public Node deleteByPos(int index){
		int pos = 0;//�ڵ��λ��
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
	//���ݽڵ��dataɾ���ڵ�
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
	//��ʾ�����еĽڵ���Ϣ
	public void displayAllNodes(){
		Node current = first;
		while(current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	//����λ�ò��ҽڵ���Ϣ
	public Node findByPos(int index){
		int pos = 0;//�ڵ��λ��
		Node current = first;
		if(pos!=index){
			pos++;
			current = current.next;
			
		}
		return current;
	}
	//�������ݲ��ҽڵ���Ϣ
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
	protected Node next;//ָ����
	protected int data;//������
	public Node(int data){
		this.data = data;
	}
	//��ʾ�˽ڵ�
	public void display(){
		System.out.println(data+" ");
	}
}
