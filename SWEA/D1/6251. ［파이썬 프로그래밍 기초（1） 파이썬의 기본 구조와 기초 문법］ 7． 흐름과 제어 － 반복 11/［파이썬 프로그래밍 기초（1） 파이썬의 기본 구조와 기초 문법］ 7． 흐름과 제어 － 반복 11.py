for i in range(1, 6):
  str = "";

  for j in range(5 - i):
    str += " "

  for k in range(i):
    str += "*"
  
  print(str)