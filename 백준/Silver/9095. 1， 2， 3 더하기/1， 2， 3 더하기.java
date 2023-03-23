import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		arr = new int[11];
		// 초기값 넣기
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		// 미리 값 계산하기
		for (int i = 4; i < 11; i++) {
			// i를 1,2,3의 합으로 나타내는 방법 = i-1의 방법 + i-2의 방법 + i-3의 방법
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb.toString());
	} // end of main
} // end of class