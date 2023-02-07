import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2263 {
    static int n;
    static int[] inOrderIdx;
    static int[][] nodes;
    static Deque<Integer> postOrder;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inOrderIdx = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            inOrderIdx[Integer.parseInt(st.nextToken())] = i;
        }
        postOrder = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder.offerFirst(Integer.parseInt(st.nextToken()));
        }
        nodes = new int[n + 1][2];
        int root = getTree(1, n);
        sb = new StringBuilder();
        preOrder(root);
        System.out.println(sb);
    }

    private static void preOrder(int root) {
        sb.append(root).append(' ');
        if (nodes[root][0] != 0) {
            preOrder(nodes[root][0]);
        }
        if (nodes[root][1] != 0) {
            preOrder(nodes[root][1]);
        }
    }

    private static int getTree(int s, int e) {
        int root = postOrder.pollFirst();
        int idx = inOrderIdx[root];
        if (idx < e) {
            nodes[root][1] = getTree(idx + 1, e);
        }
        if (idx > s) {
            nodes[root][0] = getTree(s, idx - 1);
        }
        return root;
    }
}
