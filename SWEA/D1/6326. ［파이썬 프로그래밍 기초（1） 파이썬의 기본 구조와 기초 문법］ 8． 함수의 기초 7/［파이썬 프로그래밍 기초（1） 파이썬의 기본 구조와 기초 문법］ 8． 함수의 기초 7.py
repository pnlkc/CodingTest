def calc(num: int):
  result = 1

  for i in range(1, num + 1):
    result *= i

  print(result)

string = input()

calc(int(string))