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
	private static int[] number;
	private static int[] arr;
	private static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		// 가능한 수 모두가 몇개나 등장하는지 저장하는 배열
		number = new int[20000001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int ele = Integer.parseInt(st.nextToken());
			number[10000000+ele]++;
		}
		
		M = Integer.parseInt(br.readLine());
		// 몇개있는지 알아내야하는 수
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력완료
		
		// 몇개 있는지 저장할 배열
		answer = new int[M];
		for (int i = 0; i < M; i++) {
			answer[i] = binarySearch(arr[i], -10000000, 10000000);
		}
		
		for (int i = 0; i < M; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	} // end of main

	private static int binarySearch(int target, int start, int end) {
		while(start<=end) {
			int mid = (start+end)/2;
			if(mid==target) return number[10000000+mid]; // 찾았다면 number배열에 알맞은 인덱스로 몇개 있는지 구해온다
			else if(mid>target) end=mid-1;
			else if(mid<target) start=mid+1;
		}
		return 0;
	}
} // end of class