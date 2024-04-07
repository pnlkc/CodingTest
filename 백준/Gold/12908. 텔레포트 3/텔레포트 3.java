import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xs = Integer.parseInt(st.nextToken());
		int ys = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int xe = Integer.parseInt(st.nextToken());
		int ye = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int xs1 = Integer.parseInt(st.nextToken());
		int ys1 = Integer.parseInt(st.nextToken());
		int xe1 = Integer.parseInt(st.nextToken());
		int ye1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int xs2 = Integer.parseInt(st.nextToken());
		int ys2 = Integer.parseInt(st.nextToken());
		int xe2 = Integer.parseInt(st.nextToken());
		int ye2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int xs3 = Integer.parseInt(st.nextToken());
		int ys3 = Integer.parseInt(st.nextToken());
		int xe3 = Integer.parseInt(st.nextToken());
		int ye3 = Integer.parseInt(st.nextToken());
		
		// 노드 리스트
		List<Node> list = new ArrayList<>();
		list.add(new Node(xs, ys));
		list.add(new Node(xe, ye));
		list.add(new Node(xs1, ys1));
		list.add(new Node(xs2, ys2));
		list.add(new Node(xs3, ys3));
		list.add(new Node(xe1, ye1));
		list.add(new Node(xe2, ye2));
		list.add(new Node(xe3, ye3));

		long[][] dist = new long[8][8];

		// 그래프 초기값 설정
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				dist[i][j] = calcDist(list.get(i).x, list.get(i).y, list.get(j).x, list.get(j).y);
			}
		}
		
		// 텔레포트 값 갱신
		dist[2][5] = Math.min(dist[2][5], 10);
		dist[5][2] = Math.min(dist[5][2], 10);
		dist[3][6] = Math.min(dist[3][6], 10);
		dist[6][3] = Math.min(dist[6][3], 10);
		dist[4][7] = Math.min(dist[4][7], 10);
		dist[7][4] = Math.min(dist[7][4], 10);
		
		// 플로이드 워셜
		for (int k = 0; k < 8; k++) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i == j || i == k || j == k) continue;
					
					if (dist[i][k] == 0 || dist[k][j] == 0) continue;
					
					if (dist[i][j] == 0 || dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		System.out.println(dist[0][1]);
	}
	
	public static int calcDist(int x1, int y1, int x2, int y2) {
		int xDiff = Math.abs(x1 - x2);
		int yDiff = Math.abs(y1 - y2);
		return xDiff + yDiff;
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}