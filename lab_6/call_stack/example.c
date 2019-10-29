#include <stdio.h>

int foo1(int a, int b)
{
	return a + b;
}

int foo2(int a, int b)
{
	int c = a + b;
	return c;
}


int main()
{
	foo1(1, 2);
	foo2(1, 2);
	return 0;
}
