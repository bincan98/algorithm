import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[][] arr;
	private static long[][][] distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1]; // 입력 저장 // [1][1]부터 사용한다
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		// 이동할 수 있는 방법을 나타내는 행렬
		// [i][j] 좌표가 끝이고 모양이 [0],[1],[2] (순서대로 대각선, 가로, 세로)인 파이프를 만들 수 있는 방법 수
		distance = new long[N+1][N+1][3];
		// 초기값 넣기
		distance[1][2][1] = 1;
		// 모든 값 찾기
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				// 벽이라면 계산하지 않기
				if(arr[i][j] == 1) continue;
				for (int k = 0; k < 3; k++) {
					if(k==0) { // 대각선
						if(arr[i-1][j] != 1 && arr[i][j-1] != 1) { // 위와 아래칸이 벽이 아니어야 하므로
							// 대각선은 그전 칸이 어떤 모양이든 상관없다
							distance[i][j][0] += distance[i-1][j-1][0]; 							
							distance[i][j][0] += distance[i-1][j-1][1]; 							
							distance[i][j][0] += distance[i-1][j-1][2]; 							
						}
					} else if(k==1) { // 가로
						// 가로는 세로이면 안된다
						distance[i][j][1] += distance[i][j-1][0];
						distance[i][j][1] += distance[i][j-1][1];
					} else if(k==2) { // 세로
						// 세로는 가로이면 안된다
						distance[i][j][2] += distance[i-1][j][0];
						distance[i][j][2] += distance[i-1][j][2];
					}
				}
			}
		}
		
		// 답은 3가지를 모두 더한 값
		System.out.println(distance[N][N][0] + distance[N][N][1] + distance[N][N][2]);
		
	} // end of main
} // end of class