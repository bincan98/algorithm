import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소인수 분해하기 기본코드 (자바)
		long N = Long.parseLong(br.readLine());
		
		long cnt = 0;
		List<Long> list = new ArrayList<>(); 
		for (long i = 2; i <= N; i++) {
			// 루트 N까지만 하기
			if (i*i > N) break;
			
			if (N % i == 0) {
				list.add(i);
				cnt++;
				N = N / i;
				i--; // i가 또나올 수 있으므로 반복하기
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