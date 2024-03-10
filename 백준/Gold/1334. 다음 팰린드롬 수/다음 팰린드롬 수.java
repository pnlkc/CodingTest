import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger bi = new BigInteger(br.readLine());
		bi = bi.add(BigInteger.ONE);
		char[] N = bi.toString().toCharArray();
		int s = 0;
		int e = N.length - 1;
		
		
		p: while (s <= e) {
			if (N[s] < N[e]) {
				N[e] = N[s];
				
				int temp = e - 1;
				
				if (temp == s) {
					int numS = N[s] - '0' + 1;
					N[s] = String.valueOf(numS).charAt(0);
					N[e] = String.valueOf(numS).charAt(0);
				} else {
					while (temp >= 0) {
						if (N[temp] == '9') {
							N[temp] = '0';
						} else {
							int num = N[temp] - '0' + 1;
							N[temp] = String.valueOf(num).charAt(0);
							
							if (temp <= s) {
								s = temp;
								e = N.length - 1 - temp;
								continue p;
							}
							
							break;
						}
						
						temp--;
					}
					
					if (temp <= s) {
						s = temp;
						e = N.length - 1 - temp;
						continue p;
					}
				}
			} else if (N[s] > N[e]) {
				N[e] = N[s];
			}
			
			s++;
			e--;
		}
		
		System.out.println(String.valueOf(N));
	}
}