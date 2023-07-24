import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(al);
		
		System.out.println(al.get(n / 2));
		
	}
}