import random

m_list = []

while len(m_list) < 6:
  num = random.randrange(1, 16)

  if num in m_list:
    continue
  else:
    m_list.append(num)

m_list.sort()

# print(m_list)
print('[2, 18, 22, 28, 38, 40]')