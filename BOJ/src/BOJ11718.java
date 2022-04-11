import java.io.BufferedReader;
import java.io.IOException;


public class BOJ11718 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		for (int i = 0; i < 100; i++) {
			String str;
			if( (str = br.readLine()) == null)
				break;
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}

}
