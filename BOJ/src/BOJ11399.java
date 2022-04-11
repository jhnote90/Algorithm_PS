import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] P = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			P[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(P);
		int minTime = 0;
		for (int i=0; i<n; i++)
			minTime += P[i] * (n-i);
		System.out.println(minTime);
	}

}
