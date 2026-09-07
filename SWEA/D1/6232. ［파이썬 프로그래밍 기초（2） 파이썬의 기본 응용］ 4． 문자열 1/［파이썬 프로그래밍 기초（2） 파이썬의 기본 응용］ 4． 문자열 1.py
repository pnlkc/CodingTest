str1 = input()

print(str1)

if str1 == str1[::-1]:
    print('입력하신 단어는 회문(Palindrome)입니다.')
else: 
    print('입력하신 단어는 회문(Palindrome)이 아닙니다.')