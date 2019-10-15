# Exercise settings

Exercise are in Python3.
You need `flask` package.

```bash
# install pip package-manager
sudo apt-get -y install python3-pip

# install flask using pip
pip3 install --user Flask
```

Then, run the exercises using

```bash
python3 xss_1.py
```

It will run a server at

```bash
http://localhost:5000
```

# Reflected XSS

## XSS-1

Nominal behaviour: `GET /hello?name=Emanuele`

Exercise:
1. Try to add your text in **bold**
2. Fix the vulnerability

## XSS-2

Nominal behaviour: `GET /hello?name=Emanuele`
Exercise:
1. Try to add a Button with text me "Click Me". The button click must trigger an alert with the content "You have a Virus!"
2. Fix the vulnerability

## XSS-3

Nominal behaviour: `GET /hello?name=Emanuele`

Exercise :

1. The returned website will set you a random cookie. Get that cookies and pass it to `GET /secret?cookies=<your-cookies>`  
2. Assert the cookie is correct, you will receive a webpage with `Congrats!`  
3. Fix it

# Stored XSS

You have a database `stations.db` with a table `stations`.
Table `stations` contains `station_id` and `location`.

- Use `GET /stations` to have a HTML with a list of all the stations.
- Use `GET /add?id=<station-id>&location=<station-location>` to add a new station.

Exercise: 

1. Exploit the stored XSS vulnerability
2. Fix it

Note. You may want to use `GET /delete?id=<station-id>` to delete the station with a given `id`.
