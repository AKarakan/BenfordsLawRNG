/******************************************************************************
Kleiner Test
Benforsche Gesetz.
Erzeuge 1.000.000 Zahlen mit Seed
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{

    //Startzeit (rein aus Interesse wird die Laufzeit gemessen)
    clock_t start = clock();

    //anzahl der Durchgänge --- spätere version einfügbar 
    int durchgaenge = 1000000;
    printf("Benfofrds Law Test mit %d an Zahlen mit Seed.\n", durchgaenge);

    //counter der jeweiligen Ziffer
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    int count9 = 0;

    //Nicht verwertbare Zahlen
    int nichtVerwertbar = 0;

    //aktuelle Zufallszahl
    int zahl = 0;
    for(int i = 0; i<=durchgaenge; i++)
    {
        //Fortschritsanzeige
        printf ("\rDruchgang: %d von %d",i,durchgaenge);
        fflush(stdout);
        
        //"Seeding" den Generator bei jedem durchlauf neu
        srand(time(NULL));

        //Erzeugung der Zufallszahl
        zahl = rand();

        //Reduktion auf die Anfangsziffer
        while(zahl>10){
            zahl = zahl %10;
        }
        
        
        //Einordnung und Auswerten der Aiffer
        switch(zahl){
            case 1: 
                count1++;
            break;
            
            case 2: 
                count2++;
            break;
            
            case 3: 
                count3++;
            break;
            
            case 4: 
                count4++;
            break;
            
            case 5: 
                count5++;
            break;
            
            case 6: 
                count6++;
            break;
            
            case 7: 
                count7++;
            break;
            
            case 8: 
                count8++;
            break;    
                        
            case 9: 
                count9++;
            break;
            
            default:
                nichtVerwertbar++;
            break;
        }
    }

    //Nicht verwertbare Zahlen werden Abgezogen
    int neuDurchgang = durchgaenge;
    durchgaenge = durchgaenge - nichtVerwertbar;
    
    //Ergebnisausgabe und Prozentberechnung
    printf("\nVon %d starteten %d mit 1 (%.2f%%)\n", durchgaenge, count1, (100.0 / (float)durchgaenge) * (float)count1);
    printf("Von %d starteten %d mit 2 (%.2f%%)\n", durchgaenge, count2, (100.0 / (float)durchgaenge) * (float)count2);
    printf("Von %d starteten %d mit 3 (%.2f%%)\n", durchgaenge, count3, (100.0 / (float)durchgaenge) * (float)count3);
    printf("Von %d starteten %d mit 4 (%.2f%%)\n", durchgaenge, count4, (100.0 / (float)durchgaenge) * (float)count4);
    printf("Von %d starteten %d mit 5 (%.2f%%)\n", durchgaenge, count5, (100.0 / (float)durchgaenge) * (float)count5);
    printf("Von %d starteten %d mit 6 (%.2f%%)\n", durchgaenge, count6, (100.0 / (float)durchgaenge) * (float)count6);
    printf("Von %d starteten %d mit 7 (%.2f%%)\n", durchgaenge, count7, (100.0 / (float)durchgaenge) * (float)count7);
    printf("Von %d starteten %d mit 8 (%.2f%%)\n", durchgaenge, count8, (100.0 / (float)durchgaenge) * (float)count8);
    printf("Von %d starteten %d mit 9 (%.2f%%)\n", durchgaenge, count9, (100.0 / (float)durchgaenge) * (float)count9);

    printf("\nVon %d waren %d nicht verwertbar (%.2f%%)\n", neuDurchgang, nichtVerwertbar, (100.0 / (float)neuDurchgang) * (float)nichtVerwertbar);

    //Endzeit (rein aus Interesse wird die Laufzeit gemessen)
    clock_t ende = clock();
    double laufzeit = (double)(ende - start) / CLOCKS_PER_SEC;
    printf("\nDieses Programm lief %.2f Sekunden.\n",laufzeit);

    printf("\n ======>PROGRAMM BEENDET<======\n \n Druecken Sie ENTER");
    getchar();

    return 0;
}