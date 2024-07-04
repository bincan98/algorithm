import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pointer {
        int level;
        int row;
        int col;
        int depth;

        public Pointer(int level, int row, int col, int depth) {
            this.level = level;
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }

    public static int[] dirLevel = {1, -1, 0, 0, 0, 0};
    public static int[] dirRow = {0, 0, 1, -1, 0, 0};
    public static int[] dirCol = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 층수(L), 행(R), 열(C)
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int startLevel = 1;
            int startRow = 1;
            int startCol = 1;

            if (level == 0 && row == 0 && col == 0) {
                break;
            }

            char[][][] building = new char[level + 2][row + 2][col + 2];
            boolean[][][] visited = new boolean[level + 2][row + 2][col + 2];

            for (int i = 0; i <= level + 1; i++) {
                for (int j = 0; j <= row + 1; j++) {
                    Arrays.fill(building[i][j], '#');
                    Arrays.fill(visited[i][j], false);
                }
            }

            for (int i = 1; i <= level; i++) {
                for (int j = 1; j <= row; j++) {
                    String tmpString = br.readLine();
                    char[] tmp = tmpString.toCharArray();
                    for (int k = 1; k <= col; k++) {
                        if (tmp[k - 1] == 'S') {
                            startLevel = i;
                            startRow = j;
                            startCol = k;
                        }
                        building[i][j][k] = tmp[k - 1];
                    }
                }
                br.readLine();
            }

            Queue<Pointer> q = new ArrayDeque<>();

            q.add(new Pointer(startLevel, startRow, startCol, 0));
            visited[startLevel][startRow][startCol] = true;

            boolean done = false;
            while (!q.isEmpty()) {
                Pointer tmp = q.poll();
                for (int i = 0; i < 6; i++) {
                    int nextLevel = tmp.level + dirLevel[i];
                    int nextRow = tmp.row + dirRow[i];
                    int nextCol = tmp.col + dirCol[i];

                    if (!visited[nextLevel][nextRow][nextCol]) {
                        visited[nextLevel][nextRow][nextCol] = true;

                        if (building[nextLevel][nextRow][nextCol] == '.') {
                            q.add(new Pointer(nextLevel, nextRow, nextCol, tmp.depth + 1));
                        } else if (building[nextLevel][nextRow][nextCol] == 'E') {
                            System.out.println("Escaped in " + (tmp.depth + 1) + " minute(s).");
                            done = true;
                            break;
                        }
                    }
                }
                if (done) {
                    break;
                }
            }

            if (!done) {
                System.out.println("Trapped!");
            }
        }
    }
}