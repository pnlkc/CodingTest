m_input = input()
split_list = m_input.split(', ')
result = []

for i in range(int(split_list[0])):
  temp = []

  for j in range(int(split_list[1])):
    temp.append(i * j)

  result.append(temp)

print(result)