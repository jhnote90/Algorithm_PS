import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {
	static StringBuilder sb;
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[] node = new Node[n];
		for (int i=0; i<n; i++)
			node[i] = new Node((char)('A'+i));
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char lData = st.nextToken().charAt(0);
			char rData = st.nextToken().charAt(0);
			if (lData != '.')
				node[data - 'A'].left = node[lData - 'A'];
			if (rData != '.')
				node[data - 'A'].right = node[rData - 'A'];
		}
		sb = new StringBuilder();
		preOrder(node[0]);
		sb.append("\n");
		inOrder(node[0]);
		sb.append("\n");
		postOrder(node[0]);
		System.out.println(sb);
	}
	
	public static void preOrder(Node root) {
		sb.append(root.data);
		if (root.left != null)
			preOrder(root.left);
		if (root.right != null)
			preOrder(root.right);
		return;
	}
	
	public static void inOrder(Node root) {
		if (root.left != null)
			inOrder(root.left);
		sb.append(root.data);
		if (root.right != null)
			inOrder(root.right);
		return;
	}
	
	public static void postOrder(Node root) {
		if (root.left != null)
			postOrder(root.left);
		if (root.right != null)
			postOrder(root.right);
		sb.append(root.data);
		return;
	}

}
