import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.XMLFormatter;

public class BOJ1197 {
    static int V;
    static int E;
    static int[] parent;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        edges = new ArrayList<>();
        int a, b, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }
        System.out.println(kruskal());
    }

    private static int kruskal() {
        Collections.sort(edges, ((o1, o2) -> o1[2] - o2[2]));
        int weight = 0;
        for (int[] e : edges) {
            if (find(e[0]) != find(e[1])) {
                weight += e[2];
                union(e[0], e[1]);
            }
        }
        return weight;
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

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
