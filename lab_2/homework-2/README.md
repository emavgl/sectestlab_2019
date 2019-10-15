# DB

name: user.db
database: SQLite3

2 Tables:

**credentials**  
	user_id: string  
	password: string

**accounts**  
	user_id: string  
	first_name: string  
	last_name: string  
	phone: string  


# main.py

Program used to retrieve information about themself (very stupid one)
Just insert the username and password of the user

```
username: ferrari
password: RedCar
```

Try yourself

```bash
$ python3 main.py

Welcome to this vulnerable database reader
You have to login first
Insert your user-id
ferrari
Insert your password
RedCar

===Logged-in=====

Here is ferrari data:
user-id= ferrari
first_name= Massimo
last_name= Ferrari
phone +1111
```

# Homework

1. Find SQLi vulnerabilities
2. Fix the vulnerabilities using prepared statements
3. Make a report (max 1 page) PDF
4. Send via email with subject **[SecTest][Homework-2]**

