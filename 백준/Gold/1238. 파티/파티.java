import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] dist = new int[input[0]][input[0]]; // 모든 노드의 거리를 담을 배열
		int max = Integer.MIN_VALUE; // 최종 출력할 가장 오래걸리는 소요시간
		
		// dist 그래프 생성
		for (int i = 0; i < input[1]; i++) {
			int[] gl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dist[gl[0] - 1][gl[1] - 1] = gl[2];
		}
		
		// 플로이드 워셜
		for (int k = 0; k < input[0]; k++) {
			for (int i = 0; i < input[0]; i++) {
				for (int j = 0; j < input[0]; j++) {
					if (i == j || j == k || i == k) continue;
					if (dist[i][k] == 0 || dist[k][j] == 0) continue;
					
					if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		// 각 사람이 파티장까지 갔다오는 거리 계산
		for (int i = 0; i < input[0]; i++) {
			if (dist[i][input[2] - 1] == 0 || dist[input[2] - 1][i] == 0) {
				continue; // 파티장까지 갈수 없는 경우 continue
			}
			max = Math.max(max, dist[i][input[2] - 1] + dist[input[2] - 1][i]);
		}
		
		System.out.println(max); // 결과 값 출력
	}
}