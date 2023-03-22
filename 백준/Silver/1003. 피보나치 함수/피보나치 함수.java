import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 미리 채울 값 [i][0], [i][1] = 각각 fibo(i)를 호출할때 0과 1이 호출되는 횟수
		arr = new int[41][2];
		// 초기값 저장
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		// 미리 채우기
		for (int i = 2; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				// fibo(i)를 호출할때 j가 호출되는 횟수는 i-1과 i-2의 합과 같다
				arr[i][j] = arr[i-1][j] + arr[i-2][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			// N으로 미리 구한 배열 접근하기
			sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
		}
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class