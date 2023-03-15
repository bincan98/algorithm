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
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			int ele = Integer.parseInt(br.readLine());
			arr[i] = ele;
			// max 기억해두기 (end로 쓰기 위함)
			max = Math.max(max, ele);
		}
		
		binarySearch(M, 1, max); // start를 0으로 넣으면 mid가 0이 될수 있어 possibleMan을 계산 할때 Arithmetic 오류 발생
		
		System.out.println(answer);
	} // end of main

	private static void binarySearch(int target, int start, int end) {
		while(start<=end) {
			int mid = (int) (((long)start+end)/2); // end가 int의 max값이 들어온다면 start+end가 long이 될수있다
			// mid로 나눌경우 막거리를 마실 수 있는 사람의 수
			int possibleMan = 0;
			for (int i = 0; i < N; i++) {
				possibleMan += arr[i] / mid;
			}
			if(possibleMan>= target) { // 마실 수 있는 사람이 목표보다 많다면
				answer = mid; // 일단 기억해두고
				start = mid+1; // 막걸리 용량을 올리기
			}
			else if (possibleMan<target) { // 마실 수 있는 사람이 목표보다 적다면
				end = mid-1; // 막걸리 용량을 줄이기
			}
		}
	}
} // end of class