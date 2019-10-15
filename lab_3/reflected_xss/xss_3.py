from flask import Flask, request, make_response
import uuid
app = Flask(__name__)

your_cookie = None

@app.route("/hello")
def hello():
    global your_cookie
    name = request.args.get('name')
    content = """
    <html>
        <head><title>Internet knows</title></head>
        <body>
            Would you like to know what internet thinks about you? Visit this <a href="https://www.bing.com/search?q={}" attribute="aaa">Link</a>
        </body>
    </html>
    """.format(name)
    resp = make_response(content)
    your_cookie = str(uuid.uuid4())
    resp.set_cookie('auth', your_cookie)
    return resp

@app.route("/secret")
def secret():
    global your_cookie
    print("your_cookie", your_cookie)
    cookies = request.args.get('cookies')
    if your_cookie and your_cookie in cookies:
        print("Congrats!")
        return "Congrats!", 200
    else:
        return "Wrong cookie", 403

if __name__ == "__main__":
    app.run()
