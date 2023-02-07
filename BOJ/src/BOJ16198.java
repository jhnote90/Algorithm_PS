import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16198 {

    static int n;
    static int max;
    static List<Integer> W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            W.add(Integer.parseInt(st.nextToken()));
        }
        max = 0;
        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int depth, int sum) {
        if (n - depth == 2) {
            max = Math.max(max, sum);
            return;
        }
        int size = W.size();
        for (int i = 1; i < size - 1; i++) {
            Integer element = W.get(i);
            int energy = W.get(i - 1) * W.get(i + 1);
            W.remove(i);
            dfs(depth + 1, sum + energy);
            W.add(i, element);
        }

    }
}
