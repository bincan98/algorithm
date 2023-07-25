import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * LIS 기본코드
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] lst = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (lst[j] < lst[i] && dp[i] < (dp[j] + 1)) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int answer = 0;
		for (int j = 0; j < dp.length; j++) {
			answer = Math.max(answer, dp[j]);			
		}
		System.out.println(answer);
		
		
	} // end of main
} // end of class