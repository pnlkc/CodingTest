# [Silver IV] 십자말풀이 - 10656 

[문제 링크](https://www.acmicpc.net/problem/10656) 

### 성능 요약

메모리: 22444 KB, 시간: 132 ms

### 분류

구현

### 제출 일자

2025년 6월 12일 09:30:39

### 문제 설명

<p>다른 소들과 마찬가지로 베시는 십자말풀이 퍼즐을 푸는 것을 좋아한다. 하지만 그녀의 누나 엘시는 베시의 십자말풀이 퍼즐책에 우유를 쏟아 글자들을 더럽혀 베시가 각 힌트가 어디서 시작하는지 알기 힘들게 만들어 놓았다. 베시를 도와 각 힌트의 번호를 알아내자!</p>

<p>아무런 표기가 되어있지 않은 N X M 격자의 십자말풀이가 주어질 것이다(3 <= N <= 50, 3 <= M <= 50). 어떤 칸들은 비어 있을 것이고(하얗게 칠해진) 그리고 어떤 칸들은 막혀있을 것이다(검정색으로 칠해진). 이런 격자에서 힌트의 번호를 알아내는 것은 다음과 같은 두 가지 간단한 단계를 거친다.</p>

<p>단계 1: 우리는 먼저 각 칸이 세로로 이어지는 단서의 시작점인지 가로로 이어지는 단서의 시작점인지 알아낼 것이다. 만약 그 칸이 가로로 이어지는 단서의 시작점이면 그 칸은 비어있으면서 왼쪽 칸이 막혀있거나 격자 밖이어야 하고, 오른쪽에 있는 두 개 이상의 칸은 비어있어야한다(가로로 이어지는 말은 3글자 이상이라는 것을 알 수 있다). 만약 그 칸이 세로로 이어지는 단서의 시작점일 경우에도 비슷하다 : 그 칸은 비어있으면서 그 위의 칸은 막혀있거나 격자의 바깥이며, 아래로 두 개이상의 칸은 비어있어야 한다.</p>

<p>단계 2 : 이제 단서의 시작점에 해당하는 칸마다 번호를 매길 것이다. 번호는 책을 읽는 순서와 동일하게 왼쪽 위부터 오른쪽 아래까지 행 우선으로 순서대로 매긴다.</p>

<pre>...
#..
...
..#
.##</pre>

<p>어떤 단서의 시작이 되는 칸은 !로 되어있다.</p>

<pre>!!!
#..
!..
..#
.##</pre>

<p>여기에다 숫자를 매기게되면 다음과 같아진다.</p>

<pre>123
#..
4..
..#
.##</pre>

<p>아래에 나오는 입력은 보통 출판되는 십자말풀이 퍼즐의 규칙을 따르지 않는다는 것을 기억해둬라. 예를 들어 어떤 비어있는 칸들은 어떠한 단서들에도 포함 안될 수도 있다.</p>

### 입력 

 <p>첫줄의 입력은 N과 M이 공백을 두고 주어진다.</p>

<p>다음 N줄에는 격자의 각 행들의 입력이 이루어진다. 각 행은 M개의 문자를 포함하고 있으며 각 문자는 '.'(비어있는 칸)이거나 '#'(막혀있는 칸)이다.</p>

### 출력 

 <p>출력의 첫 줄에는 단서들의 수를 출력한다.</p>

<p>다른 줄에는 각 힌트들의 시작 위치의 칸을 (행,열)의 꼴로 출력한다. 맨위 왼쪽칸은 (1,1)이고 맨 아래 오른쪽 칸은 (N,M)이다.</p>

<p>출력하는 순서는 위에서 설명한대로 번호를 매긴 순서로 한다.</p>

