import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static long[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 오버플로우 때문에 long형으로저장
		arr = new long[91];
		// 초기값 저장
		arr[1] = 1;
		arr[2] = 1;
		// 값 미리구하기
		for (int i = 3; i < 91; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[Integer.parseInt(br.readLine())]);
		
	} // end of main
} // end of class