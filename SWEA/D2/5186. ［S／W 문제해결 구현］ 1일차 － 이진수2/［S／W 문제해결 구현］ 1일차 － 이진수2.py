tc = int(input())

for i in range(0, tc):
  n = float(input())
  result = ""
  cnt = 0

  while n != 0.0:
    n *= 2
    result += str(int(n))
    n -= int(n)
    cnt += 1

    if cnt > 12:
      break

  if cnt > 12:
    print(f'#{i + 1} overflow')
  else:
    print(f'#{i + 1} {result}')
