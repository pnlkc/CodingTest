def calc(*args):
  result = 1

  for num in args:
    if not isinstance(num, int):
      raise Exception()

    result *= num
  
  print(result)

try:
  calc(1, 2, '4', 3)
except:
  print("에러발생")