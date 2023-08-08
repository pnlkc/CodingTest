import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st1 = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st1.nextToken());
    	int M = Integer.parseInt(st1.nextToken());
    	int R = Integer.parseInt(st1.nextToken());
    	int[][] dist = new int[N][N];
    	int max = 0;
    	
    	int[] item = new int[N];
    	StringTokenizer st2 = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		item[i] = Integer.parseInt(st2.nextToken());
    	}
    	
    	for (int i = 0; i < R; i++) {
    		StringTokenizer st3 = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st3.nextToken()) - 1;
    		int b = Integer.parseInt(st3.nextToken()) - 1;
    		int l = Integer.parseInt(st3.nextToken());
       		
    		dist[a][b] = l;
    		dist[b][a] = l;
    	}
    	
    	for (int k = 0; k < N; k++) {
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				if (i == k || j == k || i == j) continue;
    				if (dist[i][k] == 0 || dist[k][j] == 0) continue;
    				
    				if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
    					dist[i][j] = dist[i][k] + dist[k][j];
    				}
    			}
    		}
    	}

    	for (int i = 0; i < N; i++) {
    		int sum = item[i];
    		for (int j = 0; j < N; j++) {
    			if (dist[i][j] != 0 && dist[i][j] <= M) {
    				sum += item[j];
    			}
    		}
    		
    		max = Math.max(max, sum);
    	}
    	
    	System.out.println(max);
    }
}