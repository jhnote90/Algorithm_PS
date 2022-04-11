import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] subStr = new String[S.length()];
		for (int i=0; i<S.length(); i++) 
			subStr[i] = S.substring(i);
		Arrays.sort(subStr);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<subStr.length; i++)
			sb.append(subStr[i]).append("\n");
		System.out.println(sb);
	}

}
