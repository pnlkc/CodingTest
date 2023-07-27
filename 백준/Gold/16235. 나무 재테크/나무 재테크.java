import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int z;
	
	public Tree(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Tree o) {
		return this.z - o.z;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken()); // 지도 크기
		int m = Integer.parseInt(st1.nextToken()); // 나무 개수
		int k = Integer.parseInt(st1.nextToken()); // K년 후 결과 출력
		int[][] a = new int[n][n];
		int[][] map = new int[n][n];
		PriorityQueue<Tree> treeList = new PriorityQueue<>();
		int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
		int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1 };

		// 지도 생성
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st2.nextToken());
				map[i][j] = 5; // 시작 양분 5
				a[i][j] = num; // A[r][c] 값
			}
		}

		// tree 리스트 초기값 입력
		for (int i = 0; i < m; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st3.nextToken()) - 1;
			int y = Integer.parseInt(st3.nextToken()) - 1;
			int z = Integer.parseInt(st3.nextToken());

			treeList.add(new Tree(x, y, z));
		}

		// K년 진행
		for (int year = 0; year < k; year++) {
			Queue<Tree> dTree = new LinkedList<>();
			
			// 봄
			PriorityQueue<Tree> temp1 = new PriorityQueue<>();
			while (!treeList.isEmpty()) {
				Tree ct = treeList.poll();
				if (map[ct.x][ct.y] < ct.z) {
					dTree.add(ct);
				} else {
					map[ct.x][ct.y] -= ct.z;
					ct.z++;
					temp1.add(ct);
				}
			}
			treeList = temp1;
			
			// 여름
			while (!dTree.isEmpty()) {
				Tree ct = dTree.poll();
				map[ct.x][ct.y] += ct.z / 2;
			}
			
			// 가을
			Queue<Tree> pTree = new LinkedList<>();
			for (Tree ct : treeList) {
				if (ct.z % 5 == 0) {
					pTree.add(ct);
				}
			}
			
			while (!pTree.isEmpty()) {
				Tree ct = pTree.poll();
				if (ct.z % 5 == 0) {
					for (int j = 0; j < 8; j++) {
						if (ct.x + dx[j] >= 0 && ct.x + dx[j] < n && ct.y + dy[j] >= 0 && ct.y + dy[j] < n) {
							treeList.add(new Tree(ct.x + dx[j], ct.y + dy[j], 1));
						}
					}
				}
			}
			
			// 겨울
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] += a[i][j];
				}
			}
		}
		
		System.out.println(treeList.size());
	}
}