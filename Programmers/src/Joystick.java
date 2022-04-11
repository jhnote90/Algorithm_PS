import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Joystick {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		int len = name.length();
		char[] arr = new char[len+1];
		boolean[] complete = new boolean[len+1];
		for (int i=0; i<len; i++) {
			arr[i+1] = name.charAt(i);
			if (arr[i+1] == 'A')
				complete[i+1] = true;
		}
		boolean finished;
		int cur = 1;
		int cnt = 0;
		int front, back;
		while (true) {
			cnt += Math.min(arr[cur]-'A', ('Z' - arr[cur]) + 1);
			complete[cur] = true;
			finished = true;
			for (int i=1; i<=len/2; i++) {
				front = (cur+i) % len;
				if (front == 0)
					front = len;
				back = (cur-i+len) % len;
				if (back == 0)
					back = len;
				if (!complete[front]) {
					cnt += i;
					cur = front;
					finished = false;
					break;
				}
				if (!complete[back]) {
					cnt += i;
					cur = back;
					finished = false;
					break;
				}
			}
			if (finished)
				break;
		}
		System.out.println(cnt);

	}

}
