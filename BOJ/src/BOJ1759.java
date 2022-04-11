import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	static char[] arr;
	static int L, C;
	static StringBuilder sb;
	static ArrayList<Character> vowels;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		vowels = new ArrayList<>();
		vowels.add('a'); vowels.add('e'); vowels.add('i');
		vowels.add('o'); vowels.add('u');
		char[] sol = new char[L+1];
		for (int i=0; i<=C-L; i++) {
			sol[1] = arr[i];
			dfs(i, 1, sol);
		}
		System.out.print(sb);
	}
	
	public static void dfs(int n, int depth, char[] sol) {
		if (depth == L) {
			int v = 0;
			for (int i=1; i<=L; i++) {
				for (char c : vowels) {
					if (sol[i] == c) {
						v++;
						break;
					}
				}
			}
			if ((v >= 1) && (L-v >= 2)) {
				for (int i=1; i<=L; i++)
					sb.append(sol[i]);
				sb.append("\n");
			}
			return;
		}
		for (int i=n+1; i<=C-L+depth; i++) {
			sol[depth+1] = arr[i];
			dfs(i, depth+1, sol);
		}
	}

}
