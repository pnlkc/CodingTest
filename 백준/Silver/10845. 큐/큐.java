import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Queue<Integer> que = new LinkedList<>();

		for (int tc = 1; tc <= n; tc++) {
			String a = sc.nextLine();
			String[] arr = a.split(" ");
			int f3 = 0;

			if (arr.length == 2) {
				String f1 = arr[0];
				String f2 = arr[1];
				f3 = Integer.parseInt(f2);
			}

			if (arr[0].equals("push")) {
				que.offer(f3);
			} else if (arr[0].equals("pop")) {
				if (que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.poll()).append("\n");
				}
			} else if (arr[0].equals("size")) {
				sb.append(que.size()).append("\n");
			} else if (arr[0].equals("empty")) {
				if (que.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (arr[0].equals("front")) {
				if (que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.peek()).append("\n");
				}
			} else if (arr[0].equals("back")) {
				if (que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(((LinkedList<Integer>) que).peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}