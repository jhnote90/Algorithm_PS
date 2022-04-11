import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11662 {
	static int[] A, B, C, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = new int[2];
		B = new int[2];
		C = new int[2];
		D = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		A[0] = Integer.parseInt(st.nextToken());
		A[1] = Integer.parseInt(st.nextToken());
		B[0] = Integer.parseInt(st.nextToken());
		B[1] = Integer.parseInt(st.nextToken());
		C[0] = Integer.parseInt(st.nextToken());
		C[1] = Integer.parseInt(st.nextToken());
		D[0] = Integer.parseInt(st.nextToken());
		D[1] = Integer.parseInt(st.nextToken());
		System.out.println(ternarySearch());
	}
	
	public static double ternarySearch() {
		double dx1 = (B[0] - A[0]) / 10000000000.0;
		double dy1 = (B[1] - A[1]) / 10000000000.0;
		double dx2 = (D[0] - C[0]) / 10000000000.0;
		double dy2 = (D[1] - C[1]) / 10000000000.0;
		double pDist, qDist;
		long lo = 0;
		long hi = 10000000000L;
		long p, q;
		while (hi - lo > 3) {
			p = (2*lo + hi) / 3;
			q = (lo + 2*hi) / 3;
			pDist = distance(A[0] + dx1*p, A[1] + dy1*p, C[0] + dx2*p, C[1] + dy2*p);
			qDist = distance(A[0] + dx1*q, A[1] + dy1*q, C[0] + dx2*q, C[1] + dy2*q);
			if (pDist >= qDist)
				lo = p;
			else
				hi = q;
		}
		double min = 100000.0;
		for (long i=lo; i<=hi; i++)
			min = Math.min(min, distance(A[0] + dx1*i, A[1] + dy1*i, C[0] + dx2*i, C[1] + dy2*i));
		return min;
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		double xdiff = Math.pow(x1 - x2, 2);
		double ydiff = Math.pow(y1 - y2, 2);
		return Math.sqrt(xdiff + ydiff);
	}

}
