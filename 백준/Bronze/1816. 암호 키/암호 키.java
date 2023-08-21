import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			long S = Long.parseLong(br.readLine());
			
			boolean isPossible = true;
			for (int j = 2; j < 1_000_001; j++) {
				if (S % j == 0) {
					isPossible = false;
					break;
				}
			}
			
			if (isPossible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	} // end of main
} // end of class