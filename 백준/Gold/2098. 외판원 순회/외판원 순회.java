import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[(1 << N)][N];
		
		// 그래프 생성
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 1));
	}

	public static int dfs(int city, int isVisit) {
		if (isVisit == (1 << N) - 1) { // 모두 방문한 경우
			return (map[city][0] == 0) ? 0 : map[city][0];
		}
		
		if (dist[isVisit][city] != 0) { // 현재 도시(city)까지 온 경로가 이미 존재하는 경우
			return dist[isVisit][city];
		}

		for (int nextCity = 0; nextCity < N; nextCity++) {
			// (isVisit & (1 << i)) == 0 -> 다음 도시(nextCity)를 방문하지 않은 경우
			// map[city][i] != 0 -> 현재 도시(city)에서  다음 도시(nextCity)를 방문할 수 있는 경우
			if ((isVisit & (1 << nextCity)) == 0 && map[city][nextCity] != 0) {
				int r = dfs(nextCity, (isVisit | (1 << nextCity)));
				
				if (r == 0) continue; // nextCity에서 실행한 dfs가 갈 수 없는 경우
				
				// dist[isVisit][city] == 0 -> 최초로 경로가 생성된 경우
				// dist[isVisit][city] > r + map[city][nextCity] -> 더 짧은 경로가 나온 경우
				if (dist[isVisit][city] == 0 || dist[isVisit][city] > r + map[city][nextCity]) {
					dist[isVisit][city] = r + map[city][nextCity];
				}
			}
		}
		
		if (dist[isVisit][city] == 0) {
			dist[isVisit][city] = 16_000_000;
		}
			
		return dist[isVisit][city];	
	}
}