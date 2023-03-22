import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		arr = new int[15][15];
		
		// 0층에 i호에 i명 채우기
		for (int i = 0; i < 15; i++) {
			arr[0][i] = i;
		}

		// 전부 구해놓기
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				// 현재 호의 사람수 = 아랫집의 사람수 + 왼쪽집의 사람수
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			// 구해놓은 아파트에서 출력하기
			sb.append(arr[k][n]).append("\n");
		}
		
		System.out.println(sb.toString());
	} // end of main
} // end of class