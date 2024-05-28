import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] isPrimeNumber = new boolean[100001];

        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;

        for (int i = 2; i <= 100000; i++) {
            int num = i * 2;

            while (num <= 100000) {
                isPrimeNumber[num] = false;
                num += i;
            }
        }

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (!hasPrimeNumber(A, B, isPrimeNumber)) {
                sb.append("-1\n");
                continue;
            }

            Queue<Data> q = new LinkedList<>();
            boolean[] isVisit = new boolean[2000001];

            q.offer(new Data(N, 0));
            isVisit[N] = true;

            while (!q.isEmpty()) {
                Data c = q.poll();

                if (c.num >= A && c.num <= B && isPrimeNumber[c.num]) {
                    sb.append(c.cnt + "\n");
                    break;
                }

                if (!isVisit[c.num / 2]) {
                    isVisit[c.num / 2] = true;
                    q.offer(new Data(c.num / 2, c.cnt + 1));
                }

                if (!isVisit[c.num / 3]) {
                    isVisit[c.num / 3] = true;
                    q.offer(new Data(c.num / 3, c.cnt + 1));
                }

                if (c.num - 1 >= 0 && !isVisit[c.num - 1]) {
                    isVisit[c.num - 1] = true;
                    q.offer(new Data(c.num - 1, c.cnt + 1));
                }

                if (c.num + 1 <= 2000000 && !isVisit[c.num + 1]) {
                    isVisit[c.num + 1] = true;
                    q.offer(new Data(c.num + 1, c.cnt + 1));
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean hasPrimeNumber(int A, int B, boolean[] isPrimeNumber) {
        for (int i = A; i <= B; i++) {
            if (isPrimeNumber[i])
                return true;
        }

        return false;
    }
}

class Data {
    int num, cnt;

    Data(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}