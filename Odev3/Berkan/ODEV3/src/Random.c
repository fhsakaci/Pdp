// Berkan AYDIN – G141210086 
// Ebru KARA – B151210086
#include "Random.h"
#include <time.h>
#include <stdio.h>
#include <windows.h>
void display(void)
{
	printf("Running!!");
}
Random RandomCreate(int max,int min)
{
	SYSTEMTIME st;
    GetSystemTime(&st);	
  	Random this;
  	this = (Random)malloc(sizeof(struct RANDOM));
  	this->randnum=st.wMilliseconds%(max-min)+min;
  	return this;
}