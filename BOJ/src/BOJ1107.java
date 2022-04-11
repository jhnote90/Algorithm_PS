import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = Math.abs(n - 100);
		boolean[] brokenButton = new boolean[10]; 
		int m = Integer.parseInt(br.readLine());
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<m; i++) {
				brokenButton[Integer.parseInt(st.nextToken())] = true;
			}
		}
		if (m == 10) {
			System.out.println(result);
			return;
		}
		int up = n;
		int down = n-1;
		int num = 0;
		String channel;
		boolean broken;
		while (up < 1000000) {
			broken = false;
			channel = up + "";
			num = channel.length();
			for (int i=0; i<num; i++) {
				if (brokenButton[channel.charAt(i) - '0']) {
					broken = true;
					break;
				}
			}
			if (broken)
				up++;
			else
				break;
		}
		if (up < 1000000) {
			num += up - n;
			result = Math.min(result, num);
		}
		while (down >= 0) {
			broken = false;
			channel = down + "";
			num = channel.length();
			for (int i=0; i<num; i++) {
				if (brokenButton[channel.charAt(i) - '0']) {
					broken = true;
					break;
				}
			}
			if (broken)
				down--;
			else
				break;
		}
		if (down >= 0) {
			num += n - down;
			result = Math.min(result, num);
		}
		System.out.println(result);
	}

}
