inputNum = input()
list = inputNum.split(', ')

print(', '.join([n for n in list if int(n) % 2 == 1]))