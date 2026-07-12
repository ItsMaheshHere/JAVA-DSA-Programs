public class CLL{

	private Node head;
	private Node tail;
	private int size=1;
	public CLL(){
		this.head=null;
		this.tail=null;
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

	public void insert(int data){

		Node node=new Node(data);
		if(head==null){
			head=node;
			tail=node;
			return;
		}
		tail.next=node;
		node.next=head;
		node.prev=tail;
		tail=tail.next;
		tail=node;
		size++;
	}
	public void insertFirst(int data){
		Node node =new Node(data);
		head.prev=node;
		node.next=head;
		node.prev=tail;
		tail.next=node;
		head=node;
		size++;
	}
	public void insertatidx(int data,int index){
		if(index+1==size){
			insert(data);
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
		head.prev=tail;
		tail.next=head;
		size--;
	}

	public void deleteLast(){
		tail=tail.prev;
		tail.next=head;
		head.prev=tail;
		size--;
	}

	public void delete(int index){
		if(index+1==size){
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
		temp.next.prev=temp2;
		size--;
	}

	public void size(){
		System.out.println("linked List size: "+size);
	}

	public void display(){
		Node temp=head;
		System.out.print(temp.data+"->");
		temp=temp.next;
		while(temp!=head){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("head");
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

	public void displayReverse(){
		Node temp=tail;
		while(temp!=head){
			System.out.print(temp.data+"->");
			temp=temp.prev;
		}
		System.out.print(temp.data+"->");
		System.out.println("tail");
	}
	public static void main(String[] args){
		CLL list=new CLL();
		list.insert(3);
		list.insert(5);
		list.insert(2);
		list.insert(3);
		list.insert(6);
		list.insert(7);
		list.insertatidx(12,2);


		list.deleteFirst();
		list.deleteLast();
		list.delete(2);

		list.size();
		list.display();
		list.getbyIdx(2);
		list.displayReverse();
	}
}
