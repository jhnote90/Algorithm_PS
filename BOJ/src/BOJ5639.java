import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ5639 {

    static int n;
    static int idx;
    static int[] parents;
    static int[][] nodes;
    static List<Integer> preOrder;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preOrder = new ArrayList<>();
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            preOrder.add(Integer.parseInt(s));
        }
        n = preOrder.size();
        parents = new int[1000000];
        nodes = new int[1000000][2];
        idx = 0;
        int root = preOrder.get(idx++);
        getTree(root);
        sb = new StringBuilder();
        postOrder(root);
        System.out.print(sb);
    }

    private static void postOrder(int root) {
        if (nodes[root][0] != 0) {
            postOrder(nodes[root][0]);
        }
        if (nodes[root][1] != 0) {
            postOrder(nodes[root][1]);
        }
        sb.append(root).append("\n");
    }

    private static void getTree(int root) {
        if (idx >= n) {
            return;
        }
        int num = preOrder.get(idx);
        if (num < root) {
            nodes[root][0] = num;
            parents[num] = root;
            idx++;
            getTree(num);
        }
        if (idx >= n) {
            return;
        }
        num = preOrder.get(idx);
        if (check(root, num)) {
            nodes[root][1] = num;
            parents[num] = root;
            idx++;
            getTree(num);
        }
    }

    private static boolean check(int root, int num) {
        while (parents[root] != 0) {
            root = parents[root];
            if (nodes[root][1] == 0) {
                if (root > num) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
