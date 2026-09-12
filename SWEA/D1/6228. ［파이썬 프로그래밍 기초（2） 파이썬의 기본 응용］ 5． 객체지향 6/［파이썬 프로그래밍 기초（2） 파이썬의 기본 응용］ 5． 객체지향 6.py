class Shape:
    def __init__(self):
        pass

    def area(self):
        return 0

class Square(Shape):
    length: int

    def __init__(self, length):
        super().__init__()
        self.length = length

    def area(self):
        return self.length * self.length

square = Square(3)

print(f'정사각형의 면적: {square.area()}')