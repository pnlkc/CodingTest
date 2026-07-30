import math

m_input = input()
split_list = m_input.split(',')
result = []

for i in split_list:
    temp = 2 * math.pi * float(i)
    result.append(f"{temp:.2f}")

print(', '.join(result))