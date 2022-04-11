import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int P = 4000000;
		long[] sub = new long[8000001];
		sub[arr[0]+P]++;
		int min = arr[0] + P;
		int max = arr[0] + P;
		for (int i=1; i<n; i++) {
			if (arr[i] >= 0) {
				for (int j=max; j>=min; j--)
					sub[j+arr[i]] += sub[j];
				max += arr[i];
			}
			else {
				for (int j=min; j<=max; j++)
					sub[j+arr[i]] += sub[j];
				min += arr[i];
			}
			sub[arr[i]+P]++;
			max = Math.max(max, arr[i]+P);
			min = Math.min(min, arr[i]+P);
		}
		System.out.println(sub[s+P]);
	}

}
