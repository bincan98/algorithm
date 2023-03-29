import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static long[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		arr = new long[1001];
		arr[1] = 1;
		arr[2] = 3;
		for (int i = 3; i < 1001; i++) {
			arr[i] = (arr[i-1] + 2*arr[i-2])%10_007;
		}
		
		System.out.println(arr[Integer.parseInt(br.readLine())]);
	} // end of main
} // end of class