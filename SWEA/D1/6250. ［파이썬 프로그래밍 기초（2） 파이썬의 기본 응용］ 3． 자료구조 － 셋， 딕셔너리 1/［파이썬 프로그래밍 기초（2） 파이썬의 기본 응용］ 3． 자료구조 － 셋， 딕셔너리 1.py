m_dict = {
  '가위': 1,
  '바위': 2,
  '보': 3,
}

input1 = input()
input2 = input()

if m_dict[input2] - m_dict[input1] == 1 or m_dict[input1] - m_dict[input2] == 2:
  print('Player B가 이겼습니다.')
else:
  print('Player A가 이겼습니다.')

print('게임을 계속 진행하겠습니까? (예/아니오)')