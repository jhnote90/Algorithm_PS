import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
	static int k;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		k = 0;
		hanoi(1, 3, n);
		System.out.println(k);
		System.out.println(sb);
	}

	public static void hanoi(int start, int end, int size) {
		if (size == 1) {
			sb.append(start).append(' ').append(end).append("\n");
			k++;
			return;
		}
		int mid = 6 - start - end;
		hanoi(start, mid, size-1);
		hanoi(start, end, 1);
		hanoi(mid, end, size-1);
	}
}
