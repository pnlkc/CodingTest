import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static List<Integer> list;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		Set<Integer> set = new HashSet<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st2.nextToken()));
		}

		list = new ArrayList<>(set);
		list.sort(Comparator.naturalOrder());

		calc(0, new ArrayList<>());
		
		System.out.println(sb);
	}

	public static void calc(int num, List<Integer> used) {
		if (num == M) {
			sb.append(used.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (used.isEmpty())
					used.add(list.get(i));
				else if (used.get(num - 1) <= list.get(i))
					used.add(list.get(i));
				else 
					continue;

				calc(num + 1, used);

				used.remove(num);
			}
		}
	}
}