# 비트마스킹

- 숫자 2진수 String으로 변환

```java
int num = 8;
String numToBinary = Integer.toBinaryString(num);
System.out.println(numToBinary); // 1000
```
<br>

- 비트마스크 연산자

```java
public class Main {
	public static void main(String[] args) {
		int a = 16;
		int b = 21;
		
		println(a); // 10000
		println(b); // 10101
		
		// AND 연산 (&) : 양쪽 모두 1인 경우에만 1 반환, 나머진 0 반환
		println(a & b); // 10000
		
		// OR 연산 (|) : 한쪽이라도 1인 경우에는 1 반환, 나머진 0 반환
		println(a | b); // 10101
		
		// XOR 연산 (^) : 두 비트가 서로 다르면 1, 같으면 0 반환
		println(a ^ b); // 101
		
		// NOT 연산 (~) : 각 비트를 반대로 바꾸는 연산, int의 경우 32bit(4byte)로 출력
		println(~a); // 11111111111111111111111111101111
		println(~b); // 11111111111111111111111111101010
		
		// Shift 연산 (<<, >>, >>>) : 비트를 왼쪽, 오른쪽으로 이동
		int c = -16;
		println(c); // 11111111111111111111111111110000
		
		// << 연산 : 부호를 유지한 채 왼쪽으로 비트 이동
		System.out.println(c << 2); // -64
		println(c << 2); // 11111111111111111111111111000000
		
		// >> 연산 : 부호를 유지한 채 오른쪽으로 비트 이동
		System.out.println(c >> 2); // -4
		println(c >> 2); // 11111111111111111111111111111100
		
		// >>> 연산 : 부호 유지 없이 빈자리를 0으로 채워서 오른쪽으로 비트 이동
		System.out.println(c >>> 2); // 1073741820
		println(c >>> 2); // 00111111111111111111111111111100
	}
	
	public static void println(int num) {
		System.out.println(Integer.toBinaryString(num));
	}
}
```
<br>

- 비트 1개수 세기

```java
int num = 63;                                         
System.out.println(Integer.toBinaryString(num));      
         
// 숫자를 Integer.toBinaryString() 메소드를 사용해 문자로 변환 후 1글자씩 탐색
                
// 1을 뺀 값과 & 연산하고 결과를 업데이트하기                          
int num1 = num;                                       
int cnt1 = 0;                                         
while (num1 != 0) {                                   
	num1 = num1 & (num1 - 1);                         
	cnt1++;                                           
}                                                     
System.out.println(cnt1);                             
                                                      
// 1과 & 연산하고 shift 연산하기                               
int num2 = num;                                       
int cnt2 = 0;                                         
while (num2 != 0) {                                   
	if ((num2 & 1) == 1) cnt2++;                      
	num2 >>>= 1;                                      
}                                                     
System.out.println(cnt2);
```
<br>

- 비트 원소 관리

