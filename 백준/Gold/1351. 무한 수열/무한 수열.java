import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Long, Long> map;
	static long N;
	static long P;
	static long Q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new HashMap<>();		
		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map.put(0L, 1L);
		
		System.out.println(calc(N));
	}
	
	public static long calc(long num) {
		if (map.get(num) != null) return map.get(num);
		map.put(num, calc(num / P) + calc(num / Q));
		return map.get(num);
	}
}