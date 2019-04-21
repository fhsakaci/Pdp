// Berkan AYDIN – G141210086 
// Ebru KARA – B151210086
#include "RastgeleKarakter.h"
RastgeleKarakter GenarateChar(void)
{
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	this->RandChar=RandomCreate(2,0);
	int select=this->RandChar->randnum;
	if(select==1)
	{
		this->RandChar=RandomCreate(91,65);
	}
	else
	{
		this->RandChar=RandomCreate(123,97);
	}
	this->Rcharacter=0+this->RandChar->randnum;
	return this;
}
RastgeleKarakter GenarateSentence(int number)
{
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	this->Rsentence=malloc(sizeof(int)*number);
	for(int i=0;i<number;i++)
	{
		RastgeleKarakter character=GenarateChar();
		this->Rsentence[i]=character->Rcharacter;
		this->RandChar=RandomCreate(1,100000000);
		for(int j=0;j<this->RandChar->randnum;j++);
	}
	return this;
}
RastgeleKarakter SpecialGenarateSentence(int character1,int character2)
{
	int max,min,number;
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	if(character1>=character2)
	{
		number=character1-character2;
		max=character1;
		min=character2;
	}
	else
	{
		number=character2-character1;
		max=character2;
		min=character1;
	}	
		
	this->RandChar=RandomCreate(number,1);
	number=this->RandChar->randnum;
	this->Rsentence=malloc(sizeof(int)*number);
	for(int i=0;i<number;i++)
	{
		this->RandChar=RandomCreate(max,min);
		this->Rcharacter=0+this->RandChar->randnum;
		this->Rsentence[i]=this->Rcharacter;
		this->RandChar=RandomCreate(1,100000000);
		for(int j=0;j<this->RandChar->randnum;j++);
	}
	return this;
}
RastgeleKarakter SpecialGenarateSentence2(char *charArray)
{
	RastgeleKarakter this;
	this = (RastgeleKarakter)malloc(sizeof(struct RASTGELEKARAKTER));
	int length=0;
	for(int i=0 ; charArray[i]!='\0' ; i++)
	{
		length++;
	}
	this->RandChar=RandomCreate(length,1);
	int length2=this->RandChar->randnum;
	this->Rsentence=malloc(sizeof(int)*length2);
	for(int i=0;i<length2;i++)
	{
		this->RandChar=RandomCreate(length-1,0);
		int a=this->RandChar->randnum;
		this->Rsentence[i]=charArray[a];
		this->RandChar=RandomCreate(1,100000000);
		for(int j=0;j<this->RandChar->randnum;j++);
	}
	return this;
}