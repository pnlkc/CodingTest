import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int sizeX = Integer.parseInt(st1.nextToken());
		int sizeY = Integer.parseInt(st1.nextToken());
		int answer = 0;

		int n = Integer.parseInt(br.readLine());
		String[] list = new String[n];

		for (int i = 0; i < n; i++) {
			list[i] = br.readLine();
		}

		String[] cpos = br.readLine().split(" ");

		for (String s : list) {
			StringTokenizer st2 = new StringTokenizer(s);
			int dir = Integer.parseInt(st2.nextToken());
			int dist = Integer.parseInt(st2.nextToken());

			if (dir == 1) {
				int cdist = Integer.parseInt(cpos[1]);

				switch (Integer.parseInt(cpos[0])) {
				case 1:
					answer += Math.max(dist, cdist) - Math.min(dist, cdist);
					break;
				case 2:
					answer += sizeY + Math.min(dist + cdist, sizeX * 2 - dist - cdist);
					break;
				case 3:
					answer += dist + cdist;
					break;
				case 4:
					answer += sizeX - dist + cdist;
					break;
				}
			} else if (dir == 2) {
				int cdist = Integer.parseInt(cpos[1]);

				switch (Integer.parseInt(cpos[0])) {
				case 1:
					answer += sizeY + Math.min(dist + cdist, sizeX * 2 - dist - cdist);
					break;
				case 2:
					answer += Math.max(dist, cdist) - Math.min(dist, cdist);
					break;
				case 3:
					answer += dist + sizeY - cdist;
					break;
				case 4:
					answer += sizeX - dist + sizeY - cdist;
					break;
				}
			} else if (dir == 3) {
				int cdist = Integer.parseInt(cpos[1]);

				switch (Integer.parseInt(cpos[0])) {
				case 1:
					answer += dist + cdist;
					break;
				case 2:
					answer += sizeY - dist + cdist;
					break;
				case 3:
					answer += Math.max(dist, cdist) - Math.min(dist, cdist);
					break;
				case 4:
					answer += sizeX + Math.min(dist + cdist, sizeX * 2 - dist - cdist);
					break;
				}
			} else if (dir == 4) {
				int cdist = Integer.parseInt(cpos[1]);

				switch (Integer.parseInt(cpos[0])) {
				case 1:
					answer += dist + sizeX - cdist;
					break;
				case 2:
					answer += sizeY - dist + sizeX - cdist;
					break;
				case 3:
					answer += sizeX + Math.min(dist + cdist, sizeX * 2 - dist - cdist);
					break;
				case 4:
					answer += Math.max(dist, cdist) - Math.min(dist, cdist);
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}