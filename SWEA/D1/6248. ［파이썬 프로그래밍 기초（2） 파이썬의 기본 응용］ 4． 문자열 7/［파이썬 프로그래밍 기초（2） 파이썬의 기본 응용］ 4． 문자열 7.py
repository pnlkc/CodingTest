m_input = input()
m_str = ''

for i in range(0, len(m_input)):
    if i % 2 == 0:
        m_str += m_input[i]

print(m_str)