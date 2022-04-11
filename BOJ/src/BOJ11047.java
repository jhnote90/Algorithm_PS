import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] A = new int[n];
		for (int i=n-1; i>=0; i--)
			A[i] = Integer.parseInt(br.readLine());
		int s = 0;
		int i = 0;
		while (i < n) {
			if (A[i] <= k) {
				k -= A[i];
				s++;
			}
			else
				i++;
		}
		System.out.println(s);
	}

}
