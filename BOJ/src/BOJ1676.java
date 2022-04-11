import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int two = 0;
		int five = 0;
		int temp;
		for (int i=1; i<=n; i++) {
			temp = i;
			while (temp % 2 == 0) {
				temp /= 2;
				two++;
			}
			while (temp % 5 == 0) {
				temp /= 5;
				five++;
			}
		}
		System.out.println(Math.min(two, five));
	}

}
