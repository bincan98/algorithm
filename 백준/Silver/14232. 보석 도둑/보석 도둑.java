import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		long N = Long.parseLong(br.readLine());
		
		long cnt = 0;
		List<Long> list = new ArrayList<>(); 
		for (long i = 2; i <= N; i++) {
			if (i*i > N) break;
			
			if (N % i == 0) {
				list.add(i);
				cnt++;
				N = N / i;
				i--;
			}
			
		}
		
		if (N != 1) {
			list.add(N);
			cnt++;
		}
		
		System.out.println(cnt);
		for (long ele : list) {
			System.out.print(ele + " ");
		}
	} // end of main
} // end of class