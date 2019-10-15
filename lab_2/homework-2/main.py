import sys
import os
import sqlite3

def print_data(user_id):
    retrieve_user = "SELECT * FROM accounts WHERE user_id = '" + user_id + "';"
    cursor = conn.execute(retrieve_user)
    entries = cursor.fetchall()
    for entry in entries:
        user_id, first_name, last_name, phone = entry
        print()
        print("Here is {} data:".format(user_id))
        print("user-id=", user_id)
        print("first_name=", first_name)
        print("last_name=", last_name)
        print("phone", phone)

# Connect to database
conn = None
try:
    conn = sqlite3.connect('users.db')
except Exception:
    print("Can't connect to the database")
    sys.exit(-1)

print("Welcome to this vulnerable database reader")
print("You have to login first")

print("Insert your user-id")
user_id = input()

print("Insert your password")
password = input()

retrieve_user = "SELECT * FROM credentials WHERE user_id = '" + user_id + "' and password = '" + password + "';"
cursor = conn.execute(retrieve_user)

entries = cursor.fetchall()
if len(entries) > 0:
    print("\n===Logged-in=====")
    print_data(user_id)
else:
    print("Wrong credentials")