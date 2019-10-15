from flask import Flask, request, make_response
import sqlite3
import sys
app = Flask(__name__)

@app.route("/stations")
def hello():
    conn = None
    try:
        conn = sqlite3.connect('stations.db')
    except Exception:
        print("Can't connect to the database")
        sys.exit(-1)

    retrieve_station = "SELECT * FROM stations"
    cursor = conn.execute(retrieve_station)
    entries = cursor.fetchall()
    stations_html = "<ul>\n"
    for entry in entries:
        s_id, s_location = entry
        stations_html += "<li>{} - {}</li>".format(s_id, s_location)
    stations_html += "</ul>"
    base_html = """
        <html>
            <head><title>Internet knows</title></head>
            <body>
             Available stations are:
             {}
            </body>
        </html>
    """.format(stations_html)
    return base_html

@app.route("/add")
def secret():
    conn = None
    try:
        conn = sqlite3.connect('stations.db')
    except Exception:
        print("Can't connect to the database")
        sys.exit(-1)

    s_id = request.args.get('id')
    location = request.args.get('location')
    try:
        s_id = int(s_id)
    except Exception:
        return "Wrong ID"
    insert_station = "INSERT INTO stations (station_id, location) VALUES({}, '{}');".format(s_id, location)
    cursor = conn.execute(insert_station)
    conn.commit()
    conn.close()
    return "Success!", 200

@app.route("/delete")
def delete():
    conn = None
    try:
        conn = sqlite3.connect('stations.db')
    except Exception:
        print("Can't connect to the database")
        sys.exit(-1)

    s_id = request.args.get('id')
    try:
        s_id = int(s_id)
    except Exception:
        return "Wrong ID"
    delete_station = "DELETE FROM stations WHERE station_id=" + s_id + ";"
    cursor = conn.execute(delete_station)
    conn.commit()
    conn.close()
    return "Success!", 200

if __name__ == "__main__":
    app.run()
