import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1062 {

    static int n;
    static int k;
    static int max;
    static int[] words;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new int[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int word = 0;
            for (int j = 0; j < str.length(); j++) {
                word = word | (1 << (str.charAt(j) - 'a'));
            }
            words[i] = word;
        }
        if (k < 5) {
            System.out.println(0);
            return;
        }
        int num = init();
        max = 0;
        dfs(0, 0, num);
        System.out.println(max);
    }

    private static void dfs(int depth, int s, int num) {
        if (depth == k) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if ((words[i] & num) == words[i]) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }
        for (int i = s; i <= 26 - (k - depth); i++) {
            if (set.contains(i)) {
                continue;
            }
            dfs(depth + 1, i + 1, num + (1 << i));
        }
    }

    private static int init() {
        int num = 0;
        set.add('a' - 'a');
        num += 1 << ('a' - 'a');
        set.add('n' - 'a');
        num += 1 << ('n' - 'a');
        set.add('t' - 'a');
        num += 1 << ('t' - 'a');
        set.add('i' - 'a');
        num += 1 << ('i' - 'a');
        set.add('c' - 'a');
        num += 1 << ('c' - 'a');
        k -= 5;
        return num;
    }
}
