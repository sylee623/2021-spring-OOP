package lab6;

public class Sort {
	public static void main(String[] args) {
	       int[] arr = {7, 4, 5, 1, 3};
	       printArr(arr); 
	       bubbleSort(arr, arr.length); 
	       printArr(arr);
	}
	public static void bubbleSort(int arr[], int n) { 
		int b;
		for(int i = 1 ; i < n ; i ++) {
			for(int j = 0 ; j < n -i  ; j ++) {
				if(arr[j]>arr[j+1]) {
					b = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = b;
				}
			}
		}
	}
	public static void printArr(int arr[]) { 
		for(int i = 0 ; i < arr.length ; i ++) {
			System.out.printf(arr[i] + " ");
		}
		System.out.println();
	}
	
}

