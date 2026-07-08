
public class DLL{

	private Node head;
	private Node tail;
	private int size;
	public DLL(){
		this.size=0;
	}

	class Node{
		int data;
		Node next;
		Node prev;
		public Node(int data){
			this.data=data;
		}
		public Node (int data,Node next,Node prev){
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
	}

	public void insertFirst(int data){

		Node node=new Node(data);
		node.next=head;
		node.prev=null;
		head=node;
		if(tail==null){
			tail=head;
		}

		size++;
	}

	public void insertLast(int data){
		if (head==null){
			insertFirst(data);
			return;
		}
		Node node = new Node(data);
		tail.next=node;
		node.prev=tail;
		node.next=null;
		tail=node;
		size++;
	}

	public void insert(int data,int index){
		if(index==size){
			insertLast(data);
			return;
		}
		if (index==0){
			insertFirst(data);
			return;
		}
		if(index>size){
			System.out.println("the index is out of bind");
			return;
		}
		Node temp=head;
		for(int i=0;i<index;i++){
			temp=temp.next;
		}
		Node temp2=head;
		for(int i=0;i<index-1;i++){
			temp2=temp2.next;
		}
		Node node = new Node(data);
		node.prev=temp.prev;
		node.next=temp;
		temp.prev=node;
		temp2.next=node;
		size++;
	}

	public void deleteFirst(){
		head=head.next;
		size--;
	}

	public void deleteLast(){
		tail=tail.prev;
		tail.next=null;
		size--;
	}

	public void delete(int index){
		if(index==size){
			deleteLast();
			return;
		}
		if(index==0){
			deleteFirst();
			return;
		}
		if(index>size){
			System.out.println("index is out of bound");
			return;
		}
		Node temp=head;
		for(int i=0;i<index;i++){
			temp=temp.next;
		}
		Node temp2=head;
		for(int i=0;i<index-1;i++){
			temp2=temp2.next;
		}
		// System.out.println(head.data);
		// System.out.println(temp.data);
		temp2.next=temp.next;
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
		for ( int i = 0; i<index;i++){
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

	public void tail(){
		System.out.println(tail.data);
	}

	public static void main(String[] args){
		DLL list=new DLL();
		list.isempty();
		list.insertFirst(3);
		list.insertFirst(5);
		list.insertLast(6);
		list.insert(7,2);
		list.insertFirst(2);
		list.insertFirst(1);

		list.deleteFirst();
		list.deleteLast();
		// list.deleteIndex(2);

		list.delete(2);
		list.display();
		list.tail();
		list.size();
		list.getbyIdx(2);
		list.isempty();

	}
}
