mList1 = [1,3,6,78,35,55]
mList2 = [12,24,35,24,88,120,155]

def calc(l1, l2):
  temp = []

  for num in l1:
    if num in l2:
      temp.append(num)

  print(temp)
  
calc(mList1, mList2)