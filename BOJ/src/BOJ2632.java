import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2632 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pizzaSize = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] A = new int[m];
		int[] B = new int[n];
		for (int i=0; i<m; i++)
			A[i] = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++)
			B[i] = Integer.parseInt(br.readLine());
		List<Integer> sumA = new ArrayList<>();
		List<Integer> sumB = new ArrayList<>();
		long cnt = 0L;
		int sum = 0;
		for (int i=0; i<m; i++) {
			sum += A[i];
			if (sum < pizzaSize)
				sumA.add(sum);
			else {
				if (sum == pizzaSize)
					cnt++;
				break;
			}
		}
		for (int i=1; i<m; i++) {
			sum = 0;
			for (int j=i; j<m; j++) {
				sum += A[j];
				if (sum < pizzaSize)
					sumA.add(sum);
				else {
					if (sum == pizzaSize)
						cnt++;
					break;
				}
			}
			if (sum < pizzaSize) {
				for (int j=0; j<i-1; j++) {
					sum += A[j];
					if (sum < pizzaSize)
						sumA.add(sum);
					else {
						if (sum == pizzaSize)
							cnt++;
						break;
					}
				}
			}
		}
		sum = 0;
		for (int i=0; i<n; i++) {
			sum += B[i];
			if (sum < pizzaSize)
				sumB.add(sum);
			else {
				if (sum == pizzaSize)
					cnt++;
				break;
			}
		}
		for (int i=1; i<n; i++) {
			sum = 0;
			for (int j=i; j<n; j++) {
				sum += B[j];
				if (sum < pizzaSize)
					sumB.add(sum);
				else {
					if (sum == pizzaSize)
						cnt++;
					break;
				}
			}
			if (sum < pizzaSize) {
				for (int j=0; j<i-1; j++) {
					sum += B[j];
					if (sum < pizzaSize)
						sumB.add(sum);
					else {
						if (sum == pizzaSize)
							cnt++;
						break;
					}
				}
			}
		}
		Collections.sort(sumA);
		Collections.sort(sumB);
		int a = 0;
		int b = sumB.size() - 1;
		while ((a < sumA.size()) && (b >= 0)) {
			sum = sumA.get(a) + sumB.get(b);
			if (sum < pizzaSize)
				a++;
			else if (sum > pizzaSize)
				b--;
			else {
				int getA = sumA.get(a);
				int getB = sumB.get(b);
				long cntA = 0L;
				long cntB = 0L;
				while (a < sumA.size()) {
					if (getA == sumA.get(a)) {
						cntA++;
						a++;
					}
					else
						break;
				}
				while (b >= 0) {
					if (getB == sumB.get(b)) {
						cntB++;
						b--;
					}
					else break;
				}
				cnt += cntA * cntB;
			}
		}
		System.out.println(cnt);
	}

}
