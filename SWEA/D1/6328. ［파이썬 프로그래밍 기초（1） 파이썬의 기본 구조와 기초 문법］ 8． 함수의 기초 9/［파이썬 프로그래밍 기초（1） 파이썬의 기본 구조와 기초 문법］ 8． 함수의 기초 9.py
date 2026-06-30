def checkLength(s1: str, s2: str):
  if len(s1) >= len(s2):
    print(s1)
  else:
    print(s2)

string = input()
list = string.split(", ")

checkLength(list[0], list[1])