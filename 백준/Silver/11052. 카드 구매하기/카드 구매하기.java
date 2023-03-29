import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[] arr, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		answer = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력완료
		
		// 초기값 입력
		answer[1] = arr[1];
		
		// 점화식
		for (int i = 2; i < N+1; i++) {
			int max = 0;
			for (int j = 1; j < i+1; j++) {
				max = Math.max(max, arr[j] + answer[i-j]);
			}
			answer[i] = max;
		}
		
		System.out.println(answer[N]);
	} // end of main
} // end of class