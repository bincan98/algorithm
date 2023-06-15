import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

LCM = x * y / gcd(x, y)

x * y = GCD * LCM

GCD * LCM 의 약수를 구하면 모든 x와 y의 순서쌍을 알 수 있다

하지만 이렇게 구한 x * y가 항상 올바르게 GCD와 LCM을 가지는건 아니다 (한 명제가 참이어도 역은 알 수 없듯)

따라서 이 순서쌍이 GCD와 LCM을 가지는지 체크해야한다

자연수 쌍이 여러 개 있는 경우에는 두 자연수의 합이 최소가 되는 두 수가 필요하다

약수 구하기에서 for 문이 1부터 루트 N 까지 진행되므로

조건을 만족하는 마지막 두 수가 두 자연수의 합이 최소가 되는 두 수일 것이다

N이 long이 될 수 있어서 전부 다 long으로 바꿈
**/
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
		// 약수 구하기
		for (long i = 1; i < Math.pow(N, 0.5) + 1; i++) {
			if (N % i == 0) {
				// 순서쌍으로 구한 약수로 gcd 구하기 
				GCD = gcd(N / i, i);
				if (GCD == A && N / GCD == B) { // gcd와 lcm이 같다면 답에 넣어두기
					x = i;
					y = N / i;
				}
			}
		}
		
		System.out.println(x + " " + y);
		
	} // end of main

	private static long gcd(long a, long b) { // gcd 구하기
		while (a % b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return b;
	} // end of gcd
} // end of class