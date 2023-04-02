import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int N;
  private static int[][] arr;
  private static int[][] minAnswer;
  private static int[][] maxAnswer;
  public static void main(String[] args) throws NumberFormatException, IOException {
    N = Integer.parseInt(br.readLine());
    arr = new int[N][3];
    minAnswer = new int[N][3];
    maxAnswer = new int[N][3];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    } // 입력완료

    // 초기값 넣기
    for (int i = 0; i < 3; i++) {
      minAnswer[0][i] = arr[0][i];
      maxAnswer[0][i] = arr[0][i];
    }
    
    // 최솟값 구하기
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        int min = Integer.MAX_VALUE;
        if (j == 0 || j == 1) {
          min = Math.min(min, minAnswer[i - 1][0]);
        }
        min = Math.min(min, minAnswer[i - 1][1]);
        if (j == 1 || j == 2) {
          min = Math.min(min, minAnswer[i - 1][2]);
        }
        minAnswer[i][j] = min + arr[i][j];
      }
    }

    // 최댓값 구하기
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        int max = 0;
        if (j == 0 || j == 1) {
          max = Math.max(max, maxAnswer[i - 1][0]);
        }
        max = Math.max(max, maxAnswer[i - 1][1]);
        if (j == 1 || j == 2) {
          max = Math.max(max, maxAnswer[i - 1][2]);
        }
        maxAnswer[i][j] = max + arr[i][j];
      }
    }

    int minResult = Integer.MAX_VALUE;
    int maxResult = 0;
    for (int i = 0; i < 3; i++) {
      minResult = Math.min(minResult, minAnswer[N - 1][i]);
      maxResult = Math.max(maxResult, maxAnswer[N - 1][i]);
    }

    System.out.println(maxResult + " " + minResult);



  } // end of main
} // end of class