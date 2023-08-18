import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int x1 = Integer.parseInt(st.nextToken());
    	int y1 = Integer.parseInt(st.nextToken());
    	int x2 = Integer.parseInt(st.nextToken());
    	int y2 = Integer.parseInt(st.nextToken());
    	int x3 = Integer.parseInt(st.nextToken());
    	int y3 = Integer.parseInt(st.nextToken());
    	
    	int[] r1 = calc(x1, y1, x2, y2);
    	int[] r2 = calc(x2, y2, x3, y3);
    	
    	if (r1[0] == r2[0] && r1[1] == r2[1]) {
    		System.out.println(-1);
    		return;
    	}
    	
    	double l1 = calcLength(x1, y1, x2, y2);
    	double l2 = calcLength(x1, y1, x3, y3);
    	double l3 = calcLength(x2, y2, x3, y3);
    	
    	double d1 = (l1 + l2) * 2;
    	double d2 = (l1 + l3) * 2;
    	double d3 = (l2 + l3) * 2;
    	double[] arr = { d1, d2, d3 };
    	Arrays.sort(arr);
    	
    	System.out.println(arr[2] - arr[0]);
    }
    
    public static double calcLength(int x1, int y1, int x2, int y2) {
    	return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    public static int[] calc(int x1, int y1, int x2, int y2) {
    	int xDiff = x1 - x2;
    	int yDiff = y1 - y2;
    	int gcd = gcd(yDiff, xDiff);
    	xDiff /= gcd;
    	yDiff /= gcd;
    	
    	return new int[] { xDiff, yDiff };
    }
    
    public static int gcd(int a, int b) {
    	if (b != 0) {
    		return gcd(b, a % b);
    	} else {
    		return a;
    	}
    }
}

