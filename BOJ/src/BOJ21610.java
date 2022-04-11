import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ21610 {
	static int n;
	static int m;
	static int[] d;
	static int[] s;
	static int[] dr = new int[] {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = new int[] {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] A;
	static Set<Integer> clouds;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		d = new int[m];
		s = new int[m];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		clouds = new HashSet<>();
		clouds.add((n-1)*n + 0);
		clouds.add((n-1)*n + 1);
		clouds.add((n-2)*n + 0);
		clouds.add((n-2)*n + 1);
		moveCloud();
		int sum = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				sum += A[i][j];
			}
		}
		System.out.println(sum);
	}
	
	static void moveCloud() {
		int r, c, row, col, num;
		Set<Integer> disappear;
		for (int i=0; i<m; i++) {
			disappear = new HashSet<>();
			for (int cloud : clouds) {
				r = cloud / n;
				c = cloud % n;
				r = (r + (dr[d[i]]+n) * s[i]) % n;
				c = (c + (dc[d[i]]+n) * s[i]) % n;
				A[r][c]++;
				disappear.add(r*n + c);
			}
			clouds.clear();
			for (int cloud : disappear) {
				num = 0;
				r = cloud / n;
				c = cloud % n;
				for (int j=2; j<=8; j+=2) {
					row = r + dr[j];
					col = c + dc[j];
					if (row<0 || row>=n || col<0 || col>=n)
						continue;
					if (A[row][col] > 0)
						num++;
				}
				A[r][c] += num;
			}
			for (r=0; r<n; r++) {
				for (c=0; c<n; c++) {
					if (A[r][c] >= 2 && !disappear.contains(r*n + c)) {
						clouds.add(r*n + c);
						A[r][c] -= 2;
					}
				}
			}
		}
	}

}
