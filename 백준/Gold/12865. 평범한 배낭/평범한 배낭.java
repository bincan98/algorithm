import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, K;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N+1]; 
		int[] values = new int[N+1]; 
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		} // 입력완료
		
		int[][] D = new int[N+1][K+1];
		
		// 초기값 세팅은 0으로 들어가 있음
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < K+1; j++) {
				// 해당 물건의 무게가 j를 초과하는지
				if(weights[i] > j) {
					D[i][j] = D[i-1][j];
				} else { // 초과하지 않는다면
					D[i][j] = Math.max(D[i-1][j], values[i] + D[i-1][j-weights[i]]);
				}
			}
		}
		
		System.out.println(D[N][K]);
		
	} // end of main
} // end of class