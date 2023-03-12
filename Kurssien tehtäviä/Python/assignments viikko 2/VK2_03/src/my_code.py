# -*- coding: utf-8 -*-

"""
KT3

Tee ohjelma, joka pyytää käyttäjää syöttämään lampotila -nimiseen muuttujaan jonkin mielivaltainen lämpötilan arvon (mieti tyyppi tarkasti kun ensin katsot alla olevaa...). Ohjelman tulee siis hyväksyä esim lämpötila 22.5.

Ohjelma tulostaa sitten seuraavasti, kun lämpötila on:

>39 tulostuu : Liian kuuma
<=39 ja >10 tulostuu : Lämmintä
<=10 ja >=0 tulostuu : Haaleaa
<0 ja >-30 tulostuu : Pakkasta
<=-30 tulostuu : Liian kylmää

Toteuta ohjelma if-elif-else -rakenteella.

Ole tarkka, että tulostat juuri sen tekstin, jota pyydettiin!
"""

lku = float(input("Anna Lämpötila : "))
if lku > 39:
    print("Liian kuuma")
elif lku <= 39 and lku > 10:
    print("Lämmintä")
elif lku <= 10 and lku >= 0:
    print("Haaleaa")
elif lku < 0 and lku > -30:
    print("Pakkasta")
else:
    print("Liian kylmää")