import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        for (long i = N - String.valueOf(N).length() * 9; i <= N; i++) {
            if (calc(i) == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    public static long calc(long num) {
        long n = num;
        long result = num;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }
}