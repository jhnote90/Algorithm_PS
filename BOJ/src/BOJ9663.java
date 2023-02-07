import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    static int n;
    static int cnt;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        cnt = 0;
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i=0; i<n; i++) {
            if (check(depth, i)) {
                p[depth] = i;
                dfs(depth+1);
            }
        }
    }

    public static boolean check(int r, int c) {
        for (int i=0; i<r; i++) {
            if (p[i] == c)
                return false;
            if (Math.abs(i - r) == Math.abs(p[i] - c))
                return false;
        }
        return true;
    }

}
