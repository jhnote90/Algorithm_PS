import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {

    static int n;
    static int[][] sol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol = new int[n][n];
        myPow(A, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(sol[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void myPow(int[][] A, long b) {
        if (b == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sol[i][j] = A[i][j] % 1000;
                }
            }
            return;
        }
        int[][] arr = new int[n][n];
        myPow(A, b/2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int k = 0; k < n; k++) {
                    num += sol[i][k] * sol[k][j];
                }
                arr[i][j] = num % 1000;
            }
        }
        if (b % 2 == 0) {
            sol = arr;
        } else {
            sol = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = 0;
                    for (int k = 0; k < n; k++) {
                        num += arr[i][k] * A[k][j];
                    }
                    sol[i][j] = num % 1000;
                }
            }
        }
    }
}
