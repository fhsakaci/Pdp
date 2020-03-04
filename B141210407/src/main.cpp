/**
* @file main.cpp
* @description ana program
* @course 1C
* @assignment 3
* @date 14/12/2019
* @author Emine Çetiner emine.cetiner@ogr.sakarya.edu.tr
*/
#include<stdio.h>
#include<stdlib.h>
#include <iostream>
#include <fstream>
#include "conio.h"
#include "btree.hpp"
using namespace std;

int main()
{
    system("CLS");
    int BenimSkor=0;
    int RakipSkor=0;
    int tursayisi=1;
    btree *benim = new btree();
    btree *rakip = new btree();

    ifstream benimFile;
    ifstream rakipFile;

    benimFile.open("benim.txt");
    int value;
    while (benimFile >> value)
    {
        benim->insert(value);
    }
    benimFile.close();
    benim->SoyCounter();

    rakipFile.open("rakip.txt");
    while (rakipFile >> value)
    {
        rakip->insert(value);
    }
    rakipFile.close();
    rakip->SoyCounter();

    
    while(tursayisi<20 && RakipSkor<5 && BenimSkor<5)
    {
        cout<<tursayisi<<". Tur\n";
        cout<<"Benim: ";
        benim->Postorder();
        cout<<"\nBenim agac toplam sayisi: "<<benim->ToplamSoySayisi()<<"\n";

        cout<<"\nRakip: ";
        rakip->Postorder();
        cout<<"\nRakip agac toplam sayisi: "<<rakip->ToplamSoySayisi()<<"\n";


        if(benim->ToplamSoySayisi() > rakip->ToplamSoySayisi())
        {
            cout<<"\n*** Maalesef oyunu kaybettiniz ***\n";
            RakipSkor++;

            rakip->insert(benim->MaxValue());
            benim->deletenode(benim->MaxValue());

            benim->insert(rakip->KokGetir());
            rakip->deletenode(rakip->KokGetir());
        }
        else if(benim->ToplamSoySayisi() < rakip->ToplamSoySayisi())
        {
            cout<<"\n*** Tebrikler oyunu kazandiniz ***\n";
            BenimSkor++;

            benim->insert(rakip->MaxValue());
            rakip->deletenode(rakip->MaxValue());

            rakip->insert(benim->KokGetir());
            benim->deletenode(benim->KokGetir());
        }
        else
        {
            cout<<"\n*** Oyun Berabere ***\n";
            rakip->insert(benim->KokGetir());
            benim->insert(rakip->KokGetir());

            rakip->deletenode(rakip->KokGetir());
            benim->deletenode(benim->KokGetir());

        }
        cout<<"Skor: "<<"Benim "<<BenimSkor<<"-"<<RakipSkor<<" Rakip"<<"\n";
        benim->SoyCounter();
        rakip->SoyCounter();
        cout<<"\n-------------------------------------------\n";
        getch();
        tursayisi++;
    }
    delete benim;
    delete rakip;
}

