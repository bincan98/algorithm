import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 왜인지는 모름

그냥 다 써보니까 제곱수만 백색임
**/
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int i = 1; i < (int)Math.pow(N, 0.5)+1; i++) { // (int) 씌워주지 않으면 한번 더하게 된다
			answer++;
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class