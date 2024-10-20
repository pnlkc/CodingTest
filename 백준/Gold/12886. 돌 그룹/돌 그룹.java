import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if ((A + B + C) % 3 != 0) {
            System.out.println(0);
            return;
        }
        
        boolean[][] isVisit = new boolean[1501][1501];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{A, B, C});
        isVisit[A][B] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == c[1] && c[1] == c[2]) {
                System.out.println(1);
                return;
            }
            
            if (c[0] < c[1] && !isVisit[c[0] + c[0]][c[1] - c[0]]) {
                q.offer(new int[]{c[0] + c[0], c[1] - c[0], c[2]});
                isVisit[c[0] + c[0]][c[1] - c[0]] = true;
            } else if (c[0] > c[1] && !isVisit[c[0] - c[1]][c[1] + c[1]]) {
                q.offer(new int[]{c[0] - c[1], c[1] + c[1], c[2]});
                isVisit[c[0] - c[1]][c[1] + c[1]] = true;
            }

            if (c[0] < c[2] && !isVisit[c[0] + c[0]][c[1]]) {
                q.offer(new int[]{c[0] + c[0], c[1], c[2] - c[0]});
                isVisit[c[0] + c[0]][c[1]] = true;
            } else if (c[0] > c[2] && !isVisit[c[0] - c[2]][c[1]]) {
                q.offer(new int[]{c[0] - c[2], c[1], c[2] + c[2]});
                isVisit[c[0] - c[2]][c[1]] = true;
            }

            if (c[1] < c[2] && !isVisit[c[0]][c[1] + c[1]]) {
                q.offer(new int[]{c[0], c[1] + c[1], c[2] - c[1]});
                isVisit[c[0]][c[1] + c[1]] = true;
            } else if (c[1] > c[2] && !isVisit[c[0]][c[1] - c[2]]) {
                q.offer(new int[]{c[0], c[1] - c[2], c[2] + c[2]});
                isVisit[c[0]][c[1] - c[2]] = true;
            }
        }

        System.out.println(0);
    }
}