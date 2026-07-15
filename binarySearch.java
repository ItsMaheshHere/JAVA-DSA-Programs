import java.util.Scanner;
import java.util.Arrays;

public class binarySearch{

	public static int binarySearch(int a[],int st,int end,int target){

		int mid=(st+end)/2;
		if(st<=end){
			if(a[mid]==target){
				return mid;
			}

			if(a[mid]>=target){
				end=mid-1;
				return binarySearch(a,st,end,target);
			}
			st=mid+1;
			return binarySearch(a,st,end,target);
		}
		return -1;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n;

		System.out.println("Enter the number of elements:");
		n=sc.nextInt();

		int[] a=new int[n];
		System.out.println("Enter elements: ");

		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}

		bubbleSort c=new bubbleSort();
		c.bubbleSort(a);
		System.out.println("Enter target element to search:");
		int target=sc.nextInt();
		int end=n-1;
		int st=0;

		System.out.println(Arrays.toString(a));
		// while(st<=end){
		// 	int mid=(st+end)/2;
		// 	if(target>a[mid]){
		// 		st=mid+1;
		// 	}else if(target<a[mid]){
		// 		end=mid-1;
		// 	}else{
		// 		System.out.println("Element Found At Index: "+mid);
		// 		break;
		// 	}
		// }
		int b=binarySearch(a,st,end,target);
		if(b>=0){
			System.out.println("Element Found At Index: "+b);
		}else{
			System.out.println("Element not found!");
		}
	}
}
