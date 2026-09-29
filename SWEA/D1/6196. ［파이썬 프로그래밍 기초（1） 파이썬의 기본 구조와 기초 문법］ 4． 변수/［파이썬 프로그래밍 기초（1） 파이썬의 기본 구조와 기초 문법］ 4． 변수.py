num = int(input())
c_num = num
result = 0

for i in range(0, 4):
  result += c_num
  c_num = c_num * 10 + num

print(result)