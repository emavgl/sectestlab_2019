# Homework-6

The file `exercise.c` contains C code for application login.
Once executed, the program asks you for a password and, if it matches a secret saved inside the program it will print `Correct password!`.

Having access to the program source code, you have to find the program input such that it lets you exploit the buffer overflow vulnerability and login with an arbitrary password (different than the one stored inside the program).

Repeat the exercise with and without line 9

```c
 char version[3] = "1.0";
```

Is it different? Why?

1. Write a single page report explaining the vulnerability and how you can exploit it.
2. Try to fix the vulnerability
