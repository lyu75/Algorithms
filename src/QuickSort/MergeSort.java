package QuickSort;

public class MergeSort{
	
	public void merge(int arr[], int l, int m, int r) {
		// create temporary arrays
		int LL = m - l + 1;
		int RL = r - m;
		int L[] = new int[LL];
		int R[] = new int[RL];
		for(int i=0; i<LL; i++) {
			L[i] = arr[l+i];
		}
		for(int i=0;i<RL;i++) {
			R[i] = arr[m+1+i];
		}
		// initialize index pointer for both temp arrays
		int i=0, j=0, k=l;
		// merge
		while( (i<LL)&&(j<RL) ) {
			if(L[i]<R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		//	copy remaining elements of R and L into arr 
		while(i<LL) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(k<RL) {
			arr[k] = R[j];
			k++;
			j++;
		}
	}
	
	public void mergeSort(int arr[], int l, int r){
		if(l<r) {
			int m = (l+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	// test mergeSort
	public static void main(String args[]) {
		int arr[] = {1, 3, 9, 5, 4, 0, 2};
		int n = arr.length;
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, 0, n-1);
		printArr(arr);
	}	

}
