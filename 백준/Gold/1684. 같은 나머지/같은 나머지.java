import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        int[] diff = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i] - arr[i + 1];
        }

        if (n == 2) {
            System.out.println(diff[0]);
            return;
        }

        int gcd = gcd(diff[0], diff[1]);

        for (int i = 2; i < n - 1; i++) {
            gcd = gcd(gcd, diff[i]);
        }

        System.out.println(gcd);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}