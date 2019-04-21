// Berkan AYDIN – G141210086 
// Ebru KARA – B151210086
#include <conio.h>
#include "RastgeleKarakter.h"
int main()
{
int secim;
int number;
char character1,character2;
int scharacter1,scharacter2;

system("cls");
printf("Programlama Dillerinin Prensipleri\n");
printf("Odev 3\n");

RastgeleKarakter character=GenarateChar();
printf("Rastgele Karakter:%c\n",character->Rcharacter);

RastgeleKarakter sentence=GenarateSentence(100);
printf("Rastgele 100 Karakter: %s\n",sentence->Rsentence);

scharacter1='a';scharacter2='k';
RastgeleKarakter Specialsentence=SpecialGenarateSentence(scharacter1,scharacter2);
printf("Verilen iki karakter (a,k):%s\n",Specialsentence->Rsentence);

char *characters;
characters[0]='g';
characters[1]='y';
characters[2]='u';
characters[3]='c';
characters[4]='n';
characters[5]='e';
RastgeleKarakter Specialsentence2=SpecialGenarateSentence2(characters);
printf("Belirtilen Karakterler (g,y,u,c,n,e):%s\n",Specialsentence2->Rsentence);

return 0;
}