T = int(input())

for tc in range(0, T):
    n = int(input())
    m_list = list(map(int, input().split()))

    print(f'#{tc + 1} {max(m_list) - min(m_list)}')