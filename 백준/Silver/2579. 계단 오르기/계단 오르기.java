import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[] arr;
	private static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		// N으로 배열의 크기를 잡으면 초기식을 넣을 때 인덱스오류가 생길수있다 
		arr = new int[300+1];
		answer = new int[300+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		answer[1] = arr[1];
		answer[2] = arr[1] + arr[2];
		answer[3] = arr[3] + Math.max(arr[1], arr[2]);
		
		// 점화식
		for (int i = 4; i < N+1; i++) {
			answer[i] = arr[i] + Math.max(answer[i-3] + arr[i-1], answer[i-2]);
		}
		
		System.out.println(answer[N]);
		
	} // end of main
} // end of class