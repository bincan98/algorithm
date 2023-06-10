import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 판정 기본코드 (자바)
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		int answer = 0;
		for (int ele : arr) {
			int cnt = 0;
			for (int i = 1; i < ele; i++) { // 1부터 시작 
				if (i*i > ele) break; // 루트 ele 까지 하기
				
				if (ele % i == 0) { // 나누어 지면 카운트 늘리기
					cnt++;
				}
			}
			if (cnt == 1) { // 1로만 나누어지면 소수 개수 늘리기
				answer++;
			}
		}
		
		System.out.println(answer);
	} // end of main
} // end of class