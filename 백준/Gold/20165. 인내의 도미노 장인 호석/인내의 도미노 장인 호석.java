import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] status = new boolean[N][M]; // true이면 넘어진 도미노
        int result = 0;

        HashMap<Character, Integer> cMap = new HashMap<>();
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        cMap.put('E', 0);
        cMap.put('W', 1);
        cMap.put('S', 2);
        cMap.put('N', 3);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            char c = st.nextToken().charAt(0);
            int cnt = 0;

            if (!status[y1][x1]) { // 넘어지지 않은 도미노인 경우
                int left = map[y1][x1];
                int d = cMap.get(c);
                int add = 0;

                while (left > 0) {
                    int ny = y1 + dy[d] * add;
                    int nx = x1 + dx[d] * add;

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                        if (!status[ny][nx]) {
                            left = Math.max(--left, map[ny][nx] - 1);
                            status[ny][nx] = true;
                            cnt++;
                        } else {
                            left--;
                        }
                    } else {
                        left--;
                    }

                    add++;
                }

                result += cnt;
            }

            st = new StringTokenizer(br.readLine());
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;

            status[y2][x2] = false;
        }

        System.out.println(result);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (status[i][j]) {
                    System.out.print("F");
                } else {
                    System.out.print("S");
                }

                if (j < M - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}