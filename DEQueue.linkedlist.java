import java.util.Scanner;
public class DEQueue{
	Node Front;
	Node Rear;
	int size;
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
	}

	public void insertFront(int data){
		Node node =new Node(data);
		if(Front==null){
			Front=node;
			Rear=node;
			node.next=null;
			size++;
			return;
		}
		node.next=Front;
		Front=node;
		size++;

	}

	public void insertBack(int data){
		Node node=new Node(data);
		if(Rear==null){
			Front=node;
			Rear=node;
			node.next=null;
			size++;
			return;
		}
		Rear.next=node;
		Rear=node;
		size++;
	}

	public void eraseFront(){
		if(Front==null){
			System.out.println("DEQueue is empty!");
			return;
		}
		Front=Front.next;
		size--;
	}

	public void eraseRear(){
		if(Rear==null){
			System.out.println("DEQueue is empty!");
			return;
		}
		Node temp=Front;
		while(temp.next!=Rear){
			temp=temp.next;
		}
		Rear=temp;
		Rear.next=null;
		size--;

	}

	public int front(){
		if(Front==null){
			return -1;
		}
		return Front.data;
	}

	public int rear(){
		if(Rear==null){
			return -1;
		}
		return Rear.data;
	}

	public int size(){
		if(Front==null){
			return -1;
		}
		return size;
	}

	public void display(){
		Node temp=Front;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		DEQueue deq=new DEQueue();
		int ch;
		do{
			System.out.println("\n\n====MENU====\n\n1.InsertFront\n2.InsertBack\n3.EraseFront\n4.EraseBack\n5.Front\n6.Back\n7.Size\n8.Display\n9.Exit");
			System.out.print("\nSelect an option by entering corresponding number: ");
			ch=sc.nextInt();
			switch(ch){
				case 1:
					System.out.print("Enter the Value: ");
					deq.insertFront(sc.nextInt());
					System.out.println("Element inserted at Front");
					break;
				case 2:
					System.out.print("Enter the Value: ");
					deq.insertBack(sc.nextInt());
					System.out.println("Element inserted at Back");
					break;
				case 3:
					deq.eraseFront();
					System.out.println("Element removed from Front");
					break;
				case 4:
					deq.eraseRear();
					System.out.println("Element removed from Back");
					break;
				case 5:
					System.out.println("Data: "+deq.front());
					break;
				case 6:
					System.out.println("Data: "+deq.rear());
					break;
				case 7:
					System.out.println("Size of DEQueue is: "+deq.size());
					break;
				case 8:
					deq.display();
					break;
				case 9:
					return;
				default:
					System.out.println("Invalid Option!\n");
					break;
			}
		}while(true);
	}
}
