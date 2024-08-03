import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] arr = new int[Math.min(N / 2, M / 2)];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Math.min(N / 2, M / 2); i++) {
            arr[i] = (N - i * 2) * 2 + (M - i * 2) * 2 - 4;
            arr[i] = R % arr[i];
        }

        for (int i = 0; i < R; i++) {
            boolean isEnd = true;
            for (int j = 0; j < Math.min(N / 2, M / 2); j++) {
                if (arr[j] != 0) {
                    isEnd = false;
                    break;
                }
            }

            if (isEnd) break;

            map = rotate(N, M, map, arr);
        }

        for (int i = 0; i < N; i++) {
            sb.append(Arrays.stream(map[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static int[][] rotate(int N, int M, int[][] map, int[] arr) {
        int[][] temp = new int[N][M];
        copy(map, temp, N, M);
        int cnt = 0;
        int x1 = 0;
        int x2 = M - 1;
        int y1 = 0;
        int y2 = N - 1;

        while (x1 < x2 && y1 < y2) {
            if (arr[cnt] != 0) {
                for (int i = x1; i < x2; i++) {
                    temp[y1][i] = map[y1][i + 1];
                    temp[y2][i + 1] = map[y2][i];
                }

                temp[y1][x2] = map[y1 + 1][x2];
                temp[y2][x1] = map[y2 - 1][x1];

                for (int i = y1; i < y2; i++) {
                    temp[i + 1][x1] = map[i][x1];
                    temp[i][x2] = map[i + 1][x2];
                }

                temp[y1][x1] = map[y1][x1 + 1];
                temp[y2][x2] = map[y2][x2 - 1];

                arr[cnt]--;
            }

            cnt++;
            x1++;
            x2--;
            y1++;
            y2--;
        }

        return temp;
    }

    public static void copy(int[][] ori, int[][] dest, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dest[i][j] = ori[i][j];
            }
        }
    }
}