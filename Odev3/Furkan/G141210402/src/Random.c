/*
	Furkan Hasan SAKACI G141210402
	Emre UYSAL			b130910006
*/

#include "Random.h"
#include <time.h>
#include <stdio.h>
#include <windows.h>
///Kelime adetinin de rastgele secilmesi durumunda kullanılmasi icin olusturuldu
Random AdetUret(int adet)
{
	struct timeval currentTime;
	gettimeofday(&currentTime, NULL);
	long mikrosaniye=currentTime.tv_usec;
  	Random this;
  	this = (Random)malloc(sizeof(struct RANDOM));
  	this->adet=mikrosaniye%(adet)+1;///Minimum 1 karakter uretilsin diye 1 eklendi
  	return this;
}
Random RandomAt(int dusuk,int yuksek)
{
	struct timeval currentTime;
	gettimeofday(&currentTime, NULL);
	long mikrosaniye=currentTime.tv_usec;
  	Random this;
  	this = (Random)malloc(sizeof(struct RANDOM));
  	this->num=mikrosaniye%(yuksek-dusuk)+dusuk;///Minimum en dusuk deger ve en yuksek ise minimum ile aradaki fark eklendi
  	return this;
}

