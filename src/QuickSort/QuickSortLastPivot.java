package QuickSort;

public class QuickSortLastPivot {
	
	int partition(int arr[], int low, int high) {
		// set the pivot to be the last element of the subarray
		int pivot = arr[high];
		int i = low-1;
		for(int j=low; j<high; j++) {
			if(arr[j]<pivot) {
				i++;
				// swap arr[i] and arr[j]
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		// now, the pivot is the (i+1)th greatest element in arr[low..high];
		// swap arr[i+1] and arr[high], to put the pivot at the correction position in arr
		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		
		return i+1;
	}
	
	void quickSort(int arr[], int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			
			// recursively sort left and right half
			// ignoring pi because it is already at the correct index
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
		int arr[] = {1, 3, 9, 5, 4, 0, 10, 2};
		int n = arr.length;
		
		QuickSortLastPivot qk = new QuickSortLastPivot();
		qk.quickSort(arr, 0, n-1);
		printArr(arr);
	}
}
