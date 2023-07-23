import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		int[] squareNum = new int[(int) Math.pow(N, 0.5) + 1];
		
		for (int i = 1; i < squareNum.length; i++) {
			squareNum[i] = i * i;
		}
		
		boolean isSquare = false;
		for (int i = 1; i < N+1; i++) {
			isSquare = false;
			for (int j = 1; j < squareNum.length; j++) {
				if (i == squareNum[j]) {
					isSquare = true;
					break;
				}
			}
			if (isSquare) {
				dp[i] = 1;
			} else {
				dp[i] = i;				
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < squareNum.length; j++) {
				if (i + squareNum[j] > N) 
					break;
				dp[i+squareNum[j]] = Math.min(dp[i+squareNum[j]], dp[i] + 1);
			}
		}
		
		System.out.println(dp[N]);	
		
	} // end of main
} // end of class