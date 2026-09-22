class Student:
  def __init__(self, name: str):
    self.name = name

  def print_info(self):
    print(f'이름: {self.name}')

class GraduateStudent(Student):
  major = ''

  def __init__(self, name: str, major: str):
    super().__init__(name)
    self.major = major

  def print_info(self):
    print(f'이름: {self.name}, 전공: {self.major}')

student = Student('홍길동')
graduate_student = GraduateStudent('이순신', '컴퓨터')

student.print_info()
graduate_student.print_info()