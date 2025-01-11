import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, c = 0, l = 0, max = 0;

        while (e < N) {
            if (list[e] % 2 == 0) {
                l++;
                e++;
            } else {
                if (c < K) {
                    e++;
                    c++;
                } else {
                    if (list[s++] % 2 != 0) {
                        c--;
                    } else {
                        l--;
                    }
                }
            }

            max = Math.max(max, l);
        }

        System.out.println(max);
    }
}