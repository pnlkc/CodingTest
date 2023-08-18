import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W;
	static int H;
	static int X;
	static int Y;
	static int P;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	W = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	X = Integer.parseInt(st.nextToken());
    	Y = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	int cnt = 0;
    	
    	for (int i = 0; i < P; i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st2.nextToken());
    		int y = Integer.parseInt(st2.nextToken());
    		if (check(x, y)) {
    			cnt++;
    		}
    	}
    	
    	System.out.println(cnt);
    }
    
    public static boolean check(int x, int y) {
    	if (x < X - H / 2 || x > X + W + H / 2) {
    		return false;
    	}
    	
    	if (y < Y || y > Y + H) {
    		return false;
    	}
    	
    	if (x < X) {
    		int lpow = (x - X) * (x - X) + (y - Y - H / 2) * (y - Y - H / 2);
    		if (lpow <= (H / 2) * (H / 2)) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	if (x > X + W) {
    		int rpow = (x - W - X) * (x - W - X) + (y - Y - H / 2) * (y - Y - H / 2);
    		if (rpow <= (H / 2) * (H / 2)) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
}