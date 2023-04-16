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
    arr = new int[50_001];
    for (int i = 0; i < 50_001; i++) {
      arr[i] = i * i;
    }

    G = Integer.parseInt(br.readLine());

    int start = 1;
    int end = 2;

    while (true) {
      if (arr[end] - arr[start] <= G) {
        if (arr[end] - arr[start] == G)
          sb.append(end).append("\n");
        end++;
        if (end > 50_000)
          break;
      } else {
        start++;
      }
    }

    System.out.println(sb.length() == 0 ? -1 : sb.toString());
  } // end of main
} // end of class