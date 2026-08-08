num = int(input())
m_list = [x for x in range(1, num + 1) if num % x == 0]
print(m_list)