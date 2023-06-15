import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

n이 최대 20억

nCm 오차없이 구하기를 활용해서 구하고 끝자리 0의 개수를 구해보자

-- 최대 10억번 연산하므로 시간초과

nCm = n!/(n-m)!m!

각각 팩토리얼들의 2와 5의 소인수 개수를 구하고 n!의 개수에서 (n-m)! 와 m! 의 개수를 빼자

**/
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 입력완료
		
		// m이 0이거나 n과 같다면 1이므로 답은 0
		if (m == 0 || n == m) {
			System.out.println(0);
			return;
		}
		
		// 소인수 2, 5의 개수를 저장할 변수
		int cnt2 = 0;
		int cnt5 = 0;
		
		// n!의 소인수 2와 5의 개수 구하기
		for (int i = 1; Math.pow(2, i) <= n; i++) {
			cnt2 += n / (int) Math.pow(2, i);
			cnt5 += n / (int) Math.pow(5, i);
		}
		
		// m!의 소인수 2와 5의 개수 구하기
		for (int i = 1; Math.pow(2, i) <= m; i++) {
			cnt2 -= m / (int) Math.pow(2, i);
			cnt5 -= m / (int) Math.pow(5, i);
		}
		
		// (n-m)!의 소인수 2와 5의 개수 구하기
		for (int i = 1; Math.pow(2, i) <= (n-m); i++) {
			cnt2 -= (n-m) / (int) Math.pow(2, i);
			cnt5 -= (n-m) / (int) Math.pow(5, i);
		}
		
		System.out.println(Math.min(cnt2, cnt5));
		
	} // end of main
} // end of class