import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ1168 {
	private static int[] arr;
	private static int[] segTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int idx = k;
		int size = n;
		arr = new int[n+1];
		segTree = new int[n*4];
		Arrays.fill(arr, 1);
		init(1, n, 1);
		StringBuilder sb = new StringBuilder();
		int removeIdx = search(1, n, 1, idx);
		update(1, n, 1, removeIdx, -1);
		sb.append('<').append(removeIdx);
		size--;
		for (int i=1; i<n; i++) {
			sb.append(", ");
			idx += k-1;
			if (idx > size) {
				idx %= size;
				if (idx == 0)
					idx += size;
			}
			removeIdx = search(1, n, 1, idx);
			update(1, n, 1, removeIdx, -1);
			sb.append(removeIdx);
			size--;
		}
		sb.append('>');
		System.out.println(sb);
	}
	
	public static int init(int start, int end, int node) {
		if (start == end)
			return segTree[node] = arr[start];
		int mid = (start+end)/2;
		return segTree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	public static int search(int start, int end, int node, int sum) {
		if (start == end)
			return end;
		int mid = (start+end)/2;
		if (sum > segTree[node*2])
			return search(mid+1, end, node*2+1, sum-segTree[node*2]);
		else
			return search(start, mid, node*2, sum);
	}
	
	public static void update(int start, int end, int node, int index, int dif) {
		if ((index < start) || (end < index))
			return;
		segTree[node] += dif;
		if (start == end)
			return;
		int mid = (start+end)/2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}

}
