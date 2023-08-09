import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st1 = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st1.nextToken());
    	int M = Integer.parseInt(st1.nextToken());
    	int[][] map = new int[N][M];
    	
    	int[] dx = { 1, -1, 0, 0 };
    	int[] dy = { 0, 0, 1, -1 };
    	int time = 0;
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st2.nextToken());
    		}
    	}
    	
    	while (true) {
    		Queue<Node> queue = new LinkedList<>();
    		queue.add(new Node(0, 0));
    		boolean[][] isVisit = new boolean[N][M];
    		isVisit[0][0] = true;
    		List<Node> deleteList = new ArrayList<>();
    		int[][] cnt = new int[N][M];
    		
    		boolean isEnd = true;
    		
    		while (!queue.isEmpty()) {
    			Node c = queue.poll();
    			
    			for (int d = 0; d < 4; d++) {
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
						continue;
					}
					
					if (isVisit[ny][nx]) {
						continue;
					}
					
					if (map[ny][nx] != 1) {
						queue.add(new Node(nx, ny));
						isVisit[ny][nx] = true;
					} else {
						isEnd = false;
						if (++cnt[ny][nx] == 2) {
							deleteList.add(new Node(nx, ny));
						}
					}
				}
    		}
    		
    		for (Node n : deleteList) {
    			map[n.y][n.x] = 2;
    		}
    		
    		if (isEnd) break;
    		
    		time++;
    	}
    	
    	System.out.println(time);
	}
}