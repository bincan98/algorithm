import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[][] arr;
	private static int[][] answer;
	private static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[1001][3];
		answer = new int[1001][3];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		answer[1][0] = arr[1][0];
		answer[1][1] = arr[1][1];
		answer[1][2] = arr[1][2];
		
		for (int i = 2; i < N+1; i++) {
			for (int j = 0; j < 3; j++) {
				int other1 = (j+1)%3;
				int other2 = (j+2)%3;
				answer[i][j] = arr[i][j] + Math.min(answer[i-1][other1], answer[i-1][other2]); 				
			}
		}
		
		result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Math.min(result, answer[N][i]);
		}
		
		System.out.println(result);
		
	} // end of main
} // end of class