import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int[] arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			boolean find = false;
			int start = 0;
			int end = N - 1;
			while (start <= end) {
				int mid = start + (int) ((end - start) / 2);
				if (arr[mid] > arr2[i]) {
					end = mid - 1;
				} else if (arr[mid] < arr2[i]) {
					start = mid + 1;
				} else {
					find = true;
					break;
				}
			}
			if (find) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
	}
}