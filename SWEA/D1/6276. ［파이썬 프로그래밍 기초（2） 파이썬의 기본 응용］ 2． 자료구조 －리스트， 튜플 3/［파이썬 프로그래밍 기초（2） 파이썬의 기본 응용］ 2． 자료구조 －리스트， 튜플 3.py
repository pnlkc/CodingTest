num_list = []

for i in range(2, 10):
  temp = []

  for j in range(1, 10):
    if i * j % 3 == 0 or i * j % 7 == 0:
      continue

    temp.append(i * j)
  
  num_list.append(temp)

print(num_list)