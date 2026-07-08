def check(str: str):
  reversed_str = str[::-1]

  print(reversed_str)
  
  if str == reversed_str:
    print('입력하신 단어는 회문(Palindrome)입니다.')

str = input()
check(str)