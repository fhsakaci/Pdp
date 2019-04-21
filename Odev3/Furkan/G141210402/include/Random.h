/*
	Furkan Hasan SAKACI G141210402
	Emre UYSAL			b130910006
*/

#ifndef RANDOM_H
#define RANDOM_H
#include <stdio.h>
#include <stdlib.h>
struct RANDOM
{
	int *num;
	int *adet;
};
typedef struct RANDOM* Random;
Random RandomAt(int,int);
Random AdetUret(int);
#endif