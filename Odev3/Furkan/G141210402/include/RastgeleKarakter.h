/*
	Furkan Hasan SAKACI G141210402
	Emre UYSAL			b130910006
*/

#ifndef RASTGELEKARAKTER_H
#define RASTGELEKARAKTER_H
#include "Random.h"
#include <unistd.h>
#include <string.h>
struct RASTGELEKARAKTER{
	Random RandKarakter;
	char *Rkarakter;	
	char *Rdizi;
};
typedef struct RASTGELEKARAKTER* RastgeleKarakter;
RastgeleKarakter KarakterUret(void);
RastgeleKarakter YaziUret(int);
RastgeleKarakter AralikYaziUret(int,int,int);
RastgeleKarakter VerilenKarakterdenUret(char*,int adet);
#endif