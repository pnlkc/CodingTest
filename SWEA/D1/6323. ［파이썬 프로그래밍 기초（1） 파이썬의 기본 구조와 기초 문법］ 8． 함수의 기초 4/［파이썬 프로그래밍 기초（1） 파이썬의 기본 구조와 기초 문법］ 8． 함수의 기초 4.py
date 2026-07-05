def calc(num: int):
  result = []

  for i in range(num): 
    if i <= 1:
      result.append(1)
    else:
      result.append(result[i - 2] + result[i - 1])

  print(result)

num = int(input())

calc(num)