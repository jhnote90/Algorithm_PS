import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class APlusB4 {

	public static void main(String[] args) throws IOException {
		List<Integer> sumList = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String testCase = " ";
		while ((testCase = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(testCase);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sumList.add(a+b);
		}
		for (Integer integer : sumList) {
			System.out.println(integer);
		}
	}

}
