sum = 0

while True:
    try:
        list = input().split(' ') 

        if list[0] == 'D':
            sum += int(list[1])
        else:
            sum -= int(list[1])

    except EOFError:
        break

print(f'잔액: {sum}')