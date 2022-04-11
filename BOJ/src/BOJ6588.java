import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ6588 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 1000000;
		int n;
		boolean caseExist;
		boolean[] isPrime = new boolean[max];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i=2; i*i <= max-1; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<=max-1; j+=i)
					isPrime[j] = false;
			}
		}
		List<Integer> aList = new ArrayList<>();
		for (int i=3; i < max/2; i++) {
			if (isPrime[i])
				aList.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			caseExist = false;
			for (int a : aList) {
				if (isPrime[n-a]) {
					caseExist = true;
					sb.append(n).append(" = ").append(a).append(" + ").append(n-a).append("\n");
					break;
				}
			}
			if (!caseExist)
				sb.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.print(sb);
	}

}
