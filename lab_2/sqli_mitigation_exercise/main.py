import sys
import os
import sqlite3

conn = None
try:
    conn = sqlite3.connect('stations.db')
except Exception:
    print("Can't connect to the database")
    sys.exit(-1)

print("Give me a station_id")
station_id = input()

retrieve_station = "SELECT * FROM stations WHERE station_id = " + station_id + ";"
cursor = conn.execute(retrieve_station)

entries = cursor.fetchall()
for entry in entries:
    s_id, s_location = entry
    print("===")
    print("station_id", s_id)
    print("location", s_location)
