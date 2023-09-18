import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
			String str = br.readLine();
			Queue<Character> q = new LinkedList<>();
			Set<Integer> set = new HashSet<>();
			
			for (int i = 0; i < N; i++) {
				q.add(str.charAt(i));
			}
			
			addSet(set, q, N);
			
			for (int i = 0; i < N / 4; i++) {
				q.offer(q.poll());
				
				addSet(set, q, N);
			}
			
			List<Integer> list = new ArrayList<>(set);
			Comparator<Integer> myComparator = new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			};
 			Collections.sort(list, myComparator);
			
			System.out.println("#" + tc + " " + list.get(K - 1));
		}
	}
	
	public static void addSet(Set<Integer> set, Queue<Character> q, int N) {
		Queue<Character> temp = new LinkedList<>(q);
		for (int i = 0; i < N; i += N / 4) {
			String str = "";
			
			for (int j = 0; j < N / 4; j++) {
				str += temp.poll();
			}
			
			set.add(Integer.parseInt(str, 16));
		}
	}
}