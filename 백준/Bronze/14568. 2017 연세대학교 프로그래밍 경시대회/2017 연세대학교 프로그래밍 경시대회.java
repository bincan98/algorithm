import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int a = 1; a < 101; a++) {
			for (int b = a + 2; b < 101; b++) {
				for (int c = 1; c < 101; c++) {
					if (c % 2 != 0) continue;
					if (a + b + c == N) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class