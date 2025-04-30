# [Silver IV] 3차원 지뢰찾기 - 29733 

[문제 링크](https://www.acmicpc.net/problem/29733) 

### 성능 요약

메모리: 108492 KB, 시간: 800 ms

### 분류

구현

### 제출 일자

2025년 5월 1일 08:27:31

### 문제 설명

<p>브실이는 컴퓨터를 켰다. 컴퓨터에 설치되어 있는 게임은 지뢰찾기가 유일하다. 똑같은 게임도 하루 이틀이지, 1년 동안 지뢰찾기만 수천 판을 한 브실이는 더 이상 흥미를 느끼지 못했다.</p>

<p>그 모습을 안타깝게 지켜보고 있던 유틸은 지뢰찾기 게임을 수정해 3차원 지뢰찾기 게임을 만들어 주었다. 3차원 지뢰찾기 게임은 지뢰 큐브에서 지뢰에 대한 정보가 주어졌을 때 비어있는 모든 칸마다 인접해 있는 지뢰의 개수를 세서 적는 게임이다.</p>

<p>지뢰 큐브는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D445 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D436 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D43B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>R</mi><mo>×</mo><mi>C</mi><mo>×</mo><mi>H</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$R \times C \times H$</span></mjx-container>개의 칸으로 이루어져 있다. 일부 칸에는 지뢰가 들어있고 나머지는 모두 비어 있다. 선이나 점을 공유하고 있는 두 개의 칸을 인접해 있다고 정의한다. 즉, 모든 칸은 최대 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c><mjx-c class="mjx-c36"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>26</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$26$</span></mjx-container>개의 인접한 칸을 갖고 있다.</p>

<p>브실이는 새로운 게임을 하게 되어 기뻤다. 하지만 차원이 하나 늘어나니 게임이 너무 어려워서 혼자는 해결할 수가 없었다. 브실이를 도와주도록 하자!</p>

### 입력 

 <p>첫 번째 줄에는 세로, 가로, 높이를 나타내는 세 개의 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D445 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>R</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$R$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D436 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>C</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$C$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>H</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$H$</span></mjx-container>가 공백으로 구분되어 주어진다. <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D445 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D436 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D43B TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mn>1</mn><mo>≤</mo><mi>R</mi><mo>,</mo><mi>C</mi><mo>,</mo><mi>H</mi><mo>≤</mo><mn>100</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(1 \le R, C, H \le 100)$</span> </mjx-container></p>

<p>두 번째 줄부터 큐브의 가장 밑에 있는 층부터 가장 위에 있는 층까지 칸들의 정보가 주어진다. 즉, 두 번째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D445 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>R</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$R$</span></mjx-container>개의 줄마다 하나의 층에 있는 칸들의 정보가 가장 아래 줄부터 주어진다.</p>

<p>각 줄에는 가로줄에 들어있는 칸의 정보가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D436 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>C</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$C$</span></mjx-container>개의 문자로 주어진다. 각 문자는 지뢰를 표현하는 <span style="color:#e74c3c;"><code>*</code></span> 또는 빈 공간을 표현하는 <span style="color:#e74c3c;"><code>.</code></span>이다.</p>

<p>이러한 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D445 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>R</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$R$</span></mjx-container>개의 줄이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>H</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$H$</span></mjx-container>번 반복해서 주어진다.</p>

### 출력 

 <p>큐브의 가장 밑에 있는 층부터 가장 위에 있는 층까지 순서대로 출력한다. 층마다 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D436 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>C</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$C$</span></mjx-container>개의 문자들로 이루어진 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D445 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>R</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$R$</span></mjx-container>개의 줄을 가장 아래 줄부터 출력한다.</p>

<p>단, 모든 <span style="color:#e74c3c;"><code>.</code></span> 대신 인접한 칸에 위치한 지뢰의 수를 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>10</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$10$</span></mjx-container>으로 나눈 나머지로 변경해 출력한다. <span style="color:#e74c3c;"><code>*</code></span> 칸은 그대로 출력한다.</p>

<p>문자 사이에 공백이나, 줄 사이에 공백 줄이 있어선 안 된다.</p>

