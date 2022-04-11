import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class BOJ1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> editor = new LinkedList<>();
		String str = br.readLine();
		for (int i=0; i<str.length(); i++)
			editor.add(str.charAt(i));
		int n = Integer.parseInt(br.readLine());
//		StringTokenizer st;
		ListIterator<Character> listIterator = editor.listIterator(editor.size());
		for (int i=0; i<n; i++) {
			String command = br.readLine();

            if (command.equals("L")) {
                if (listIterator.hasPrevious()) {
                	listIterator.previous();
                }
            } else if (command.equals("D")) {
                if (listIterator.hasNext()) {
                	listIterator.next();
                }
            } else if (command.equals("B")) {
                if (listIterator.hasPrevious()) {
                	listIterator.previous();
                	listIterator.remove();
                }
            } else {
                Character addChar = command.charAt(2);
                listIterator.add(addChar);
            }
//			st = new StringTokenizer(br.readLine());
//			switch (st.nextToken()) {
//			case "L":
//				if (listIterator.hasPrevious())
//					listIterator.previous();
//				break;
//			case "D":
//				if (listIterator.hasNext())
//					listIterator.next();
//				break;
//			case "B":
//				if (listIterator.hasPrevious()) {
//					listIterator.previous();
//					listIterator.remove();
//				}
//				break;
//			case "P":
//				listIterator.add(st.nextToken().charAt(0));
//				break;
//			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : editor)
			sb.append(c);
		System.out.println(sb);
	}

}
