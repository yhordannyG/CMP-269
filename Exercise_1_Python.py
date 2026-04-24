def exercise_1_basics():
    course = "CMP 269"
    students = 25
    print(f"The course {course} has {students} students.")


def exercise_2_collections():
    colors = ["red", "blue", "green", "yellow", "purple"]
    colors.append("orange")

    student = {
        "name": "John",
        "gpa": 3.8
    }

    print("Colors:", colors)
    print("Student:", student)


def exercise_3_logic():
    numbers = [1, 2, 3, 4, 5, 6, 7, 8]
    evens = []

    for num in numbers:
        if num % 2 == 0:
            evens.append(num)

    print("Even numbers:", evens)


if __name__ == "__main__":
    print("--- Exercise 1 ---")
    exercise_1_basics()
    print("\n--- Exercise 2 ---")
    exercise_2_collections()
    print("\n--- Exercise 3 ---")
    exercise_3_logic()