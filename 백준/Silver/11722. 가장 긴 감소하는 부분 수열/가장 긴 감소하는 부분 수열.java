import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int N;
  private static int[] arr;
  private static int[] answer;
  private static int max;
  public static void main(String[] args) throws NumberFormatException, IOException {
    N = Integer.parseInt(br.readLine());

    arr = new int[N];
    answer = new int[N];
    
    st = new StringTokenizer(br.readLine());
    for (int i = N - 1; i >= 0; i--) {
      // 거꾸로 받기
      arr[i] = Integer.parseInt(st.nextToken());
    } // 입력완료

    for (int i = 0; i < N; i++) {
      answer[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j] && answer[i] < (answer[j] + 1))
          answer[i] = answer[j] + 1;
      }
      max = Math.max(max, answer[i]);
    }
    
    System.out.println(max);
  } // end of main
} // end of class