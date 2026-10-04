T = int(input())

for tc in range(0, T):
    N = int(input())
    cnt = {}
    num = [int(i) for i in input()]

    for i in range(0, 10):
        cnt[i] = 0

    for i in num:
        cnt[i] = cnt[i] + 1

    max_item = max(cnt.items(), key=lambda x: (x[1], x[0]))

    print(f'#{tc + 1} {max_item[0]} {max_item[1]}')