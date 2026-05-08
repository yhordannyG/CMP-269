import pandas as pd

def task_1_series_creation():
    print("--- Task 1: Building Series ---")

    buildings = {
        "Gillet": 4,
        "Carman": 3,
        "Music": 3,
        "Library": 4
    }

    building_series = pd.Series(buildings)

    print(building_series)


def task_2_dataframe_creation():
    print("\n--- Task 2: Course DataFrame ---")

    course_data = {
        "CourseCode": ["CMP168", "CMP269", "CMP338"],
        "Credits": [4, 4, 4],
        "Enrolled": [25, 30, 20]
    }

    df = pd.DataFrame(course_data)

    print(df)


def task_3_data_manipulation():
    print("\n--- Task 3: Filtering and Math ---")

    course_data = {
        "CourseCode": ["CMP168", "CMP269", "CMP338"],
        "Credits": [4, 4, 4],
        "Enrolled": [25, 30, 20]
    }

    df = pd.DataFrame(course_data)

    filtered_df = df[df["Enrolled"] > 20]

    print("Courses with more than 20 students enrolled:")
    print(filtered_df)

    total_students = df["Enrolled"].sum()

    print("\nTotal students across all courses:")
    print(total_students)


def task_4_csv_integration():
    print("\n--- Task 4: Easy CSV I/O ---")

    stock_data = {
        "Symbol": ["AAPL", "GOOG", "MSFT"],
        "Price": [210.50, 175.20, 420.10]
    }

    df = pd.DataFrame(stock_data)

    df.to_csv("stocks.csv", index=False)

    df_loaded = pd.read_csv("stocks.csv")

    print(df_loaded)


if __name__ == "__main__":
    task_1_series_creation()
    task_2_dataframe_creation()
    task_3_data_manipulation()
    task_4_csv_integration()