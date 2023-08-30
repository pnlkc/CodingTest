import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 외판원 순회 문제는 TSP(Traveling Salesman Problem)로도 불립니다
//
// 외판원 순회는 노드에 개수에 따라 사용하는 알고리즘이 달라져야 됩니다
// n ≤ 11일 경우 : 브루트포스 → O(N!) 시간으로 해결 가능합니다
// n ≤ 12일 경우 : 백트래킹 → O(N!) 보다 적은 시간으로 해결 가능합니다
// n ≤ 16일 경우: DP + 비트마스킹 → O(2^N + N^2) 시간으로 해결 가능합니다
//
// 브루트포스나 백트래킹 구현은 쉬우나 DP + 비트마스킹 구현은 난이도가 있습니다
// ex) 백준 2098번 외판원 순회
public class Main {
	static int N;
	static int count = 0;
	static int[][] map, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[(1 << N) - 1][N];
		
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
			System.out.println(count++);
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
		
		if (dist[isVisit][city] == 0) { // 탐색한 결과가 불가능이면 MAX 값을 입력하여 탐색하지 않은 경우와 분리하여 중복 실행 방지
			dist[isVisit][city] = 16_000_000;
		}
			
		return dist[isVisit][city];	
	}
}
