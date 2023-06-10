import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] dp = new int[1001];
		
		for (int i = 1; i < 1001; i++) {
			for (int j = 1; j < 1001; j++) {
				if (gcd(Math.max(i, j), Math.min(i, j)) == 1) {
					dp[Math.max(i, j)]++;
				}
			}
		}
		
		dp[1] += 2;
		
		for (int i = 1; i < 1001; i++) {
			dp[i] += dp[i-1];
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int ele = Integer.parseInt(br.readLine());
			System.out.println(dp[ele]);
		}
	} // end of main

	private static int gcd(int a, int b) {
		while (a % b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return b;
	}
	
	
} // end of class