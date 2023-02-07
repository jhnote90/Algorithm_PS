import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2529 {

    static int k;
    static int[] min;
    static int[] max;
    static char[] A;
    static Set<Integer> set;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        A = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            A[i] = st.nextToken().charAt(0);
        }
        min = new int[k+1];
        max = new int[k+1];
        for (int i = 0; i < k + 1; i++) {
            min[i] = 9;
            max[i] = 0;
        }
        int[] sol = new int[k+1];
        set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        for (int i = 0; i < 10; i++) {
            sol[0] = i;
            set.remove(i);
            dfs(1, sol);
            set.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k + 1; i++) {
            sb.append(max[i]);
        }
        sb.append('\n');
        for (int i = 0; i < k + 1; i++) {
            sb.append(min[i]);
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int[] sol) {
        if (depth == k + 1) {
            for (int i = 0; i < k + 1; i++) {
                if (sol[i] < min[i]) {
                    for (int j = i; j < k + 1; j++) {
                        min[j] = sol[j];
                    }
                    break;
                } else if (sol[i] == min[i]) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = 0; i < k + 1; i++) {
                if (sol[i] > max[i]) {
                    for (int j = i; j < k + 1; j++) {
                        max[j] = sol[j];
                    }
                    break;
                } else if (sol[i] == max[i]) {
                    continue;
                } else {
                    break;
                }
            }
            return;
        }
        int n;
        if (A[depth - 1] == '<') {
            n = sol[depth - 1] + 1;
            for (int i = n; i < 10; i++) {
                if (!set.contains(i)) {
                    continue;
                }
                sol[depth] = i;
                set.remove(i);
                dfs(depth + 1, sol);
                set.add(i);
            }

        } else if (A[depth - 1] == '>') {
            n = sol[depth - 1];
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    continue;
                }
                sol[depth] = i;
                set.remove(i);
                dfs(depth + 1, sol);
                set.add(i);
            }
        }

    }
}
