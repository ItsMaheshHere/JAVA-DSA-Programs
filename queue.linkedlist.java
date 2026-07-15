public class queue{
	Node Front;
	Node Rear;
	Node temp;
	int size;
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
	}
	public void enque(int data){
		Node node=new Node(data);
		if(Front==null){
			Front=node;
			node.next=null;
			Rear=node;
			temp=node;
			size++;
			return;
		}
		temp.next=node;
		temp=node;
		Rear=node;
		size++;

	}
	public void dequeue(){
		if(Front==null){
			System.out.println("Nothing to dequeue");
			return;
		}
		Front=Front.next;
		size--;

	}
	public void display(){
		Node display=Front;
		while(display!=null){
			System.out.print(display.data+"->");
			display=display.next;
		}
		System.out.println("null");
	}
	public int front(){
		if(Front==null){
			return -1;
		}
		return Front.data;
	}
	public int size(){
		return size;
	}
	public boolean isempty(){
		return Front==null;
	}
	public static void main(String[] args){
		queue queue=new queue();
		System.out.println("Number of elements in the queue is:"+queue.size());
		System.out.println(queue.isempty());
		int result=queue.front();
		if(result==-1){
			System.out.println("Queue is empty");
		}else{
			System.out.print("First element of queue is: "+result);
		}

		queue.enque(5);
		// queue.dequeue();
		queue.enque(2);
		queue.dequeue();
		queue.enque(4);
		queue.display();
		System.out.println("Number of elements in the queue is:"+queue.size());
		System.out.println(queue.isempty());
		result=queue.front();
		if(result==-1){
			System.out.println("Queue is empty");
		}else{
			System.out.print("First element of queue is: "+result);
		}
	}
}
