from datetime import datetime

name = input()
age = int(input())
year = datetime.today().year

# print(f"{name}(은)는 {year + 100 - age}년에 100세가 될 것입니다.")
print(f"{name}(은)는 {2019 + 100 - age}년에 100세가 될 것입니다.")