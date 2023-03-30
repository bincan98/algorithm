import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int T, N, M;
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		arr = new int[31][31];
		
		// 초기값
		for (int i = 0; i < 31; i++) {
			arr[i][0] = 1;
		}
		
		// 미리 채우기
		for (int i = 1; i < 31; i++) {
			for (int j = 1; j < 31; j++) {
				// 점화식
				arr[i][j]= arr[i-1][j-1] + arr[i-1][j]; 
			}
		}
		
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			System.out.println(arr[M][N]);
		}
		
	} // end of main
} // end of class