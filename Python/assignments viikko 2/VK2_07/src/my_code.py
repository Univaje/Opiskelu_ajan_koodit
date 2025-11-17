# -*- coding: utf-8 -*-

"""
KT7

Toimeentulotukea maksetaan turvaamaan perustuslaissa tarkoitettu välttämätön toimeentuloa.
Tee ohjelma, joka laskee yksinäisen henkilön tai perheen saaman toimeentulotuen.
Ohjelma laskee tuen määrän käyttäjän syöttämälle määrälle päiviä ja tulostaa toimeentulotuen kokonaismäärän kahdella desimaalilla.
Ohjelma kysyy tuen laskemisessa tarvittavat tiedot yhdessä asumisesta ja lapsista.
Toimeentulotuen määrä lasketaan alla olevan taulukon mukaisesti kahden desimaalin tarkkuudella.
Toimeentulotuen laskemista voidaan toistaa niin monta kertaa kuin ohjelman käyttäjä haluaa. Alla on suuntaa antava esimerkki ohjelman toiminnasta.

Tuki lasketaan siis yhdelle henkilölle, ei esim avioparille


Tuen saaja

Euroa / päivä

Yksin asuva

16,18

Yksinhuoltaja


17,80

Avio- ja avopuolisot kumpikin

13,76

ya= 16.18
yh = 17.88
avio = 13.76


Jokainen 10-17-vuotias lapsi

11,33


Jokainen alle 10-vuotias lapsi

10,20

ya= 16.18
yh = 17.88
avio = 13.76
Lyli10 = 11.33
lali10 = 10.20



Tämä ohjelma laskee toimeentulotuen määrän. Alla esimerkkiajo ohjelmasta.

Koodin rakenteelle ei aseteta vaatimuksia muuten kuin, että syötteet annetaan esimerkin mukaisessa järjestyksessä
ja ohjelma laskee (tulostaa) tuen määrän oikein. Esimerkkiajosta käy ilmi. että kysymyksiä luupataan eli
ohjelma päättyy vasta kun  käyttäjä ei halua enää laskea toimeentulotukea uusilla tiedoilla.



Haluatko laskea toimeentulotuen uusilla tiedoilla (k/e): k

Asutko yksin (1) vai puolison kanssa (2) : 1

Onko sinulla/teillä alaikäisiä lapsia (k/e) : k

Kuinka monta alle 10-vuotiasta lasta : 1

Kuinka monta 10-17-vuotiasta lasta : 2

Kuinka monelle päivälle tuki lasketaan : 10



Saat toimeentulotukea 506.60 euroa

Haluatko laskea toimeentulotuen uusilla tiedoilla (k/e): e

"""
jatka = ""
while True:
    ya = 16.18
    yh = 17.80
    avio = 13.76
    lyli10 = 11.33
    lali10 = 10.20
    jatka = input("Haluatko laskea toimeentulotuen uusilla tiedoilla (k/e): ")
    if (jatka == "e"):
        break
    asuinmaara = int(input("Asutko yksin(1) vai puolison kanssa(2): "))
    if asuinmaara == 1:
        avio = 0
    else:
        ya = 0
        yh = 0
    lapsia = input("Onko sinulla / teillä alaikäisiä lapsia(k / e): ")
    if (lapsia == "k"):
        alle10 = int(input("Kuinka monta alle 10 - vuotiasta lasta: "))
        yli10 = int(input("Kuinka monta alle 10 - 17 - vuotiasta lasta: "))
    else:
        alle10 = 0
        yli10 = 0
    if (asuinmaara == 1 and lapsia == "e"):
        yh = 0
    else:
        ya = 0

    paivat = int(input("Kuinka monelle päivälle tuki lasketaan: "))

    summa = (ya*paivat)+(avio*paivat)+(yh*paivat)+(alle10*lali10*paivat)+(yli10*lyli10*paivat)
    print("Saat toimeentulotukea {0:5.2f} euroa".format(summa));
