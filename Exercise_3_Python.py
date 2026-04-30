class LehmanCourse:
    def __init__(self, course_name, credits):
        self.course_name = course_name
        self.credits = credits
        self._student_count = 0

    def enroll_student(self):
        self._student_count += 1

    def display_info(self):
        print(f"Course: {self.course_name}, Credits: {self.credits}, Enrolled Students: {self._student_count}")


class LabCourse(LehmanCourse):
    def __init__(self, course_name, credits, lab_fee):
        super().__init__(course_name, credits)
        self.lab_fee = lab_fee

    def display_info(self):
        print(f"Course: {self.course_name}, Credits: {self.credits}, Lab Fee: {self.lab_fee}, Enrolled Students: {self._student_count}")


class Professor:
    def get_role(self):
        return "Teaching and Research"


class Student:
    def get_role(self):
        return "Learning and Coding"


def print_role(person):
    print(person.get_role())


course = LehmanCourse("CMP 269", 4)
course.enroll_student()
course.display_info()

lab_course = LabCourse("CMP 270 Lab", 1, 50)
lab_course.enroll_student()
lab_course.display_info()

prof = Professor()
stud = Student()

print_role(prof)
print_role(stud)