import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[] Time, Price;
	private static int answer;
	private static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		Time = new int[N + 1];
		Price = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			Time[i] = Integer.parseInt(st.nextToken());
			Price[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료

		dp = new int[150];

		Arrays.fill(dp, -999999);

		dp[N+1] = 0;
		for (int i = N; i >= 1; i--) {
			dp[i] = Math.max(dp[i + 1], dp[i + Time[i]] + Price[i]);
			answer = Math.max(answer, dp[i]);
		}

		// System.out.println(recur(1));
		System.out.println(answer);

	} // end of main

	private static int recur(int current) {
		if (current > N + 1)
			return -99999999;
		if (current == N + 1) {
			return 0;
		}
		if (dp[current] != -1)
			return dp[current];
		dp[current] = Math.max(recur(current + 1), recur(current + Time[current]) + Price[current]);
		return dp[current];
	}
} // end of class