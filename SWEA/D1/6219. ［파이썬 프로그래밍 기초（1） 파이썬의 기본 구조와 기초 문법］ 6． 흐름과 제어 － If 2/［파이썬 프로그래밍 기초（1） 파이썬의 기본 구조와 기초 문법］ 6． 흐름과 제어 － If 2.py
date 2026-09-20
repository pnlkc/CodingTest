num = int(input())
cnt = 0

for i in range(1, num + 1):
  if num % i == 0:
    print(f'{i}(은)는 {num}의 약수입니다.')
    cnt += 1

if cnt == 2:
  print(f'{num}(은)는 1과 {num}로만 나눌 수 있는 소수입니다.')