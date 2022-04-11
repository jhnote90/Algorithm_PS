import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int B, C;
		long result = n;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for (int i=0; i<n; i++) {
			if (A[i]-B > 0) {
				result += (A[i]-B)/C;
				if ((A[i]-B) % C > 0)
					result++;
			}
		}
		System.out.println(result);
	}

}
