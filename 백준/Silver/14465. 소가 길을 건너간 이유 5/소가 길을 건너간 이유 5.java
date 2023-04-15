import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, K, B;
	private static boolean[] arr;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N+1];
		
		Arrays.fill(arr, true);
		
		for (int i = 0; i < B; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[a] = false;
		} // 입력완료
		
		answer = Integer.MAX_VALUE;
		
		int start = 1;
		int end = K;
		// 초기값 구하기
		int sum = 0;
		for (int i = 1; i < K+1; i++) {
			if(!arr[i]) sum++;
		}
		answer = Math.min(answer, sum);
		
		for (int i = 0; i < N-K; i++) {
			if(!arr[start]) sum--;
			start++;
			end++;
			if(!arr[end]) sum++;
			answer = Math.min(answer, sum);			
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class