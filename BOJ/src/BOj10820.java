import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOj10820 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[4];
		String str;
		char c;
		StringBuilder sb = new StringBuilder();
		while ((str=br.readLine()) != null) {
			A[0] = 0; A[1] = 0;
			A[2] = 0; A[3] = 0;
			for (int i=0; i<str.length(); i++) {
				c = str.charAt(i);
				if (c == ' ')
					A[3]++;
				else if (c <= 57)
					A[2]++;
				else if (c <= 90)
					A[1]++;
				else
					A[0]++;
			}
			sb.append(A[0] + " ").append(A[1] + " ").append(A[2] + " ").append(A[3]);
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
