
public class SLL{

	private Node head;
	private Node tail;
	private int size;
	public SLL(){
		this.size=0;
	}

	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
		public Node (int data,Node next){
			this.data=data;
			this.next=next;

		}
	}

	public void insertFirst(int data){
		Node node=new Node(data);
		node.next=head;
		head=node;
		if(tail==null){
			tail=head;
		}
		size++;
	}

	public void insertLast(int data){

		Node node =new Node(data);
		tail.next=node;
		tail=node;
		size++;
	}

	public void insert(int data,int index){
		Node temp=head;
		for ( int i = 0; i<index-1;i++){
			temp=temp.next;
		}
		Node node=new Node(data,temp.next);
		temp.next=node;
		size++;
	}

	public void deleteFirst(){
		head=head.next;
		size--;
	}

	public void deleteLast(){
		if (tail==null){
			deleteFirst();
			return;
		}
		Node temp=head;
		for(int i=1;i<size-1;i++){
			temp=temp.next;
		}
		tail=temp;
		temp.next=null;
		size--;
	}

	public void deleteIndex(int index){
		Node temp=head;
		Node temp2=head;
		for ( int i = 0; i<index-1;i++){
			temp=temp.next;
		}
		for ( int i = 0; i<index;i++){
			temp2=temp2.next;
		}
		temp.next=temp2.next;
		size--;
	}

	public void size(){
		System.out.println("linked List size: "+size);
	}

	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("null");
	}

	public void getbyIdx(int index){
		Node temp=head;
		for ( int i = 0; i<index-1;i++){
			temp=temp.next;
		}
		System.out.println("Element at Idx "+index+": " +temp.data);
	}
	public void isempty(){
		if (head==null){
			System.out.println("True");
			return;
		}
		System.out.println("False");
	}


	public static void main(String[] args){
		SLL list=new SLL();
		list.isempty();
		list.insertFirst(3);
		list.insertFirst(5);
		list.insertLast(6);
		list.insert(7,2);
		list.insertFirst(2);
		list.insertFirst(1);

		list.deleteFirst();
		list.deleteLast();
		list.deleteIndex(2);
		list.display();
		list.size();
		list.getbyIdx(2);
		list.isempty();

	}
}
