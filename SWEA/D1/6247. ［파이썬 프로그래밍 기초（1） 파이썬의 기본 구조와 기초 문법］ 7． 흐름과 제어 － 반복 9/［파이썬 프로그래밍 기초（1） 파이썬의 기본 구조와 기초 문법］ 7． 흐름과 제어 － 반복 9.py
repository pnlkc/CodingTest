num = 4

while num > 0:
    temp = ''

    for i in range(0, 4 - num):
        temp += ' '

    for i in range(0, num * 2 - 1):
        temp += '*'

    print(temp)

    num -= 1