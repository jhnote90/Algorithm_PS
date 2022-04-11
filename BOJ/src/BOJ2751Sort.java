import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2751Sort {
	static int[] A;
	static int[] M;
	static int n;
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		M = new int[n];
		for (int i=0; i<n; i++)
			A[i] = Integer.parseInt(br.readLine());
		mergeSort(0, n-1);
		for (int i=0; i<n; i++)
			sb.append(A[i]).append("\n");
		System.out.print(sb);
	}
	
	public static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = (low+high)/2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			merge(low, mid, high);
		}
	}

	public static void merge(int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int k = low;
		while ((i <= mid) && (j <= high)) {
			if (A[i] < A[j]) {
				M[k] = A[i];
				i++;
			}
			else {
				M[k] = A[j];
				j++;
			}
			k++;
		}
		if (i > mid) {
			while (j <= high) 
				M[k++] = A[j++];
		}
		else {
			while (i <= mid)
				M[k++] = A[i++];
		}
		for (int l=low; l<=high; l++)
			A[l] = M[l];
	}
	
	public static void quickSort(int low, int high) {
		int pivotPoint;
		if (low < high) {
			pivotPoint = partition(low, high);
			quickSort(low, pivotPoint-1);
			quickSort(pivotPoint+1, high);
		}
	}
	
	public static int partition(int low, int high) {
		int pivotItem = A[low];
		int pivotPoint = low;
		int temp;
		for (int i=low+1; i<=high; i++) {
			if (A[i] < pivotItem) {
				pivotPoint++;
				temp = A[i];
				A[i] = A[pivotPoint];
				A[pivotPoint] = temp;
			}
		}
		A[low] = A[pivotPoint];
		A[pivotPoint] = pivotItem;
		return pivotPoint;
	}
	
}
