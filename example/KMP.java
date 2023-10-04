/*
 *  KMP 알고리즘
 *  
 *  문자열 매칭 검색을 할 때 패턴의 접두사와 접미사의 공통된 부분을 스킵하면서 검색 속도를 높이는 방법
 *  패턴의 접두사와 접미사의 공통된 부분을 찾는 전처리 과정이 필요
 *  
 *  시간복잡도 : O(N + M), N = 전체 문자열의 길이, M = 패턴의 길이
 *  
 *  ex) 백준 1786번 찾기
 */
public class KMP {
	static int[] pArr; // 패턴의 접두사와 접미사를 활용하여 구간을 스킵할기 위한 전처리 배열
	
	public KMP(int pLength) {
		pArr = new int[pLength]; // pArr 배열을 패턴의 길이로 초기화
	}
	
	// 패턴(p)의 접두사와 접미사의 공통된 부분을 미리 계산하는 전처리 과정
	public static void makeTable(String p) {
		int idx = 0; // 접두사와 접미사의 공통된 개수
		
		for (int i = 1; i < p.length(); i++) { // 패턴을 1번부터 검색 (0의 경우 1글자이므로 스킵)
			while (idx > 0 && p.charAt(i) != p.charAt(idx)) { // 현재 검색하는 부분의 길이가 2이상이고 공통부분이 끝긴 경우
				idx = pArr[idx - 1];
			}
			
			if (p.charAt(i) == p.charAt(idx)) { // 접두사와 접미사가 공통된 경우
				pArr[i] = ++idx; // idx 증가 후 pArr[i]에 공통된 개수 저장
			}
		}
	}
	
	// 전체 문자열(str)과 패턴(p)의 공통된 부분 찾기
	public static void find(String str, String p) {
		int idx = 0; // 패턴의 위치를 나타낼 포인터
		
		for (int i = 0; i < str.length(); i++) { // 전체 문자열 탐색
			while (idx > 0 && p.charAt(idx) != str.charAt(i)) { // 현재 패턴의 위치의 문자와 전체 문자열의 위치의 문자가 동일하지 않은 경우
				idx = pArr[idx - 1]; // 이전의 공통된 부분으로 idx를 변경 (이 과정에서 불필요한 경우에 대한 검색이 스킵이 됨)
			}
			
			if (p.charAt(idx) == str.charAt(i)) { // 현재 패턴의 위치의 문자와 전체 문자열의 위치의 문자가 동일한 경우
				if (idx + 1 == p.length()) { // 전체 문자열에서 패턴을 찾은 경우
					idx = pArr[idx];
				} else { // 아직 패턴 문자열을 전부 검사하지 못한 경우
					idx++; // 패턴의 인덱스 포인터 값 증가
				}
			}
			
		}
	}
}
