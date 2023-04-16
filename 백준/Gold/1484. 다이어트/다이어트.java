import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  private static int[] arr;
  private static int G;

  public static void main(String[] args) throws NumberFormatException, IOException {
    arr = new int[50_001]; // 현재값의 제곱과 현재값-1의 제곱의 차가 100,000보다 100,000울 넘는 최솟값
    for (int i = 0; i < 50_001; i++) {
      arr[i] = i * i; // 제곱값 넣어주기
    }

    G = Integer.parseInt(br.readLine());

    // 시작 위치
    int start = 1;
    int end = 2;

    while (true) {
      if (arr[end] - arr[start] <= G) { // start의 제곱과 end의 제곱의 차가 G보다 작거나 같다면
        if (arr[end] - arr[start] == G) // G와 같다면
          sb.append(end).append("\n"); // end 넣어주기
        end++; // 다음 end 살펴보기
        if (end >= 50_001) // end 다봤다면
          break; // 나가기
      } else { // 차가 G보다 크다면
        start++; // start 당겨오기
      }
    }

    System.out.println(sb.length() == 0 ? -1 : sb.toString()); // sb에 아무값도 없다면 -1 출력하기
  } // end of main
} // end of class