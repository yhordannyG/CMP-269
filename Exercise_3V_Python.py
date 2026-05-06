import requests
import json
import os

def task_1_append_logger():
    print("--- Task 1: Append Logger ---")
    note = input("Enter a note for the log: ")

    with open("session_log.txt", "a") as file:
        file.write(note + "\n")

    print("\n--- Log History ---")
    with open("session_log.txt", "r") as file:
        print(file.read())


def task_2_word_count_utility():
    print("\n--- Task 2: Word Count Utility ---")

    text = "Knowledge is Power. Go Lightning! Python makes data easy."
    with open("lehman_motto.txt", "w") as file:
        file.write(text)

    with open("lehman_motto.txt", "r") as file:
        content = file.read()
        words = content.split()
        print("Word count:", len(words))


def task_3_api_status_checker():
    print("\n--- Task 3: API Status Checker ---")
    url = "https://jsonplaceholder.typicode.com/posts/101"

    try:
        response = requests.get(url, timeout=5)

        if response.status_code == 200:
            data = response.json()
            print(json.dumps(data, indent=4))

        elif response.status_code == 404:
            print("Error: Post not found.")

        else:
            print(f"Unexpected status code: {response.status_code}")

    except requests.exceptions.Timeout:
        print("Error: Request timed out.")
    except requests.exceptions.RequestException as e:
        print(f"Network error: {e}")


def task_4_data_filtering():
    print("\n--- Task 4: Data Filtering ---")
    url = "https://jsonplaceholder.typicode.com/users"

    try:
        response = requests.get(url)
        users = response.json()

        print("Users living in a Suite:")
        for user in users:
            suite = user["address"]["suite"]
            if "Suite" in suite:
                print(user["name"])

    except requests.exceptions.RequestException as e:
        print(f"Error fetching users: {e}")


def task_5_integration_report():
    print("\n--- Task 5: Integration Report ---")
    url = "https://jsonplaceholder.typicode.com/posts/1"

    try:
        response = requests.get(url)
        data = response.json()

        title = data.get("title", "")
        body = data.get("body", "")

        with open("api_report.txt", "w") as file:
            file.write("API REPORT\n")
            file.write("===========\n\n")
            file.write(f"Title: {title}\n\n")
            file.write("Body:\n")
            file.write(body)

        print("Report Generated")

    except requests.exceptions.RequestException as e:
        print(f"Error generating report: {e}")


if __name__ == "__main__":
    pass