import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int temp;
		for (int i=1; i<=N; i++) {
			if (i==1) 
				arr[i] = 0;
			else {
				temp = i;
				if (i%3 == 0) 
					temp = arr[i/3];
				if (i%2 == 0)
					temp = Math.min(temp, arr[i/2]);
				temp = Math.min(temp, arr[i-1]);
				arr[i] = temp + 1;
			}
		}
		System.out.println(arr[N]);
	}

}