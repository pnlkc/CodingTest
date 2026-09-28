class Student:
  def __init__(self, a, b, c):
    self.a = a
    self.b = b
    self.c = c

  def print_score(self):
    print(f'국어, 영어, 수학의 총점: {self.a + self.b + self.c}')

(a, b, c) = map(int, input().split(', '))

s = Student(a, b, c)
s.print_score()