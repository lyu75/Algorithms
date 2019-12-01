package QuickSort;

public class QuickSortMedianPivot {
	static int findMed(int a, int b, int c) {
		int arr[] = {a, b, c};
		// sort (min-heap)
		if(arr[0]<arr[1]) {
			int tmp = arr[0];
			arr[0] = arr[1];
			arr[1] = tmp;
		}
		if(arr[2]>arr[0]) {
			int tmp = arr[2];
			arr[2] = arr[0];
			arr[0] = tmp;
		}
		if(arr[1]<arr[2]) {
			int tmp = arr[1];
			arr[1] = arr[2];
			arr[2] = tmp;
		}		
		if(arr[1] == a) {return 0;}
		if(arr[1] == b) {return 1;}
		if(arr[1] == c) {return 2;}
		return -1;
	}
	
	int partition(int arr[], int low, int high) {
		// find pivot
		int l = arr[low];
		int m = arr[(low+high)/2];
		int h = arr[high-1];
		int pivot = findMed(l, m, h);
		
		if(pivot == 0) {
			// switch pivot with the last element
			int tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		}
		if(pivot == 1) {
			// switch pivot with the last element
			int med = (low+high)/2;
			int tmp = arr[med];
			arr[med] = arr[high];
			arr[high] = tmp;
		}
		
		pivot = arr[high];
		
		// i is the index of the smaller element
		// in the end, pivot should be the (i+1)th greatest element in arr[low, high]
		int i = low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				// swap arr[i] and arr[j]
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		// swap arr[i+1] and arr[high] to place pivot at the correct position
		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		
		return i+1;
	}
	
	void quickSort(int arr[], int low, int high) {
		if(low<high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}
	
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	// test quickSort
	public static void main(String args[]) {
		int arr[] = {1, 3, 9, 5, 4, 0, 2};
		int n = arr.length;
		QuickSortMedianPivot qk = new QuickSortMedianPivot();
		qk.quickSort(arr, 0, n-1);
		printArr(arr);
	}	

}
