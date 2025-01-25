import java.io.*;
import java.util.*;

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        long prime = 31;
        long result = x;
        result = prime * result + y;
        return (int) (result ^ (result >>> 32));
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Map<Pos, Boolean> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(new Pos(x, y), true);
        }

        for (Pos key : map.keySet()) {
            int x = key.x;
            int y = key.y;

            if (map.containsKey(new Pos(x + A, y)) &&
                    map.containsKey(new Pos(x, y + B)) &&
                    map.containsKey(new Pos(x + A, y + B))) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}