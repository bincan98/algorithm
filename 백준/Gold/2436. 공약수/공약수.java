import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		// 입력완료
		
		long N = A * B;
		
		long GCD = 0; // 순서쌍의 최대 공약수 
		long x = 0, y = 0; // 답이 될 변수
		for (long i = 1; i < Math.pow(N, 0.5) + 1; i++) {
			if (N % i == 0) {
				GCD = gcd(N / i, i);
				if (GCD == A && N / GCD == B) {
					x = i;
					y = N / i;
				}
			}
		}
		
		System.out.println(x + " " + y);
		
	} // end of main

	private static long gcd(long a, long b) {
		while (a % b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return b;
	}
} // end of class