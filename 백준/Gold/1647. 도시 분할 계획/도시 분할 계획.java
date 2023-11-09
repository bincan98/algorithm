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
	private static int[][] arr;
	private static int[] p;
	private static int result;
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		arr = new int[M][3];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		} // 입력완료
		
		Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]);
		
		kruskal();
		
		System.out.println(result);
	} // end of main

	private static void kruskal() {
		makeSet();
		
		for (int i = 0; i < M; i++) {
			if(cnt == N-2) break;
			if(union(arr[i][0], arr[i][1])) {
				result += arr[i][2];
				cnt++;
			}
		}
	}

	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return false;
		p[rootB] = rootA;
		return true;
	}

	private static int findSet(int i) {
		if(p[i] == i) return i;
		return p[i] = findSet(p[i]);
	}

	private static void makeSet() {
		for (int i = 1; i < N+1; i++) {
			p[i] = i;
		}
	}
	
	
} // end of class