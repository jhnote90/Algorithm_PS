import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {

	public static void main(String[] args) throws IOException {
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String str = br.readLine();
		for (int i = 0; i < num; i++) {
			sum += Character.getNumericValue(str.charAt(i)); 
		}
		System.out.println(sum);

	}

}
