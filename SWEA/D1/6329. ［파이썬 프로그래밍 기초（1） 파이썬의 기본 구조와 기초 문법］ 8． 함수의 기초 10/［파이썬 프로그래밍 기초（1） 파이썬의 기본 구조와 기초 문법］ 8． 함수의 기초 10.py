def countdown(num: int):
  if num <= 0:
    print("카운트다운을 하려면 0보다 큰 입력이 필요합니다.")
  else:
    for i in range(0, num):
      print(num - i)

countdown(0)
countdown(10)