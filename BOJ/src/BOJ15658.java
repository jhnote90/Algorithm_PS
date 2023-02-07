import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15658 {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] A;
    static int[] ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        ops = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n - 1) {
            if (sum < min) {
                min = sum;
            }
            if (sum > max) {
                max = sum;
            }
            return;
        }
        if (ops[0] > 0) {
            ops[0]--;
            dfs(depth + 1, sum + A[depth + 1]);
            ops[0]++;
        }
        if (ops[1] > 0) {
            ops[1]--;
            dfs(depth + 1, sum - A[depth + 1]);
            ops[1]++;
        }
        if (ops[2] > 0) {
            ops[2]--;
            dfs(depth + 1, sum * A[depth + 1]);
            ops[2]++;
        }
        if (ops[3] > 0) {
            ops[3]--;
            if (sum < 0) {
                int absSum = (sum * -1) / A[depth + 1];
                dfs(depth + 1, absSum * -1);
            } else {
                dfs(depth + 1, sum / A[depth + 1]);
            }
            ops[3]++;
        }
    }


}
