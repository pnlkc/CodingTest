m_list = []

for i in range(1, 101):
    if i % 2 == 1:
        m_list.append(str(i))

print(', '.join(m_list))