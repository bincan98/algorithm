import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int M;
	private static int[] selected;
	private static boolean[] visited;
	private static int S;
	private static int[] arr;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		// 골랐는지 안골랐는지 체크하는 배열
		visited = new boolean[N];
		answer = 0;
		
		recur(0);
		
		if (S == 0) {
			System.out.println(answer - 1);
		}
		else {
			System.out.println(answer);			
		}
	}

	private static void recur(int cur) { // cur 이번에보는게 몇번재 자리인지
		if (cur == N) { // 기저조건 //모든 경우의수가 여기서 만나
			int result = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					result += arr[i];
				}
			}
			if (result == S) {
				answer++;
			}
			return;
		}
		// 골랐을때
		visited[cur] = true;
		recur(cur + 1);
		// 안골랐을때
		visited[cur] = false;
		recur(cur + 1);
		
	}
}