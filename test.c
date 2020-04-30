/******************************************************************************
Kleiner Test
Benforsche Gesetz.
Erzeuge 100 Zahlen ohne Seed

*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int durchgaenge = 100;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    int count9 = 0;
    int zahl;
    for(int i = 0; i<=durchgaenge; i++)
    {
        printf ("\rDruchgang: %d von %d",i,durchgaenge);
        fflush(stdout);
        
        zahl = rand();
        while(zahl>=10){
            zahl = zahl %10;
        }
        
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
                continue;
            break;
        }
    }
    
    printf("\nVon %d starteten %d mit 1\n", durchgaenge, count1);
    printf("Von %d starteten %d mit 2\n", durchgaenge, count2);
    printf("Von %d starteten %d mit 3\n", durchgaenge, count3);
    printf("Von %d starteten %d mit 4\n", durchgaenge, count4);
    printf("Von %d starteten %d mit 5\n", durchgaenge, count5);
    printf("Von %d starteten %d mit 6\n", durchgaenge, count6);
    printf("Von %d starteten %d mit 7\n", durchgaenge, count7);
    printf("Von %d starteten %d mit 8\n", durchgaenge, count8);
    printf("Von %d starteten %d mit 9\n", durchgaenge, count9);
    

    return 0;
}