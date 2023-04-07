import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[][] arr;
	private static int[][][] distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		distance = new int[N+1][N+1][3];
		distance[1][2][1] = 1;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(arr[i][j] == 1) continue;
				for (int k = 0; k < 3; k++) {
					if(k==0) { // 대각선
						if(arr[i-1][j] != 1 && arr[i][j-1] != 1) {
							distance[i][j][0] += distance[i-1][j-1][0]; 							
							distance[i][j][0] += distance[i-1][j-1][1]; 							
							distance[i][j][0] += distance[i-1][j-1][2]; 							
						}
					} else if(k==1) { // 가로
						distance[i][j][1] += distance[i][j-1][0];
						distance[i][j][1] += distance[i][j-1][1];
					} else if(k==2) { // 세로
						distance[i][j][2] += distance[i-1][j][0];
						distance[i][j][2] += distance[i-1][j][2];
					}
				}
			}
		}
		
		System.out.println(distance[N][N][0] + distance[N][N][1] + distance[N][N][2]);
		
	} // end of main
} // end of class