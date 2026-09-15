import random

while True:
    num = input()

    if num == '종료':
        break

    num = int(num)
    s_num = random.randint(1, 10)

    if s_num < num:
        print(f'{num}보다 낮습니다!')
    elif s_num > num:
        print(f'{num}보다 높습니다!')
    else:
        break

    break