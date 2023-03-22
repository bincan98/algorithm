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
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		for (int i = 0; i < M; i++) {
			int ele = Integer.parseInt(br.readLine()); 
			arr[i] = ele;
			max = Math.max(max, ele);
		}
		
		binarySearch(1, max);
		
		System.out.println(answer);
	} // end of main

	private static void binarySearch(int start, int end) {
		while(start<=end) {
			int mid = (start+end)/2;
			int possibleChild = 0;
			for (int i = 0; i < M; i++) {
				possibleChild += (arr[i] % mid == 0 ? arr[i]/mid : arr[i]/mid+1);
			}
			if(possibleChild<=N) {
				answer = mid;
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
	}
} // end of class