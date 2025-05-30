# [Silver III] 오버워치 월드컵 - 13923 

[문제 링크](https://www.acmicpc.net/problem/13923) 

### 성능 요약

메모리: 29956 KB, 시간: 280 ms

### 분류

브루트포스 알고리즘, 구현, 문자열

### 제출 일자

2025년 5월 16일 10:09:38

### 문제 설명

<p>당신은 친구들과 오버워치 월드컵을 보러 갔다. 세계 각국에서 오버워치를 제일 잘하는 사람들이 모여서 오버워치의 최강자를 가리고 있었다.</p>

<p>오버워치 월드컵 경기도 재미있지만 이를 응원하는 것도 오버워치 월드컵의 큰 재미 중에 하나다. 이번 오버워치 월드컵 응원석은 구조가 특이하게 되어있어서, 정사각형 형태의 응원석으로 되어 있었고, 정사각형의 각 변은 오버워치 월드컵 대회에 참가한 팀의 숫자와 동일했다. 또한 사람들은 전부 자신이 응원하는 팀의 티셔츠를 입고 있었다.</p>

<p>응원하는데에는 또 특이한 룰이 있었는데, 응원석의 각 행과 각 열에는 모든 팀의 팬들이 각 한 명씩만 앉아있어야 했다. 사람들은 모두 그 규칙을 지키고 자리에 앉아있는 듯 했으나, 당신은 사람들 중 티셔츠를 잘못 입은 사람이 있다는 것을 깨달았다. 관중석의 사람들의 자리배치도와 각 사람의 티셔츠 팀이 주어졌을 때, 티셔츠를 잘못 입은 사람이 누구인지 그리고 원래대로라면 어떤 팀의 티셔츠를 입어야 하는지 결정하시오.</p>

### 입력 

 <p>여러개의 입력이 주어진다. 팀 티셔츠는 대문자 A부터 Z까지 최대 26개의 색깔이 있다고 가정한다. 첫 입력으로 오버워치 월드컵 출전 팀이 몇 개 있는지 N이 주어진다. (3 ≤ N ≤ 26)  다음으로는 N개의 줄에 걸쳐서 관객들이 어떻게 앉아있는지가 주어진다. 각 문자열은 관객들이 행으로 어떻게 앉아있는지 나타내고 문자열의 각 문자는 해당 관객이 어떤 팀의 티셔츠를 입고 있는지 나타낸다.</p>

### 출력 

 <p>각 테스트 케이스에 대해 두 정수 R, C와 하나의 문자 V를 출력한다. R, C는 티셔츠를 잘못 입고 온 관객의 위치를 나타내는 열과 행이다. 하나의 V는 원래 해당 관객이 입었어야 할 티셔츠가 나타내는 팀이다. 관객석의 열과 행은 1부터 시작한다. R과 C와 V 사이에 공백을 하나씩 넣어서 출력한다. </p>

