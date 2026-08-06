def calc(m_list: list):
  temp = []

  for num in m_list:
    if num % 2 == 0:
      temp.append(num)

  print(temp)

calc([1, 3, 11, 15, 23, 28, 37, 52, 85, 100])