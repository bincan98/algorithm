import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
1 3
2 3 + 2
3 3 + 2 + 4
4 ... + 4

어떤 좌표가 0,0 에 연결되는지 알아보는 방법
x, y가 같은 수로 나누어지면 보이지 않는다
이게핵심) 즉 같은 수로 나누어지지 않으면 됨
즉 x, y의 최대공약수가 1이면 보이는 수이다
**/
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 개수 저장할 배열
		int[] dp = new int[1001];
		
		// 모든 좌표 다 구하기
		for (int i = 1; i < 1001; i++) {
			for (int j = 1; j < 1001; j++) {
				if (gcd(Math.max(i, j), Math.min(i, j)) == 1) {
					dp[Math.max(i, j)]++;
				}
			}
		}
		
		// (0,1), (1,0) 더하기
		dp[1] += 2;
		
		// 모든 개수 더하기
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
	} // end of gcd
	
} // end of class