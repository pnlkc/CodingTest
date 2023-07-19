import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static ArrayList<String> answer = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			al.add(Integer.parseInt(st2.nextToken()));
		}

		al.sort(Comparator.naturalOrder());

		calc(0, 0, m, al, "");

		System.out.println(String.join("\n", answer.stream().distinct().collect(Collectors.toList())));
	}

	public static void calc(int idx, int n, int t, ArrayList<Integer> al, String s) {
		if (n == t) {
			answer.add(s);
		} else {
			for (int i = idx; i < al.size(); i++) {
				String newS = s;
				if (n != 0)
					newS += " ";
				newS += al.get(i);
				calc(i, n + 1, t, al, newS);
			}
		}
	}
}