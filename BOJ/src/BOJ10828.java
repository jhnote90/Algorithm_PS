import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10828 {
	private static int[] stack;
	private static int top = -1;
	
	private static void push(int x) {
		stack[++top] = x;
	}
	
	private static int pop()  {
		if (top == -1)
			return -1;
		else {
			int ret = stack[top];
			stack[top--] = 0;
			return ret;
		}
	}
	
	private static int size() {
		return top+1;
	}
	
	private static int empty() {
		if (top == -1)
			return 1;
		else 
			return 0;
	}
	
	private static int top() {
		if (top == -1)
			return -1;
		else
			return stack[top];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stack = new int[n];
//		Deque<Integer> stack = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "top":
				sb.append(top()).append("\n");
				break;
			}
		}
//		for (int i=0; i<n; i++) {
//			st = new StringTokenizer(br.readLine());
//			cmd = st.nextToken();
//			if (cmd.equals("push"))
//				stack.addFirst(Integer.parseInt(st.nextToken()));
//			else if (cmd.equals("pop")) {
//				if (stack.isEmpty())
//					sb.append(-1).append("\n");
//				else
//					sb.append(stack.removeFirst()).append("\n");
//			}
//			else if (cmd.equals("size"))
//				sb.append(stack.size()).append("\n");
//			else if (cmd.equals("empty")) {
//				if (stack.isEmpty())
//					sb.append(1).append("\n");
//				else
//					sb.append(0).append("\n");
//			}
//			else {
//				if (stack.isEmpty())
//					sb.append(-1).append("\n");
//				else
//					sb.append(stack.getFirst()).append("\n");
//			}
//		}
		System.out.println(sb);
	}

}
