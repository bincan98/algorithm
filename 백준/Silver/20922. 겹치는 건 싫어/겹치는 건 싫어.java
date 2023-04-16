import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int N, K;
  private static int[] arr, check;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];
    check = new int[100_001];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < N+1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    } // 입력완료

    int answer = 0;

    int start = 1;
    int end = 1;
    check[arr[end]]++;
    
    while (true) {
      if (check[arr[end]] <= K) {
        answer = Math.max(answer, end - start + 1);
        end++;
        if (end > N)
          break;
        else 
          check[arr[end]]++;
      } else {
        check[arr[start]]--;
        start++;
      }
    }

    System.out.println(answer);

  } // end of main
} // end of class