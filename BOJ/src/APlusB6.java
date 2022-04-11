import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class APlusB6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			String testCase = br.readLine();
			String[] integers = testCase.split(",");
			int a = Integer.parseInt(integers[0]);
			int b = Integer.parseInt(integers[1]);
			arr[i] = a+b;
		}
		for (int i = 0; i < cnt; i++) {
			System.out.println(arr[i]);
		}
	}

}