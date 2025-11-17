# -*- coding: utf-8 -*-

#
# KT2
#
# Kysy käyttäjältä, montako lukua arvotaan.Jos käyttäjä syöttää arvon < 1, tulostuu "Virhe!"
# Tee lista ja arvo siihen em määrä lukuja  väliltä 0-20.
# Vain parilliset luvut sallitaan.
# Jos arvottiin pariton luku niin sen tilalle on arvottava uusi luku.
# Tulosta luvuista suurin ja pienein samalle riville
# Ja lopuksi tulosta arvotut luvut yhdelle riville pilkulla erotettuna
# Huomaa, että viimeisen luvun jälkeen ei tule pilkkua
#
# Esimerkkiajo ohessa
#
# Montako lukua arvotaan: 3
# Suurin: 6 ja pienin: 0
# 4,0,6
#
import random

maara = int(input("Montako lukua arvotaan:"))

counter = 0
lista = []
if (maara >1):
    while(counter != maara):
        luku = random.randint(0,20)
        while (luku % 2 != 0):
            luku = random.randint(0, 20)
        lista.append(luku)
        counter +=1
    lista.sort()
    print("Suurin: {0} ja pienin: {1}".format(lista[maara-1], lista[0]))
    print(lista[0], end= '')
    for i in range(len(lista)):
        if ( lista[i] != lista[0]):
            print(",{}".format(lista[i]), end='')
else:
    print("Virhe!")