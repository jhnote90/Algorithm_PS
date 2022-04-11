
public class Carpet {

	public static void main(String[] args) {
		int brown = 8;
		int yellow = 1;
		int width = 0;
		int height = 0;
		for (int i=1; i*i<=yellow; i++) {
			if (yellow % i == 0) {
				height = i + 2;
				width = (yellow / i) + 2;
				if (width * height - yellow == brown)
					break;
			}
		}
		int[] answer = new int[] {width, height};
		System.out.println(width);
		System.out.println(height);

	}

}
