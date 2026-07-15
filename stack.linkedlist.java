public class stack{
	Node top;
	Node head;
	int size;

	public stack(){
		this.size=0;
	}
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
	}
	public void push(int data){
		Node node=new Node(data);
		node.next=top;
		top=node;
		size++;

	}
	public void pop(){
		if(top==null){
			System.out.println("stack is empty");
			return;
		}
		top=top.next;
		size--;
	}
	public void display(){
		Node temp=top;
		while(temp!=null){
			System.out.print(" "+temp.data);
			temp=temp.next;
		}

	}
	public static void main(String[] args){
		stack st=new stack();
		st.pop();
		st.push(3);
		st.push(5);
		st.pop();
		st.pop();

		st.display();
	}
}
