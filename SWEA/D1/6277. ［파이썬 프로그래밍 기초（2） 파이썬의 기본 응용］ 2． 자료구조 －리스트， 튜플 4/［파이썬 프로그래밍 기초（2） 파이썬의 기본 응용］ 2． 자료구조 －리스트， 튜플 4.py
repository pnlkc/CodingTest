num_list = []

for i in range(5):
  num_list.append(int(input()))

avg = sum(num_list) / len(num_list)

print(f'입력된 값 {num_list}의 평균은 {avg}입니다.')