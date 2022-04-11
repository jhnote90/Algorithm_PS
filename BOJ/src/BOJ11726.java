import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n+1];
		for (int i=0; i<=n; i++) {
			if (i==0 || i==1)
				T[i] = 1;
			else
				T[i] = T[i-1] + T[i-2];
			if (T[i]>=10007)
				T[i] = T[i]%10007;
		}
		System.out.println(T[n]);
	}
	

}
