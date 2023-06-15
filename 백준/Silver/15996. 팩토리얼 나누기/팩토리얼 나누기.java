import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

N이 굉장히 크므로 직접 하나하나 나누어 보는건 안될듯

형이 말한 N!에 포함된 소인수 x의 개수를 구하는 법을 써보자

예를 들어 N이 20일때 A가 2라면 저 방법을 쓰면 20!에 몇개의 소인수 2가 포함되어 있는지 알 수 있다

그렇다면 k는 그 개수일 것

**/
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static double n;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		// 입력완료
		
		int answer = 0;
		
		// N!에 포함된 소인수 A의 개수 구하기 기본코드
		for (int i = 1; Math.pow(A, i) <= N; i++) { // A^i가 N보다 커지지 않을 때까지만 반복 (파이썬과 다르게 조건문 설정 가능)
			answer += N / (int) Math.pow(A, i); // Math.pow()는 double이라 int = int + double 꼴이지만 이클립스가 잡지 못하므로 주의하고 형변환할 것
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class