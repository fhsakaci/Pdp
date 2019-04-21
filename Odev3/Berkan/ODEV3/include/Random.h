// Berkan AYDIN – G141210086 
// Ebru KARA – B151210086
#ifndef RANDOM_H
#define RANDOM_H
#include <stdio.h>
#include <stdlib.h>
struct RANDOM
{
	int *randnum;
};
typedef struct RANDOM* Random;
void display(void);
Random RandomCreate(int,int);
#endif