// Berkan AYDIN – G141210086 
// Ebru KARA – B151210086
#ifndef RASTGELEKARAKTER_H
#define RASTGELEKARAKTER_H
#include "Random.h"
struct RASTGELEKARAKTER{
	Random RandChar;
	char *Rcharacter;	
	char *Rsentence;
	int number;
};
typedef struct RASTGELEKARAKTER* RastgeleKarakter;
RastgeleKarakter GenarateChar(void);
RastgeleKarakter GenarateSentence(int);
RastgeleKarakter SpecialGenarateSentence(int,int);
RastgeleKarakter SpecialGenarateSentence2(char*);
#endif