```java
// 원소 추가 (비트 | 1 << 추가할 비트 인덱스)                                    
int num1 = 16; // 10000                                            
int addIdx = 3; // 왼쪽부터 해당하는 인덱스 (4번째 비트)                          
int addNum = num1 | 1 << addIdx;                                   
System.out.println(Integer.toBinaryString(addNum)); // 11000       
                                                                   
// 원소 삭제 (비트 & ~(1 << 삭제할 비트 인덱스))                                 
int num2 = 15; // 1111                                             
int removeIdx = 1; // 왼쪽부터 해당하는 인덱스 (2번째 비트)                       
int removeNum = num2 & ~(1 << removeIdx);                          
System.out.println(Integer.toBinaryString(removeNum)); // 1101     
                                                                   
// 원소 토글 (비트 ^ (1 << 토글할 비트 인덱스))                                  
int num3 = 15; // 1111                                             
int toggleIdx = 2; // 왼쪽부터 해당하는 인덱스 (3번째 비트)                       
int toggleNum = num3 ^ (1 << toggleIdx);                           
System.out.println(Integer.toBinaryString(toggleNum)); // 1011     
                                                                   
// 원소 체크 (비트 & (1 << 체크할 비트 인덱스))가 0이면 0, 아니면 1                    
int num4 = 11; // 1011                                             
int checkIdx = 2; // 왼쪽부터 해당하는 인덱스 (3번째 비트)                        
int checkResult = num4 & (1 << checkIdx);                          
System.out.print(Integer.toBinaryString(num4) + "의 ");             
System.out.print(checkIdx + 1 + "번째 비트는 ");                        
if (checkResult == 0) {                                            
	System.out.print("0입니다\n");                                    
} else {                                                           
	System.out.print("1입니다\n");                                    
}                                                                  

// 특정 idx 원소를 0으로 변환하기 : 비트 & (~(1 << 인덱스))
int num5 = 15; // 1111
num5 = num5 & (~(1 << 2); // 1011      

// 특정 idx 원소를 1로 변환하기 : 비트 | (1 << 인덱스)
int num6 = 8 // 1000
num6 = num6 | (1 << 1) // 1010  
                                                                   
// 원소 비우기 (0으로 설정)                                                 
int num7 = 15; // 1111                                             
num7 = 0; // 0                                                     
                                                                   
// 원소 채우기 ((1 << 1로 채울 개수 ) - 1)                                   
int fillNum = 5;                                                   
System.out.println(Integer.toBinaryString((1 << 5) - 1));
```
<br>

- 부분 집합

```java
int N = 4;                                                             
char[] arr = { 'a', 'b', 'c', 'd' };                                   
           
                                                            
// 부분 집합의 개수                                                           
System.out.println("부분 집합의 개수 : " + (1 << N)); // 부분 집합의 개수            
        
                                                               
// 부분 집합의 요소 탐색                                                        
for (int i = 0; i < 1 << N; i++) {                                     
	System.out.print("비트마스킹 : " + Integer.toBinaryString(i));          
	List<Character> list = new ArrayList<>();                          
	                                                                   
	for (int j = 0; j < arr.length; j++) {                             
		if ((1 & (i >> j)) == 1) {                                     
			list.add(arr[arr.length - 1 - j]);                         
		}                                                              
	}                                                                  
	                                                                   
	Collections.reverse(list);                                         
                                                                       
	System.out.print(" / 부분 집합 : " + String.valueOf(list));            
	System.out.println();                                              
}

// 부분 집합 순회하기                                                                 
int num2 = 21; // 10101;                                                      
List<String> subList = new ArrayList<>(); // 부분 집합 리스트                        
                                                                              
for (int sub = num2; sub >= 0; sub = (sub - 1) & num2) {                      
	subList.add(Integer.toBinaryString(sub));                                 
	if (sub == 0) break;                                                      
}                                                                             
                                                                              
System.out.println(subList); // [10101, 10100, 10001, 10000, 101, 100, 1, 0]                                                              
     
                                                                  
// 부분 집합 여부 탐색 => a가 b의 부분 집합이면 (a & b) == a가 성립                       
int a = 10; // 1010                                                    
int b = 31; // 11111                                                   
System.out.println((a & b) == a); // true
```
<br>

- 집합 연산

```java
int a = 21; // 10101                                
int b = 15; // 1111                                 
                                                    
// 합집합 (a | b)                                      
ptb(a | b); // 11111                                
                                                    
// 교집합 (a & b)                                      
ptb(a & b); // 101                                  
                                                    
// 차집합 (a & ~b)                                     
ptb(a & ~b); // 10000                               
                                                    
// a, b 각각에 유일하게 존재하는 요소 찾기                         
ptb(a ^ b); // 11010                                
                                                    
// 집합 크기 (1칸씩 오른쪽으로 비트 이동 시키며 1 탐색)                 
int size = 0;                                       
int num = 100; // 1100100                           
while (num != 0) {                                  
	if (num % 2 != 0) {                             
		size++;                                     
	}                                               
	num >>= 1;                                      
}                                                   
System.out.println(size); // 3
```
<br>
