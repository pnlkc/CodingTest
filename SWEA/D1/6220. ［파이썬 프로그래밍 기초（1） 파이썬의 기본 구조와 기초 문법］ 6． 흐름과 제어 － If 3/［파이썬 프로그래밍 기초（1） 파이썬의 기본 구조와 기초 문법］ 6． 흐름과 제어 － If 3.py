tc = int(input())

for i in range(1, tc + 1):
    c = input()

    print(f'#{i} {c} 는 {"대문자" if c.isupper() else "소문자"} 입니다.')