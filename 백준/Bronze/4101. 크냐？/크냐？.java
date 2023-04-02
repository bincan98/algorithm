import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  private static int a, b;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    while (true) {
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      if (a == 0 && b == 0)
        break;
      sb.append(a > b ? "Yes" : "No").append("\n");
      st = new StringTokenizer(br.readLine());
    }

    System.out.println(sb.toString());
  } // end of main
} // end of class