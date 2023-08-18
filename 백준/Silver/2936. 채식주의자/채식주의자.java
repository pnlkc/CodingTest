import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	final double AREA = 31_250.0;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	
    	double rx = 0.0;
    	double ry = 0.0;
    	
    	if (x == 0 && y == 0) {
    		rx = 125.0;
    		ry = 125.0;
    	} else if (x == 0) {
    		if (y > 125) {
    			ry = 0;
        		rx = AREA / y;
    		} else if (y < 125) {
    			rx = AREA / (250 - y);
    			ry = 250 - rx;
    		} else {
    			rx = 250.0;
    			ry = 0.0;
    		}
    	} else if (y == 0) {
    		if (x > 125) {
    			rx = 0;
        		ry = AREA / x;
    		} else if (x < 125) {
    			ry = AREA / (250 - x);
    			rx = 250 - ry;
    		} else {
    			ry = 250.0;
    			rx = 0.0;
    		}
    	} else {
    		if (x < 125) {
    			ry = 0;
    			rx = 250.0 - AREA / y;
    		} else if (x > 125) {
    			rx = 0;
    			ry = 250.0 - AREA / x;
    		} else {
    			rx = 0;
    			ry = 0;
    		}
    	}
    	
    	System.out.printf("%.2f %.2f\n", rx, ry);
    }
}