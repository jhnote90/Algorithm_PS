import java.io.BufferedReader;
import java.io.IOException;


public class BOJ8393 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n*(n+1)/2);

	}

}
