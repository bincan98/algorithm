import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = N; i >= 4; i--) {
			if (check(i)) {
				System.out.println(i);
				break;
			}
		}
	} // end of main

	private static boolean check(int i) {
		boolean possible = true;
		while (i != 0) {
			if (i % 10 != 4 && i % 10 != 7) {
				possible = false;
				break;
			}
			i /= 10;
		}
		if (possible) {
			return true;
		} else {
			return false;
		}
	}
} // end of class