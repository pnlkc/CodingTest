import string

m_str = input()
m_list = []

for i in string.ascii_lowercase:
    cnt = 0

    for c in m_str:
        if c == i:
            cnt += 1

    if cnt > 0:
        m_list.append((i, cnt))

for i in range(0, len(m_list)):
    print(f'{m_list[i][0]},{m_list[i][1]}')