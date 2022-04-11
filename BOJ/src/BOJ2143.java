import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2143 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			B[i] = Integer.parseInt(st.nextToken());
		int sum;
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		for (int i=0; i<n; i++) {
			sum = 0;
			for (int j=i; j<n; j++) {
				sum += A[j];
				aList.add(sum);
			}
		}
		for (int i=0; i<m; i++) {
			sum = 0;
			for (int j=i; j<m; j++) {
				sum += B[j];
				bList.add(sum);
			}
		}
		Collections.sort(aList);
		Collections.sort(bList);
		long cnt = 0L;
		int a = 0;
		int b = bList.size() - 1;
		int getA, getB;
		while ((a < aList.size()) && (b >= 0)) {
			getA = aList.get(a);
			getB = bList.get(b);
			if (getA + getB < t)
				a++;
			else if (getA + getB > t)
				b--;
			else {
				long cntA = 0L;
				long cntB = 0L;
				while (a < aList.size()) {
					if (getA == aList.get(a)) {
						cntA++;
						a++;
					}
					else
						break;
				}
				while (b >= 0) {
					if (getB == bList.get(b)) {
						cntB++;
						b--;
					}
					else
						break;
				}
				cnt += cntA * cntB;
			}
		}
		System.out.println(cnt);
	}

}
