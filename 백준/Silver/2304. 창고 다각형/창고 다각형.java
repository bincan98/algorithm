import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 한 번 풀어봄

어떤 위치에서 천막의 높이는 왼쪽에서 최고 기둥과 오른쪽에서 최고 기둥 중 가장 낮은 기둥의 높이이다
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1001];
		// 왼쪽에서 최고 기둥
		int[] prefix_max = new int[1002];
		// 오른쪽에서 최고 기둥
		int[] suffix_max = new int[1002];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		} // 입력 받기
		
		// 왼쪽에서 최고 기둥 구하기
		for (int i = 1; i < 1001; i++) {
			prefix_max[i] = Math.max(prefix_max[i-1], arr[i]);
		}
		
		// 오른쪽에서 최고 기둥 구하기
		for (int i = 1000; i > 0; i--) {
			suffix_max[i] = Math.max(suffix_max[i+1], arr[i]);
		}
		
		int answer = 0;
		// 왼쪽에서 최고 기둥과 오른쪽에서 최고 기둥 중 가장 낮은 기둥의 높이 더해주기
		for (int i = 1; i < 1001; i++) {
			answer += Math.min(prefix_max[i], suffix_max[i]);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class