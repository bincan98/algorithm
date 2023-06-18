import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 기본적인 누적합 문제

패딩을 주면 편하다
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] prefix_sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix_sum[i] = prefix_sum[i-1] + arr[i];
		} // 입력 완료
		
		int answer = -10_000_000;
		for (int i = 0; i < (N-K+1); i++) {
			answer = Math.max(answer, prefix_sum[i + K] - prefix_sum[i]);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class