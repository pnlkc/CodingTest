def check(str1:str, str2: str):
  list = [str1, str2]
  list.sort()
  win = ''

  if list[0] == '가위' and list[1] == '바위':
    win = '바위'
  elif list[0] == '가위' and list[1] == '보':
    win = '가위'
  else:
    win = '보'

  print(f"{win}가 이겼습니다!")

name1 = input()
name2 = input()
str1 = input()
str2 = input()
check(str1, str2)