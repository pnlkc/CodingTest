import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[][] arr = new int[N][N];
    	int[] s = { -1, -1 };
    	int[] p = { -1, -1 };
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if (arr[i][j] == 2) s = new int[] { i, j };
    			else if (arr[i][j] == 5) p = new int[] { i, j };
    		}
    	}
    	
    	if ((s[0] - p[0]) * (s[0] - p[0]) + (s[1] - p[1]) * (s[1] - p[1]) < 25) {
    		System.out.println(0);
    		return;
    	}
    	
    	int cnt = 0;
    	for (int i = Math.min(s[0], p[0]); i <= Math.max(s[0], p[0]); i++) {
    		for (int j = Math.min(s[1], p[1]); j <= Math.max(s[1], p[1]); j++) {
    			if (arr[i][j] == 1) {
    				cnt++;
    			}
    		}
    	}
    	
    	if (cnt >= 3) {
    		System.out.println(1);
    	} else {
    		System.out.println(0);
    	}
    }
}