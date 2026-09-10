class Person:
    def __init__(self):
        pass

    def getGender():
        return 'Unknown'


class Male(Person):
    def getGender():
        return 'Male'

class Female(Person):
    def getGender():
        return 'Female'

male = Male
female = Female

print(male.getGender())
print(female.getGender())