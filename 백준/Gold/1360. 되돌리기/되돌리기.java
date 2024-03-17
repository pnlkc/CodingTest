import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Data> list = new ArrayList<>();
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String m = st.nextToken();
			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if (m.equals("type")) {
				if (list.isEmpty()) {
					list.add(new Data(m, str, num));
				} else {
					list.add(new Data(m, list.get(list.size() - 1).str + str, num));
				}
			} else {
				int idx = list.size() - 1;
				int cNum = Integer.parseInt(str);
				
				while (idx >= 0 && list.get(idx).num >= num - cNum) {
					idx--;
				}
				
				if (idx < 0) {
					list.add(new Data(m, "", num));
				} else {
					list.add(new Data(m, list.get(idx).str, num));
				}
			}
		}
		
		System.out.println(list.get(list.size() - 1).str);
	}
}

class Data {
	String mode, str;
	int num;

	public Data(String mode, String str, int num) {
		this.mode = mode;
		this.str = str;
		this.num = num;
	}
}