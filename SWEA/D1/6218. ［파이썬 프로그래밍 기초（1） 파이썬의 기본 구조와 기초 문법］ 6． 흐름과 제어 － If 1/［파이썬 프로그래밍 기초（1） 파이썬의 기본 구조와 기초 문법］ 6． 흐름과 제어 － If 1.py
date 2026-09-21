num = int(input())

for i in range(1, num + 1):
  if num % i == 0:
    print(f'{i}(은)는 {num}의 약수입니다.')