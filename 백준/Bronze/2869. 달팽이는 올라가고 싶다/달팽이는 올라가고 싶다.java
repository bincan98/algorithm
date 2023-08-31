import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());	
		
		int real_distance = V - A;
		int day = 1;
		if (real_distance % (A - B) == 0) {
			day += (int) (real_distance / (A - B));
		} else {
			day += (int) (real_distance / (A - B)) + 1;
		}
		
		System.out.println(day);
	} // end of main
} // end of class