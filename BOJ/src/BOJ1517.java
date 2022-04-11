import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1517 {
	static int[] arr;
	static int[] S;
	static int n;
	static long swap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		S = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		swap = 0;
		mergeSort(0, n-1);
		System.out.println(swap);
	}
	
	public static void mergeSort(int start, int end) {
		if (start >= end)
			return;
		int mid = (start+end)/2;
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		merge(start, mid, end);
	}
	
	public static void merge(int start, int mid, int end) {
		int i = start;
		int	k = start;
		int j = mid+1;
		while ((i <= mid) && (j <= end)) {
			if (arr[i] <= arr[j])
				S[k++] = arr[i++];
			else {
				swap += j-k;
				S[k++] = arr[j++];
			}
		}
		if (i > mid) {
			while (j <= end)
				S[k++] = arr[j++];
		}
		else {
			while (i <= mid)
				S[k++] = arr[i++];
		}
		for (int m=start; m<=end; m++)
			arr[m] = S[m];
	}

}
