import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int a = 1; a < 501; a++) {
			for (int b = 1; b < a; b++) {
				if (Math.pow(a, 2) - Math.pow(b, 2) == N) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	} // end of main
} // end of class