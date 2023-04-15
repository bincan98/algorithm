import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M;
	private static int[] arr;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력완료
		
		
		int start = 0; // 시작 지점
		int end = 0; // 끝 지점
		int sum = arr[0]; // 부분 수열의 합
		answer = 0; // 경우의 수 
		while(true) {
			if(sum > M) { // 부분수열의 합이 목표보다 크다면
				sum -= arr[start]; // 시작지점의 값을 빼주고
				start++; // 시작지점 땡기기
			} else { // sum <= M // 크거나 같다면
				if(sum == M) { // 같다면 
					answer++; // 경우의수 증가시키고
				}
				end++; // 끝지점 밀기
				if(end >= N) break; // 끝에 오면 나가기
				sum += arr[end]; // 부분수열의 합에서 끝지점값 더해주기
			}
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class