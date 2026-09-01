m_list = ['A', 'A', 'A', 'O', 'B', 'B', 'O', 'AB', 'AB', 'O']
result = { }

for i in m_list:
    if i not in result:
        result[i] = 1
    else:
        result[i] += 1

print(result)