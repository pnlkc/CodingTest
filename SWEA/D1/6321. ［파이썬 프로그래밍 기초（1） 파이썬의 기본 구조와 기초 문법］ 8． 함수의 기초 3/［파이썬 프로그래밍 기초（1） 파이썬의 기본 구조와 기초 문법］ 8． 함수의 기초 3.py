def checkPrime(num: int):
  sqrt = int(num ** 0.5)

  for i in range(2, sqrt + 1):
    if (num % i == 0):
      print("소수가 아닙니다.")
      return
    
  print("소수입니다.")

num = int(input())

if num < 2:
  print("소수가 아닙니다.")
else:
  checkPrime(num)