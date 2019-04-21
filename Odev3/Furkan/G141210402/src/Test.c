/*
	Furkan Hasan SAKACI G141210402
	Emre UYSAL			b130910006
*/

#include "RastgeleKarakter.h"
int main()
{
char *karakterler;
system("cls");
		RastgeleKarakter karakter=KarakterUret();
		printf("Karakter: ");
		printf("%c\n",karakter->Rkarakter);
		sleep(1);
		
		karakter=YaziUret(100);
		printf("100 karakter: ");
		printf("%s\n",karakter->Rdizi);
		sleep(1);
		
		karakter=AralikYaziUret('a','z',20);
		printf("a ile z arasindaki 20 karakter: ");
		printf("%s\n",karakter->Rdizi);
		sleep(1);
		
		karakterler="asdfgh";
		karakter=VerilenKarakterdenUret(karakterler,20);
		printf("asdfgh karakterlerinden 20 karakter: ");
		printf("%s\n",karakter->Rdizi);
		
return 0;
}