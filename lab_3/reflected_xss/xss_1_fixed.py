from flask import Flask, request
from html import escape
app = Flask(__name__)

@app.route("/hello")
def hello():
    name = request.args.get('name')
    name = escape(name)
    content = """
    <html>
        <head><title>Hello Website</title></head>
        <body>
            Hello {}
        </body>
    </html>
    """.format(name)
    return content

if __name__ == "__main__":
    app.run()
