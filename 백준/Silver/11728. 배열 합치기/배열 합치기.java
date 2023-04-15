import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[] arr, arrA, arrB;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrA = new int[N];
		arrB = new int[M];
		arr = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
//		Arrays.sort(arr);
		int currentA = 0;
		int currentB = 0;
		int i = 0;
		while(true) {
			if(arrA[currentA] >= arrB[currentB]) {
				arr[i++] = arrB[currentB++];
			} else {
				arr[i++] = arrA[currentA++];
			}
			
			if(currentA == N) {
				for (int j = currentB; j < M; j++) {
					arr[i++] = arrB[j];
				}
				break;
			}
			if(currentB == M) {
				for (int j = currentA; j < N; j++) {
					arr[i++] = arrA[j];
				}
				break;
			}
		}
		
		for (int k = 0; k < N+M; k++) {
			sb.append(arr[k]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class