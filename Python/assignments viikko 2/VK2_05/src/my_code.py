# -*- coding: utf-8 -*-

"""

KT5

Kysy käyttäjältä kaksi lukua. Ensimmäisessä luvussa annetaan alkuarvo  lukuparille ja
toisessa montako kertaa lukuparia kasvatetaan/vähennetään.


Tulosta lukuparit allekkain for-silmukkaa käyttäen.
Vasen luku siis kasvaa ja oikea vähenee yhden verran kullakin rivillä.

Jos käyttäjä antaa luvut 10 ja 5, tulostus näyttää seuraavalta:
10,10
11,9
12,8
13,7
14,6
15,5
Eli tulostuvan lukuparin ensimmäinen arvo kasvaa ja toinen vähenee lähtien liikkeelle luvusta 10 toistuen 5 kertaa
"""
lku = int(input("Anna luku 1 :"))
Lku = int(input("Anna luku 2 :"))
lk2 = lku
for lku1 in range(0,Lku+1):
    print("{0},{1}".format(lku,lk2))
    lku += 1
    lk2 -= 1
