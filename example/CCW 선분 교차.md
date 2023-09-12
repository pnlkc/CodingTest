## CCW

- **CCW(Counter Clockwise)**
- 평면 위에 놓여진 세 점의 방향 관계를 구하는 알고리즘
- ABC가 **반시계방향을 이루고 있으면 양수**를, **시계방향이면 음수**를, **직선을 이루고 있으면 0**을 반환
- CCW코드는 아래와 같습니다
    
    ```java
    public static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
    //	long r = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);                   
    	long r = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);   
    	return r;                                                                 
    }
    ```
<br>

## CCW를 이용한 선분 교차여부 구하기
- 1번 선분의 시작점을 A, 끝점을 B, 2번 선분의 시작점을 C, 끝점을 D로 가정합니다
- ccw(A, B, C) * ccw(A, B, D)가 음수이고, ccw(C, D, A) * ccw(C, D, B)도 음수이면 두 선분은 교차하게 됩니다
- 예시문제) 백준 17386번 선분 교차 1
- 위 문제에서는 ccw의 결과를 곱하는 과정에서 long범위를 벗어날 수 있기 때문에 ccw의 결과를 -1(음수일 때), 1(양수일 때), 0으로 반환하도록 했습니다
<br>

## 코드 (백준 17386번 선분 교차 1)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st1.nextToken());
		long y1 = Long.parseLong(st1.nextToken());
		long x2 = Long.parseLong(st1.nextToken());
		long y2 = Long.parseLong(st1.nextToken());
		long x3 = Long.parseLong(st2.nextToken());
		long y3 = Long.parseLong(st2.nextToken());
		long x4 = Long.parseLong(st2.nextToken());
		long y4 = Long.parseLong(st2.nextToken());
		
		if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0L && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0L) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long r = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
		if (r < 0) {
			return -1;
		} else if (r > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
```
