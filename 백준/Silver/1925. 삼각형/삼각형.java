import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	
    	if (checkLine(a, b, c)) {
    		System.out.println("X");
    		return;
    	}
    	
    	
    	int[] arr = { calcDistPow(a, b), calcDistPow(a, c), calcDistPow(b, c) };
    	Arrays.sort(arr);
    	
    	if (arr[0] == arr[1] && arr[1] == arr[2]) {
    		System.out.println("JungTriangle");
    	} else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
    		if (arr[0] + arr[1] < arr[2]) {
    			System.out.println("Dunkak2Triangle");
    		} else if (arr[0] + arr[1] > arr[2]) {
    			System.out.println("Yeahkak2Triangle");
    		} else {
    			System.out.println("Jikkak2Triangle");
    		}
    	} else {
    		if (arr[0] + arr[1] < arr[2]) {
    			System.out.println("DunkakTriangle");
    		} else if (arr[0] + arr[1] > arr[2]) {
    			System.out.println("YeahkakTriangle");
    		} else {
    			System.out.println("JikkakTriangle");
    		}
    	}
    }
    
    public static int calcDistPow(int[] a, int[] b) {
    	return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
    
    public static boolean checkLine(int[] a, int[] b, int[] c) {
    	int x1 = a[0] - b[0];
    	int y1 = a[1] - b[1];
    	int gcd1 = gcd(x1, y1);
    	x1 /= gcd1;
    	y1 /= gcd1;
    	
    	int x2 = b[0] - c[0];
    	int y2 = b[1] - c[1];
    	int gcd2 = gcd(x2, y2);
    	x2 /= gcd2;
    	y2 /= gcd2;
    	
    	return x1 == x2 && y1 == y2;    	
    }
    
    public static int gcd(int a, int b) {
    	if (b != 0) {
    		return gcd(b, a % b);
    	}
    	return a;
    }
}