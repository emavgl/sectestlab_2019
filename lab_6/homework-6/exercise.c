#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() 
{

 char secret[10];
 // char version[3] = "1.0";
 char password[10];

 memset(secret, 0, 10);

 printf("%x\n", &secret);
 printf("%x\n", &password);

// printf("%s\n", secret);
// printf("%s\n", password);

 strcpy(secret, "pass");

 printf("Please enter the password: \n");

 gets(password);

 if (strncmp(password, secret, 10) == 0) {
  printf("\nCorrect password!\n");
 } else {
  printf("\nWrong password!\n");
 }

 printf("%s\n", secret);
 printf("%s\n", password);


 return 0;
}
