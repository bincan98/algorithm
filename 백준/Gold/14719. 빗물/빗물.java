import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
창고다각형과 비슷한 문제

어떤 위치에서 빗물의 높이는 왼쪽에서 최고 기둥과 오른쪽에서 최고 기둥 중 가장 낮은 기둥의 높이이다

대신 현재 기둥의 높이는 빼기
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W+1];
		// 왼쪽에서 최고 기둥
		int[] prefix_max = new int[W+2];
		// 오른쪽에서 최고 기둥
		int[] suffix_max = new int[W+2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < W+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 기둥 입력 받기
		
		// 왼쪽에서 최고 기둥 구하기
		for (int i = 1; i < W+1; i++) {
			prefix_max[i] = Math.max(prefix_max[i-1], arr[i]);
		}
		
		// 오른쪽에서 최고 기둥 구하기
		for (int i = W; i > 0; i--) {
			suffix_max[i] = Math.max(suffix_max[i+1], arr[i]);
		}
		
		int answer = 0;
		// 왼쪽에서 최고 기둥과 오른쪽에서 최고 기둥 중 가장 낮은 기둥의 높이 에서 현재의 기둥 높이 빼기
		for (int i = 1; i < W; i++) {
			answer += Math.min(prefix_max[i], suffix_max[i]) - arr[i];
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class