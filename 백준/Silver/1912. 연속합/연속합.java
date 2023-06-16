import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
구간 get 문제

누적합으로 점 get 으로 바꾸자

구간이 정해지지 않았고 n이 100,000이라 무작정 누적합을 반복하면 시간초과 날듯

역시 시간 초과..

가장 큰 연속 수열을 구하려면 한 누적합에서 앞의 누적합 중 가장 작은걸 빼야한다

그럼 누적합에 대해 prefix_sum 을 만들어보자

그리고 그걸 빼면 될듯
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		long[] prefix_sum = new long[n+1];
		long[] prefix_min = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		// prefix_sum 만들기
		for (int i = 1; i < n+1; i++) {
			prefix_sum[i] = prefix_sum[i-1] + arr[i];
		}
		
		// prefix_min 만들기
		for (int i = 1; i < n+1; i++) {
			prefix_min[i] = Math.min(prefix_min[i-1], prefix_sum[i]);
		}
		
//		System.out.println(Arrays.toString(prefix_sum));
//		System.out.println(Arrays.toString(prefix_min));
		
		int answer = -1000;
		for (int i = 1; i < n+1; i++) {
			answer = (int) Math.max(answer, prefix_sum[i] - prefix_min[i-1]);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class