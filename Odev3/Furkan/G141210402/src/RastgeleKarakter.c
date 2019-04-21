/*
	Furkan Hasan SAKACI G141210402
	Emre UYSAL			b130910006
*/

#include "RastgeleKarakter.h"
RastgeleKarakter KarakterUret(void)
{
	char harfler[] = "ABCDEFGHIJKLMNOPRSTUVYZabcdefghijklmnoprstuvyz";
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	this->RandKarakter=RandomAt(0,strlen(harfler));
	this->Rkarakter=harfler[(int)this->RandKarakter->num];
	return this;
}
RastgeleKarakter YaziUret(int adet)
{
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	this->Rdizi=malloc(sizeof(int)*adet);
	for(int i=0;i<adet;i++)
	{
		RastgeleKarakter karakter=KarakterUret();
		this->Rdizi[i]=karakter->Rkarakter;
		usleep(10000);
	}
	this->Rdizi[adet]='\0';
	return this;
}
RastgeleKarakter AralikYaziUret(int karakter1,int karakter2,int adet)
{
	///Karakter üretilmesi için gerekli atalamalar yapildi
	int yuksek,dusuk;
	if(karakter1>=karakter2)
	{
		yuksek=karakter1;
		dusuk=karakter2;
	}
	else
	{
		yuksek=karakter2;
		dusuk=karakter1;
	}	
	///
	///Belirli aralikta uretilecegi icin Ascii kullanılarak karakter üretildi
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	this->Rdizi=malloc(sizeof(int)*adet);
	for(int i=0;i<adet;i++)
	{
		this->RandKarakter=RandomAt(dusuk,yuksek);
		this->Rkarakter=this->RandKarakter->num;
		this->Rdizi[i]=this->Rkarakter;
		usleep(10000);
	}
	this->Rdizi[adet]='\0';
	///
	return this;
}
RastgeleKarakter VerilenKarakterdenUret(char *katardizisi,int adet)
{
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	this->Rdizi=malloc(sizeof(int)*adet);
	int uzunluk=strlen(katardizisi);
	for(int i=0;i<adet;i++)
	{
		this->RandKarakter=RandomAt(0,uzunluk);
		this->Rdizi[i]=katardizisi[(int)this->RandKarakter->num];
		usleep(10000);
	}
	this->Rdizi[adet]='\0';
	return this;
}