import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        int a, b, op;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else {
                if (isSameSet(a, b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean isSameSet(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        } else {
            return false;
        }
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA < findB) {
            parent[findB] = findA;
        } else {
            parent[findA] = findB;
        }
    }


}
