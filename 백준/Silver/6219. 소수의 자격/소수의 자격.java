import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
에라토스테네스의 체로 소수 표시하는 자료구조 만들기

그리고 해당하는 수가 있는지 체크하기
**/
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		// 입력완료
		
		// 소수 체크할 배열
		boolean[] isPrime = new boolean[B+1];
		
		// 배열 초기화
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		
		// 에라토스테네스의 체 기본코드
		for (int i = 2; i < B+1; i++) {
			if (i*i > B) break;
			
			if (isPrime[i]) {
				for (int j = i; j < B+1; j++) {
					if (i*j > B) break;
					isPrime[i*j] = false;
				}
			}
		}
		
		// D가 포함된 소수의 개수 저장할 변수
		int answer = 0;
		
		// A부터 B까지 D가 포함된 수가 있는지 체크하기
		for (int i = A; i < B+1; i++) {
			if (isPrime[i]) {
				int N = i;
				while (N != 0) {
					if (N % 10 == D) {
						answer++;
						break;
					}
					N /= 10;
				}
			}
		}
		
		System.out.println(answer);
				
	} // end of main
} // end of class