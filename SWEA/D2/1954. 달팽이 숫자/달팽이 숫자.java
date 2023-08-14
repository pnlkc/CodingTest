import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
  
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
          
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int num = 2;
            int x = 0;
            int y = 0;
            map[0][0] = 1;
              
            while (true) {
                boolean isChange = false;
                  
                for (int i = x + 1; i < n; i++) {
                    if (map[y][i] == 0) {
                        map[y][i] = num++;
                        x = i;
                        isChange = true;
                    } else {
                        break;
                    }
                }
                  
                for (int i = y + 1; i < n; i++) {
                    if (map[i][x] == 0) {
                        map[i][x] = num++;
                        y = i;
                        isChange = true;
                    } else {
                        break;
                    }
                }
                  
                for (int i = x - 1; i >= 0; i--) {
                    if (map[y][i] == 0) {
                        map[y][i] = num++;
                        x = i;
                        isChange = true;
                    } else {
                        break;
                    }
                }
                  
                for (int i = y - 1; i >= 0; i--) {
                    if (map[i][x] == 0) {
                        map[i][x] = num++;
                        y = i;
                        isChange = true;
                    } else {
                        break;
                    }
                }
                  
                if (!isChange) break;
            }
              
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j]);
                    if (j != n - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}