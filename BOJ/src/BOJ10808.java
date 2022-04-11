import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[26];
		String S = br.readLine();
		for (int i=0; i<S.length(); i++) {
			A[S.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<26; i++)
			sb.append(A[i]).append(" ");
		System.out.println(sb);
	}

}
