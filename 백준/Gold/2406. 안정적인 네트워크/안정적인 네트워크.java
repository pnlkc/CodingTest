import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] parent;
    static int[] rank;
    static int sum = 0;
    static int result = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1.d));

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            union(a, b, 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num;

            for (int j = 0; j < n; j++) {
                num = Integer.parseInt(st.nextToken());
                if (i == 0 || j == 0 || i == j) continue;

                pq.add(new Node(i, j, num));
            }
        }

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            union(c.u, c.v, c.d);
            if (cnt == n - 2) break;
        }

        System.out.println(sum + " " + result);
        System.out.print(sb);
    }

    public static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void union(int node1, int node2, int num) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) return;

        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }

        sum += num;
        cnt++;

        if (num != 0) {
            result++;
            sb.append((node1 + 1)).append(" ").append(node2 + 1).append("\n");
        }
    }

    static class Node {
        int u, v, d;

        Node(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }
    }
}