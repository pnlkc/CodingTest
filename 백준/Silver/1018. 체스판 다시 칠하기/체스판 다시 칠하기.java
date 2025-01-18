import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] array = new char[y][x];

        for (int i = 0; i < y; i++) {
            array[i] = br.readLine().toCharArray();
        }

        int answer = 64;

        for (int i = 0; i <= y - 8; i++) {
            for (int j = 0; j <= x - 8; j++) {
                char firstChar = array[i][j];
                int count = 0;

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (k % 2 == 0) {
                            if (l % 2 == 0 && array[i + k][j + l] != firstChar) {
                                count++;
                            } else if (l % 2 != 0 && array[i + k][j + l] == firstChar) {
                                count++;
                            }
                        } else {
                            if (l % 2 == 0 && array[i + k][j + l] == firstChar) {
                                count++;
                            } else if (l % 2 != 0 && array[i + k][j + l] != firstChar) {
                                count++;
                            }
                        }
                    }
                }

                count = Math.min(count, 64 - count);
                answer = Math.min(answer, count);
            }
        }

        System.out.println(answer);
    }
}