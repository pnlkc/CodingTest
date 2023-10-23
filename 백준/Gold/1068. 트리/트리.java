import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Tree[] tree = new Tree[N];
		
		for (int i = 0; i < N; i++) {
			tree[i] = new Tree(i);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Tree start = new Tree(-1);
		
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			
			if (p != -1) {
				tree[i].p = tree[p];
				
				if (tree[p].c.add(tree[i])) {
					
				}
			} else {
				start = tree[i];
			}
		}
		
		Queue<Tree> q = new LinkedList<>();
		int M = Integer.parseInt(br.readLine());
		q.offer(tree[M]);
		
		while (!q.isEmpty()) {
			Tree c = q.poll();
			c.isActive = false;
			
			q.addAll(c.c);
		}
		
		int r = 0;
		q.add(start);
		
		while (!q.isEmpty()) {
			Tree c = q.poll();
			
			if (!c.isActive) {
				continue;
			}
			
			boolean isLeaf = true;
			
			for (Tree n : c.c) {
				if (n.isActive) {
					isLeaf = false;
					break;
				}
			}
			
			if (isLeaf) {
				r++;
			} else {
				q.addAll(c.c);
			}
		}
		
		System.out.println(r);
	}
}

class Tree {
	int N;
	Tree p;
	List<Tree> c = new ArrayList<>();
	boolean isActive = true;
	
	public Tree(int n) {
		N = n;
	}
}