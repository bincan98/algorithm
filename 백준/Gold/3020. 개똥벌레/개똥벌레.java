import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * imos 써보기
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		// 양 옆에 패딩을 주기
		int[] imo = new int[H+2];
		
		// 홀수 짝수 따라서 imos 다르게 넣기
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				imo[1]++;
				imo[h+1]--;
			} else {
				imo[H-h+1]++;
				imo[H+1]--;
			}
		}
		
		// 누적합 해주기
		for (int i = 1; i < H+2; i++) {
			imo[i] += imo[i-1];
		}
		
		int min = 200_000;
		int cnt = 0;
		// 1부터 H까지 min값과 cnt 구하기
		for (int i = 1; i < H+1; i++) {
			if (min > imo[i]) {
				min = imo[i];
				cnt = 1;
			} else if (min == imo[i]) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
		
	} // end of main
} // end of class