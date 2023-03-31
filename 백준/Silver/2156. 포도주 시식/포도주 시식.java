import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int n;
	private static int[] arr;
	private static int[] answer;
	private static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		answer = new int[n+1];
		
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // 입력완료
		
		// 초기값 세팅
		answer[1] = arr[1];
		if (n>=2) answer[2] = arr[2] + arr[1];
		
		// 점화식
		int max = 0;
		for (int i = 3; i < n+1; i++) {
			max = Math.max(max, answer[i-2]);
			max = Math.max(max, answer[i-3]);
			max = Math.max(max, answer[i-3] + arr[i-1]);
			if (i>=4) max = Math.max(max, answer[i-4] + arr[i-1]);
			answer[i] = max + arr[i];
		}
		
		for (int i = 1; i < n+1; i++) {
			result = Math.max(result, answer[i]);
		}
		
		System.out.println(result);
		
	} // end of main
} // end of class