import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class APlusB7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = a+b;
		}
		for (int i = 0; i < cnt; i++) {
			System.out.println("Case #" + (i+1) + ": " + arr[i]);
		}
	}

}
