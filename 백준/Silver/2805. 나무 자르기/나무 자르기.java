import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M;
	private static int[] arr;
	private static int max;
	private static int maxTree;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int ele = Integer.parseInt(st.nextToken());
			arr[i] = ele;
			// 나무 최대값 구하기
			maxTree = Math.max(maxTree, ele);
		} // 입력완료
		
		max = 0;
		binarySearch(M, 0, maxTree);
		
		System.out.println(answer);
	} // end of main

	private static void binarySearch(int target, int start, int end) {
		int mid = 0;
		while(start<=end) {
			mid = (start+end)/2;
			// 나무 잘라서 합구하기
			long sum = 0;
			for (int i = 0; i < N; i++) {
				// 나무가 mid보다 크다면 잘라서 sum에 더해주기
				if(arr[i] > mid) sum+=arr[i]-mid;
			}
			// 필요한 나무길이와 일치한다면 바로 리턴
			if(target == sum) {
				answer = mid;
				return;
			} else if (target > sum) { // 나무가 부족하다면 범위를 좁혀서 다시 자르기
				end = mid-1;
			} else if (target < sum) { // 나무가 넘친다면 일단 높이는 기억해두고 범위를 좁혀서 다시 자르기
				answer = mid;
				start = mid+1;
			}
		}
	} // end of binarySearch
} // end of class